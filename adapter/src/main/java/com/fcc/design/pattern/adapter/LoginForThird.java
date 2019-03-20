package com.fcc.design.pattern.adapter;

import java.util.Map;

/**
 * @author 傅泉明
 * @title: 第三方登录
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/20 10:26
 */
public interface LoginForThird {
    /**
     * QQ登录
     * @param params
     */
    void loginForQQ(Map<String, Object> params);

    /**
     * 微信登录
     * @param params
     */
    void loginForWeChar(Map<String, Object> params);

}
