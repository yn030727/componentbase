package com.example.componentbase;

import android.content.ServiceConnection;

import com.example.componentbase.empty_service.EmptyAccountService;
import com.example.componentbase.service.IAccountService;

public class ServiceFactory {

    private IAccountService accountService;//接口不能实例化是不能new

    private ServiceFactory(){
        //私有构造方法，不让外部创建当前类的实例
    }

    //通过静态内部类的方法实现ServiceFactory的单例
    public static ServiceFactory getInstance(){
        return Inner.serviceFactory;
    }
    private static class Inner{
        //内部类在类第一加载的时候就被创建(只有一次)
        private static ServiceFactory serviceFactory=new ServiceFactory();
    }

    //接收Login组件实现的Service实例
    public void setAccountService(IAccountService accountService){
        this.accountService=accountService;
    }
    //返回Login组件的Service实例
    public IAccountService getAccountService(){
        if(accountService!=null){
            accountService=new EmptyAccountService();
        }
        return accountService;
    }

    //在我们前面提到的组件化架构图中，所有的组件都是依赖Base模块，而componentbase模块也是所有组件需要依赖的
    //所以我们可以让Base模块依赖componentbase模块，这样组件中依赖Base模块后就可以访问componentbase模块中得类
}
