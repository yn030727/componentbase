package com.example.login;

import android.app.Application;
import android.util.Log;

import com.example.baselibs.ServiceFactory;

public class LoginApplication extends Application {
    //补充：因为不知道什么时候其他组件就会在ServiceFactory中获得这个类，所以我们上传这个接口实现类要在项目刚刚开始的时候
    //所以就在login的application中实现上传
    @Override
    public void onCreate() {
        super.onCreate();
        ServiceFactory.getInstance().setLoginService(new AccountService(LoginUtil.isLogin,LoginUtil.password));
    }
}
