package com.fcc.design.pattern.adapter;

import java.util.Map;

/**
 * @author 傅泉明
 * @title: LoginForWeCharAdapter
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/20 10:25
 */
public class LoginForWeCharAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForWeCharAdapter;
    }

    @Override
    public void login(Map<String, Object> params) {
        System.out.println("LoginForWeChar...");
    }
}
