package com.fcc.design.pattern.proxy;

/**
 * @author 傅泉明
 * @title: 静态代理
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/19 16:00
 */
public class StaticProxyMouse {
    private Mouse mouse;
    public StaticProxyMouse(Mouse mouse) {
        this.mouse = mouse;
    }

    public void onClick() {
        System.out.println("开始点击...");
        mouse.onClick();
        System.out.println("结束点击...");
    }

    public static void main(String[] args) {
        Mouse mouse = new DellMouse();
        StaticProxyMouse staticProxyMouse = new StaticProxyMouse(mouse);
        staticProxyMouse.onClick();
    }

}
