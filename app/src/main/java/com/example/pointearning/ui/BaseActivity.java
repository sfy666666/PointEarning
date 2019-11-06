package com.example.pointearning.ui;


import android.os.Bundle;

import com.example.pointearning.utils.StatusBarUtil;
import com.zhy.autolayout.AutoLayoutActivity;

public class BaseActivity extends AutoLayoutActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //沉浸式状态栏
        StatusBarUtil.setTranslucentForImageView(this, null);
    }

}
