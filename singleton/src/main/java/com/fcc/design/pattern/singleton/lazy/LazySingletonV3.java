package com.fcc.design.pattern.singleton.lazy;

/**
 * @author 傅泉明
 * @title: 懒汉式，线程安全，双检锁/双重校验锁
 * @projectName design-patterns
 * @description: 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。volatile 修饰单例变量
 * @date 2019/3/18 20:42
 */
public class LazySingletonV3 {

    private volatile static LazySingletonV3 singleton = null;
    private LazySingletonV3(){}

    public static final LazySingletonV3 getInstance() {
        if (singleton == null) {
            synchronized (LazySingletonV3.class) {
                if (singleton == null) {
                    singleton = new LazySingletonV3();
                }
            }
        }
        return singleton;
    }
}
