package com.example.componentbase.empty_service;

import com.example.componentbase.service.IAccountService;

public class EmptyAccountService implements IAccountService {
    //实现接口中的内容(这里只是举了个例子)
    @Override
    public boolean isLogin() {
        return false;
    }

    @Override
    public String getAccountId() {
        return null;
    }
}
