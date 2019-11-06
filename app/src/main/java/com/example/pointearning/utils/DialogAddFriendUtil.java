package com.example.pointearning.utils;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.pointearning.R;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * created by shengfeiyu
 * on 2019/9/10
 * 添加好友Dialog
 */
public  class DialogAddFriendUtil extends Dialog {


    @BindView(R.id.tv_add_friend)
    TextView tvAddFriend;
    @BindView(R.id.tv_create_group_chat)
    TextView tvCreateGroupChat;
    private Activity activity;

    public DialogAddFriendUtil(@NonNull Activity activity) {
        super(activity);
        this.activity = activity;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_dialog_add_friend);
        ButterKnife.bind(this);
        setViewLocation();
        setCanceledOnTouchOutside(true);//外部点击取消
    }


    /**
     * 设置dialog位于屏幕右上方
     */
    private void setViewLocation() {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;

        Window window = this.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.x = AutoUtils.getPercentWidthSize(350);
        //AutoLayout适配自定义View高的方法
        lp.y =  AutoUtils.getPercentHeightSize(-(getContext().getResources().getDimensionPixelSize(R.dimen.dp_235)));
        lp.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        lp.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        //设置背景透明 不然会出现白色直角问题   xml中用shape绘制圆角
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        // 设置显示位置
        onWindowAttributesChanged(lp);
    }

    public  void addFriend(){};//添加好友

    public void createGroupChat(){};//创建群聊

    @OnClick({R.id.tv_add_friend, R.id.tv_create_group_chat})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_add_friend:
                addFriend();
                this.cancel();
                break;
            case R.id.tv_create_group_chat:
                createGroupChat();
                this.cancel();
                break;
        }
    }
}
