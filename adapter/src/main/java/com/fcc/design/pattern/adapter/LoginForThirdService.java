package com.fcc.design.pattern.adapter;

import java.util.Map;

/**
 * @author 傅泉明
 * @title: LoginForThirdService
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/20 10:28
 */
public class LoginForThirdService extends LoginService implements LoginForThird {
    @Override
    public void loginForQQ(Map<String, Object> params) {
        login(params, LoginForQQAdapter.class);
    }

    @Override
    public void loginForWeChar(Map<String, Object> params) {
        login(params, LoginForWeCharAdapter.class);
    }

    public void login(Map<String, Object> params, Class<? extends LoginAdapter> clazz) {
        try {
            LoginAdapter adapter = clazz.newInstance();
            if (adapter.support(adapter)) {
                adapter.login(params);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LoginForThirdService service = new LoginForThirdService();
        service.login("张三", "123456");

        service.loginForQQ(null);

        service.loginForWeChar(null);
    }

}
