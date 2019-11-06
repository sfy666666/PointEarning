package com.example.pointearning.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pointearning.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登录
 */
public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login, R.id.tv_register, R.id.tv_forgot_password})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //登录到主页
            case R.id.login:
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_register:
                Intent intentRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intentRegister);
                break;
            case R.id.tv_forgot_password:
                Intent intentForgot = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intentForgot);
                break;
        }
    }
}
