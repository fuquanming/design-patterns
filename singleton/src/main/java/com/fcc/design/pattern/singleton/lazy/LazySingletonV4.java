package com.fcc.design.pattern.singleton.lazy;

/**
 * @author 傅泉明
 * @title: 懒汉式，线程安全，静态内部类
 * @projectName design-patterns
 * @description: 这种方式能达到双检锁方式一样的功效，但实现更简单。对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
 * 这种方式同样利用了 classloader 机制来保证初始化 instance 时只有一个线程，而这种方式是 Singleton 类被装载了，instance 不一定被初始化。
 * 因为 SingletonHolder 类没有被主动使用，只有通过显式调用 getInstance 方法时，才会显式装载 SingletonHolder 类，从而实例化 instance。
 * 想象一下，如果实例化 instance 很消耗资源，所以想让它延迟加载，另外一方面，又不希望在 Singleton 类加载时就实例化，因为不能确保 Singleton 类还可能在其他的地方被主动使用从而被加载，那么这个时候实例化 instance 显然是不合适的。
 * @date 2019/3/18 20:47
 */
public class LazySingletonV4 {
    private static class SingletonHolder {
        private static final LazySingletonV4 singleton = new LazySingletonV4();
    }

    private LazySingletonV4(){
        if (SingletonHolder.singleton != null) {// 防止通过反射方式获取实例
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    public static final LazySingletonV4 getInstance() {
        return SingletonHolder.singleton;
    }

}
