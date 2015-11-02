package com.miao.administrator.dbtest;

import android.app.Application;

/**
 * Created by Administrator on 2015/10/28.
 */
public class MyApplication extends Application {
    private static MyApplication applicationContext;
    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
    }

    public static MyApplication getInstance() {
        return applicationContext;
    }

}
