package com.fcc.design.pattern.adapter;

import java.util.Map;

/**
 * @author 傅泉明
 * @title: LoginForQQAdapter
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/20 10:24
 */
public class LoginForQQAdapter implements LoginAdapter {
    @Override
    public boolean support(Object adapter) {
        return adapter instanceof LoginForQQAdapter;
    }

    @Override
    public void login(Map<String, Object> params) {
        System.out.println("LoginForQQ...");
    }
}
