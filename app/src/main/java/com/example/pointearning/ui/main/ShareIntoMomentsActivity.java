package com.example.pointearning.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.pointearning.R;
import com.example.pointearning.ui.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 发表动态
 */

public class ShareIntoMomentsActivity extends BaseActivity {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.btn_send)
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_into_moments);
        ButterKnife.bind(this);
        //绑定控件

        //选择照片

        //发送


    }

    @OnClick({R.id.back, R.id.btn_send})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.btn_send:
                Toast toast = Toast.makeText(ShareIntoMomentsActivity.this, null, Toast.LENGTH_SHORT);
                toast.setText("已发表");
                toast.show();
                finish();
                break;
        }
    }
}
