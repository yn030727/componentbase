package com.example.login;

import com.example.baselibs.LoginService;

public class AccountService implements LoginService {
    //1.在login组件中实现这个接口
    private  boolean login;
    private String password;

    public AccountService(boolean login , String password){
        this.login = login;
        this.password = password;
    }

    @Override
    public boolean isLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }
}
