package com.example.componentbase;



import static com.alibaba.android.arouter.launcher.ARouter.init;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.base.BaseActivity;
import com.example.baselibs.AppConfig;
import com.example.baselibs.BaseApplication;

public class MainApplication extends BaseApplication {
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
        initover(this);
    }
    private boolean isDebug(){
        return BuildConfig.DEBUG;
    }


    @Override
    public void init(Application application) {
        for(String moduleApp : AppConfig.moduleApps){
            try{
                Class clazz = Class.forName(moduleApp);
                BaseApplication baseApplication = null;
                baseApplication = (BaseApplication) clazz.newInstance();
                baseApplication.init(this);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initover(Application application) {
        for(String moduleApp : AppConfig.moduleApps){
            try {
                Class clazz = Class.forName(moduleApp);
                BaseApplication baseApplication = null;
                baseApplication = (BaseApplication) clazz.newInstance();
                baseApplication.initover(this);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
