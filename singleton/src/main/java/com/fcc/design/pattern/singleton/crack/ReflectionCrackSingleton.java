package com.fcc.design.pattern.singleton.crack;

import com.fcc.design.pattern.singleton.hungry.HungrySingleton;
import com.fcc.design.pattern.singleton.lazy.LazySingletonV2;
import com.fcc.design.pattern.singleton.lazy.LazySingletonV4;

import java.lang.reflect.Constructor;

/**
 * @author 傅泉明
 * @title: 通过反射机制破解单例，枚举除外
 * @projectName design-patterns
 * @description: 用于单例模式的构造方法只加上 private，使用反射来调用其构造方法，调用 getInstance()方法
 * 通过在私有构造方法判断，实例是否已经存在，存在则抛异常。
 * @date 2019/3/19 11:08
 */
public class ReflectionCrackSingleton {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = HungrySingleton.class;
        // 获取私有构造方法
        Constructor c = clazz.getDeclaredConstructor(null);
        // 强制访问
        c.setAccessible(true);
        Object v1 = c.newInstance();
        Object v2 = c.newInstance();
        // 返回2个实例对象
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v1 == v2);

//        if (singleton != null) {// 防止通过反射方式获取实例
//            throw new RuntimeException("不允许创建多个实例");
//        }
    }

}
