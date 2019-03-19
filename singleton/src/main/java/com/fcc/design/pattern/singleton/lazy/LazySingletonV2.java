package com.fcc.design.pattern.singleton.lazy;

/**
 * @author 傅泉明
 * @title: 懒汉式，线程安全
 * @projectName design-patterns
 * @description: 这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 * getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
 * @date 2019/3/18 20:39
 */
public class LazySingletonV2 {
    private static LazySingletonV2 singleton = null;
    private LazySingletonV2(){}

    public static final synchronized LazySingletonV2 getInstance() {
        if (singleton == null) {
            singleton = new LazySingletonV2();
        }
        return singleton;
    }

}
