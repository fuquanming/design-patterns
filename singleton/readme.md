## 1、单例模式

单例模式（Singleton Pattern）是 Java 中最简单的设计模式之一。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

这种模式涉及到一个单一的类，该类负责创建自己的对象，同时确保只有单个对象被创建。这个类提供了一种访问其唯一的对象的方式，可以直接访问，不需要实例化该类的对象。

**注意：**

- 1、单例类只能有一个实例。
- 2、单例类必须自己创建自己的唯一实例。
- 3、单例类必须给所有其他对象提供这一实例。

## 2、简介

**意图：**保证一个类仅有一个实例，并提供一个访问它的全局访问点。

**主要解决：**一个全局使用的类频繁地创建与销毁。

**何时使用：**当您想控制实例数目，节省系统资源的时候。

**如何解决：**判断系统是否已经有这个单例，如果有则返回，如果没有则创建。

**关键代码：**构造函数是私有的。

**应用实例：**

-  1、一个班级只有一个班主任。
-  2、Windows 是多进程多线程的，在操作一个文件的时候，就不可避免地出现多个进程或线程同时操作一个文件的现象，所以所有文件的处理必须通过唯一的实例来进行。
-  3、一些设备管理器常常设计为单例模式，比如一个电脑有两台打印机，在输出的时候就要处理不能两台打印机打印同一个文件。 

**优点：**

-  1、在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例（比如管理学院首页页面缓存）。
-  2、避免对资源的多重占用（比如写文件操作）。 

**缺点：**没有接口，不能继承，与单一职责原则冲突，一个类应该只关心内部逻辑，而不关心外面怎么样来实例化。

**使用场景：**

-  1、要求生产唯一序列号。 
-  2、WEB 中的计数器，不用每次刷新都在数据库里加一次，用单例先缓存起来。
-  3、创建的一个对象需要消耗的资源过多，比如 I/O 与数据库的连接等。

## 3、实现

我们将创建一个 *Singleton* 类。*Singleton* 类有它的私有构造函数和本身的一个静态实例。 

*Singleton* 类提供了一个静态方法，供外界获取它的静态实例。

## 4、单例模式的几种实现方式

### 1、懒汉式，线程不安全

**是否 Lazy 初始化：**是

**是否多线程安全：**否

**描述：**这种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。

~~~java
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
~~~

### 2、懒汉式，线程安全

**是否 Lazy 初始化：**是

**是否多线程安全：**是

**描述：**这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
优点：第一次调用才初始化，避免内存浪费。
缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。

~~~java
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
~~~

### 3、懒汉式，线程安全，双检锁/双重校验锁（DCL，即 double-checked locking）

**JDK 版本：**JDK1.5 起

**是否 Lazy 初始化：**是

**是否多线程安全：**是

**描述：**这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
getInstance() 的性能对应用程序很关键。

~~~java
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
~~~

### 4、懒汉式，线程安全，登记式/静态内部类

**是否 Lazy 初始化：**是

**是否多线程安全：**是

**描述：**这种方式能达到双检锁方式一样的功效，但实现更简单。对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
 这种方式同样利用了 classloader 机制来保证初始化 instance 时只有一个线程，而这种方式是  Singleton 类被装载了，instance 不一定被初始化。因为 SingletonHolder 类没有被主动使用，只有通过显式调用  getInstance 方法时，才会显式装载 SingletonHolder 类，从而实例化 instance。想象一下，如果实例化  instance 很消耗资源，所以想让它延迟加载，另外一方面，又不希望在 Singleton 类加载时就实例化，因为不能确保 Singleton  类还可能在其他的地方被主动使用从而被加载，那么这个时候实例化 instance 显然是不合适的。

~~~java
public class LazySingletonV4 {
    private static class SingletonHolder {
        private static final LazySingletonV4 singleton = new LazySingletonV4();
    }
    private LazySingletonV4(){}
    public static final LazySingletonV4 getInstance() {
        return SingletonHolder.singleton;
    }
}
~~~

### 5、饿汉式，线程安全

**是否 Lazy 初始化：**否

**是否多线程安全：**是

**描述：**这种方式比较常用，但容易产生垃圾对象。
 优点：没有加锁，执行效率会提高。
 缺点：类加载时就初始化，浪费内存。
 它基于 classloader 机制避免了多线程的同步问题，不过，instance  在类装载时就实例化，虽然导致类装载的原因有很多种，在单例模式中大多数都是调用 getInstance 方法，  但是也不能确定有其他的方式（或者其他的静态方法）导致类装载，这时候初始化 instance 显然没有达到 lazy loading 的效果。

~~~java
public class HungrySingleton {
    private static final HungrySingleton singleton = new HungrySingleton();
    private HungrySingleton() {}
    public static final HungrySingleton getInstance() {
        return singleton;
    }
}
~~~

### 6、枚举

**JDK 版本：**JDK1.5 起

**是否 Lazy 初始化：**否

**是否多线程安全：**是

**描述：**这种实现方式还没有被广泛采用，但这是实现单例模式的最佳方法。它更简洁，自动支持序列化机制，绝对防止多次实例化。
 这种方式是 Effective Java 作者 Josh Bloch  提倡的方式，它不仅能避免多线程同步问题，而且还自动支持序列化机制，防止反序列化重新创建新的对象，绝对防止多次实例化。不过，由于 JDK1.5  之后才加入 enum 特性，用这种方式写不免让人感觉生疏，在实际工作中，也很少用。
不能通过 reflection attack 来调用私有构造方法。

~~~java
public enum SingletonEnum {
    singleton;
    private Object data;
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public static SingletonEnum getInstance(){
        return singleton;
    }
}
~~~

- **1、反射机制无法破解枚举的单例，枚举式单例在静态代码块中就给 singleton进行了赋值，是饿汉式单例的实现**
- **2、反序列化无法破解枚举的单例，在反序列化时，JDK已经做了过滤不能反序列化枚举**

## 5、破坏单例的几种实现方式

### 1、反射机制破解单例（枚举除外）

上面介绍的单例模式的构造方法除了加上 private 以外，没有做任何处理。如果我们使用反射来调用其构造方法，然后，再调用 getInstance()方法，应该就会两个不同的实例。

~~~java
public class ReflectionCrackSingleton {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = LazySingletonV2.class;
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
    }
}
~~~

避免上述漏洞，在构造方法判断实时是否已经生成：

~~~java
public class HungrySingleton {
    private static final HungrySingleton singleton = new HungrySingleton();
    private HungrySingleton() {
        if (singleton != null) {// 防止通过反射方式获取实例
            throw new RuntimeException("不允许创建多个实例");
        }
    }
    public static HungrySingleton getInstance() {
        return singleton;
    }
}
~~~

### 2、反序列化破解单例（枚举除外）

反序列化
将已经持久化的字节码内容，转换为 IO 流；通过 IO 流的读取，进而将读取的内容转换为 Java 对象，
**在转换过程中会重新创建对象**

~~~java
public class SerializationCrackSingleton {
    public static void main(String[] args) {
        // s1和s2是同一个实例
        HungrySingleton s1 = HungrySingleton.getInstance();
        HungrySingleton s2 = HungrySingleton.getInstance();
        System.out.println(s1 == s2);
        // 将s2写入磁盘
        ObjectOutputStream os = null;
        ObjectInputStream is = null;
        try {
            String fileName = "HungrySingleton.obj";
            os = new ObjectOutputStream(new FileOutputStream(fileName));
            os.writeObject(s2);
            os.flush();
            os.close();
            // 将s2读出
            is = new ObjectInputStream(new FileInputStream(fileName));
            s1  = (HungrySingleton) is.readObject();
            System.out.println(s1 == s2);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (os != null) os.close();
                if (is != null) is.close();
            } catch (Exception e) {e.printStackTrace();}
        }
    }
}
~~~

避免上述漏洞，添加方法readResolve，ObjectInputStream会判断对象是否有readResolve方法，有则调用对象的readResolve，而实际上创建了一个新对象，没有返回，用原来实例化的对象返回

返回该实例：

~~~java
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
~~~

