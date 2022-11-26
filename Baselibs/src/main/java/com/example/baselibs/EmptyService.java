package com.example.baselibs;

public class EmptyService implements LoginService{
    //由于Login组件可能并没有传递过来一个实现类，share就调用get方法，为了防止异常，我们还要创建一个服务的空实现
    //当login组件并未上传实现类时，用get返回这个空实现
    @Override
    public boolean isLogin() {
        return false;
    }

    @Override
    public String getPassword() {
        return null;
    }
}
