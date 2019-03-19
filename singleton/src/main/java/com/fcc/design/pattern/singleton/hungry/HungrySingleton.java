package com.fcc.design.pattern.singleton.hungry;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author 傅泉明
 * @title: 饿汉式,线程安全
 * @projectName design-patterns
 * @description: TODO
 * @date 2019/3/19 10:14
 */
public class HungrySingleton implements Serializable {

    private static final HungrySingleton singleton = new HungrySingleton();
    private HungrySingleton() {
        if (singleton != null) {// 防止通过反射方式获取实例
            throw new RuntimeException("不允许创建多个实例");
        }
    }
    public static HungrySingleton getInstance() {
        return singleton;
    }

    //反序列化定义该方法，而实际上创建了一个新对象，没有返回，用原来实例化的对象返回
    private Object readResolve() throws ObjectStreamException {
        return singleton;
    }

}
