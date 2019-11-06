package com.example.pointearning;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * created by shengfeiyu
 * on 2019/9/3
 */
public class BaseApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        //autolayout适配配置
        AutoLayoutConifg.getInstance().useDeviceSize();

        //Fresco初始化
        Fresco.initialize(this);

    }

    public static Context getContext() {
        return mContext;
    }
}
