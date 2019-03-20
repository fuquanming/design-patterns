package com.fcc.design.pattern.adapter;

import java.util.Map;

/**
 * @author 傅泉明
 * @title: LoginAdapter
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/20 10:21
 */
public interface LoginAdapter {
    /** 是否支持适配 */
    boolean support(Object adapter);
    /**
     * 登录
     * @param params    登录参数
     */
    void login(Map<String, Object> params);
}
