package com.example.componentbase;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

    }

    private boolean isDebug(){
        return BuildConfig.DEBUG;
    }
}
