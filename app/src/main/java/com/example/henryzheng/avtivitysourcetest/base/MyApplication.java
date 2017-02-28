package com.example.henryzheng.avtivitysourcetest.base;

import android.app.Application;

import utils.CCLog;

/**
 * Created by henryzheng on 2017/2/17.
 */

public class MyApplication extends Application {
    static MyApplication myApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        CCLog.print("MyApplication onCreate");
        myApplication=this;
    }

    public static Application getContext() {

        return myApplication;

    }
}
