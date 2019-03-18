package com.fcc.design.pattern.factory;

/**
 * @author 傅泉明
 * @title: HpMouse
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/18 16:59
 */
public class HpMouse implements Mouse {
    @Override
    public void onClick() {
        System.out.println("HpMouse is onClick...");
    }
}
