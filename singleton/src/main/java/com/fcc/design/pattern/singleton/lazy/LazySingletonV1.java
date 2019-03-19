package com.fcc.design.pattern.singleton.lazy;

/**
 * @author 傅泉明
 * @title: 懒汉式，线程不安全
 * @projectName design-patterns
 * @description: 这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作
 * @date 2019/3/18 20:34
 */
public class LazySingletonV1 {

    private static LazySingletonV1 singleton = null;
    private LazySingletonV1(){}

    public static final LazySingletonV1 getInstance() {
        if (singleton == null) {
            singleton = new LazySingletonV1();
        }
        return singleton;
    }

}
