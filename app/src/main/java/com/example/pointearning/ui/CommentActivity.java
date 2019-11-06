package com.example.pointearning.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pointearning.R;

/**
 * 发表评论页面
 */
public class CommentActivity extends BaseActivity implements View.OnClickListener {

    private Button mBtnSend;
    private TextView mTvCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        //绑定控件
        bindView();
    }

    private void bindView() {
        mBtnSend = findViewById(R.id.btn_send);
        mTvCancel = findViewById(R.id.tv_cancel);

        //注册点击监听
        mBtnSend.setOnClickListener(this);
        mTvCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                Toast toast = Toast.makeText(this, null, Toast.LENGTH_SHORT);
                toast.setText("已发送");
                toast.show();
                finish();
                break;
            case R.id.tv_cancel:
                finish();
                break;

        }
    }
}
