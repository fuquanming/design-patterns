package com.fcc.design.pattern.proxy.dynamic;

import com.fcc.design.pattern.proxy.DellMouse;
import com.fcc.design.pattern.proxy.Mouse;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 傅泉明
 * @title: JDK动态代理，实现接口：java.lang.reflect.InvocationHandler
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/19 16:03
 */
public class JdkProxyMouse implements InvocationHandler {

    private Object obj;
    public JdkProxyMouse(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理开始...");
        Object object = method.invoke(obj, args);
        System.out.println("JDK动态代理结束...");
        return object;
    }

    public Object getProxyObject() {
        Object object = Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), obj.getClass().getInterfaces(), this);
        return object;
    }


    public static void main(String[] args) {
        Mouse mouse = new DellMouse();
        JdkProxyMouse proxyMouse = new JdkProxyMouse(mouse);
        // 获取代理对象
        Mouse mouse1 = (Mouse) proxyMouse.getProxyObject();
        mouse1.onClick();

    }
}
