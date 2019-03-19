package com.fcc.design.pattern.proxy.dynamic;

import com.fcc.design.pattern.proxy.DellMouse;
import com.fcc.design.pattern.proxy.Mouse;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 傅泉明
 * @title: CglibProxyMouse
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/19 16:14
 */
public class CglibProxyMouse implements MethodInterceptor {

    private Object obj;
    public CglibProxyMouse(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Cglib动态代理开始...");
        Object object = method.invoke(obj, objects);
        System.out.println("Cglib动态代理结束...");
        return object;
    }

    public Object getProxyObject() {
        Enhancer enhancer = new Enhancer();
        // 设置需要代理的对象
        enhancer.setSuperclass(obj.getClass());
        // 设置代理人
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public static void main(String[] args) {
        Mouse mouse = new DellMouse();
        CglibProxyMouse proxyMouse = new CglibProxyMouse(mouse);
        Mouse mouse1 = (Mouse) proxyMouse.getProxyObject();
        mouse1.onClick();
    }
}
