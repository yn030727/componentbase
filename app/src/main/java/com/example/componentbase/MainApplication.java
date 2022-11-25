package com.example.componentbase;



import static com.alibaba.android.arouter.launcher.ARouter.init;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //ARouter后台有ILogger接口，定义了一些输出日志
        if(isDebug()){  //这两行必须放在init前面，不然就会无效
            ARouter.openLog(); //打印日志
            ARouter.openDebug(); //开启调试模式
            //PS:如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险
        }
        ARouter.init(this);//尽可能早的初始化，推荐在Application中初始化ARouter
        init(this);
    }
    private boolean isDebug(){
        return BuildConfig.DEBUG;
    }

}
