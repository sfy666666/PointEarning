package com.example.pointearning.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pointearning.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * created by shengfeiyu
 * on 2019/9/9
 * 自定义的底部显示的Dialog
 */
public abstract class DialogGetPictureUtil extends Dialog{


    @BindView(R.id.tv_take_picture)
    TextView tvTakePicture;
    @BindView(R.id.tv_choose_from_phone_picture)
    TextView tvChooseFromPhonePicture;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;

    private Activity activity;

    public DialogGetPictureUtil(@NonNull Activity activity) {
        super(activity,R.style.MyDialogTheme);
        this.activity =activity;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_take_picture);
        ButterKnife.bind(this);
        setViewLocation();
        setCanceledOnTouchOutside(true);//外部点击取消
    }



    @OnClick({R.id.tv_take_picture, R.id.tv_choose_from_phone_picture, R.id.tv_cancel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_take_picture:
                takePicture();
                this.cancel();
                break;
            case R.id.tv_choose_from_phone_picture:
                getPictureFormPhone();
                this.cancel();
                break;
            case R.id.tv_cancel:
                this.cancel();
                break;
        }
    }

    /**
     * 设置dialog位于屏幕底部
     */
    private void setViewLocation(){
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;

        Window window = this.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.x = 0;
        lp.y = height;
        lp.width = ViewGroup.LayoutParams.MATCH_PARENT;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        //设置背景透明 不然会出现白色直角问题   xml中用shape绘制圆角
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // 设置显示位置
        onWindowAttributesChanged(lp);
    }

    public abstract void takePicture();//拍照或视频
    public abstract void getPictureFormPhone();//从相册选择图片
}
