package com.example.componentbase.service;

public interface IAccountService {

    //是否已经登录
    boolean isLogin();
    //获取登录用户的AccountId
    String getAccountId();
}
