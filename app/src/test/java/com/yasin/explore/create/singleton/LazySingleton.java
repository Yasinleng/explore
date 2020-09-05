package com.yasin.explore.create.singleton;


/**
 * @Email: yasinleng@163.com
 * @Author: yasin
 *
 * 懒汉式
 */

/**
 * 线程不安全。起到了Lazy Loading的效果，但是只能在单线程下使用。
 * 如果在多线程下，一个线程进入了if (singleton == null)判断语句块，
 * 还未来得及往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例。
 * 所以在多线程环境下不可使用这种方式。
 */
class LazySingleton1 {

    private static volatile LazySingleton1 singleton;
    private LazySingleton1(){}
    public static LazySingleton1 getInstance() {
        if (singleton==null){
            singleton=new LazySingleton1();
        }
        return singleton;
    }
}

/**
 * 解决了第一种的线程不安全。效率低，每个线程在想获得类的实例时候，
 * 执行getInstance()方法都要进行同步。而其实这个方法只执行一次实例化代码就够了，
 * 后面的想获得该类实例，直接return就行了。方法进行同步效率太低要改进。
 */

class LazySingleton2 {

    private static volatile LazySingleton2 singleton;
    private LazySingleton2(){}
    public static synchronized LazySingleton2 getInstance() {
        if (singleton==null){
            singleton=new LazySingleton2();
        }
        return singleton;
    }
}

/**
 * 第二种效率低，所以摒弃同步方法，改为同步产生实例化的的代码块。
 * 但是这种同步并不能起到线程同步的作用。跟第1种实现方式遇到的情形一致，
 * 假如一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，
 * 另一个线程也通过了这个判断语句，这时便会产生多个实例。
 */
class LazySingleton3 {

    private static volatile LazySingleton3 singleton;
    private LazySingleton3(){}
    public static LazySingleton3 getInstance() {
        if (singleton == null) {
            synchronized (LazySingleton3.class) {
                singleton = new LazySingleton3();
            }
        }
        return singleton;
    }
}

/**
 * 双重检查（推荐）。我们进行了两次if (singleton == null)检查，这样就可以保证线程安全了。
 * 这样，实例化代码只用执行一次，后面再次访问时，判断if (singleton == null)，
 * 直接return实例化对象。优点：线程安全；延迟加载；效率较高。
 */
class LazySingleton4 {

    private static volatile LazySingleton4 singleton;
    private LazySingleton4(){}
    public static LazySingleton4 getInstance() {
        if (singleton == null) {
            synchronized (LazySingleton4.class) {
                if (singleton == null) {
                    singleton = new LazySingleton4();
                }
            }
        }
        return singleton;
    }
}

/**
 * 静态内部类（推荐）。这种方式跟饿汉式方式采用的机制类似，但又有不同。
 * 两者都是采用了类装载的机制来保证初始化实例时只有一个线程。
 * 不同的地方在饿汉式方式是只要Singleton类被装载就会实例化，没有Lazy-Loading的作用，
 * 而静态内部类方式在Singleton类被装载时并不会立即实例化，
 * 而是在需要实例化时，调用getInstance方法，才会装载SingletonInstance类，从而完成Singleton的实例化。
 * 类的静态属性只会在第一次加载类的时候初始化，所以在这里，JVM帮助我们保证了线程的安全性，
 * 在类进行初始化时，别的线程是无法进入的。优点：避免了线程不安全，延迟加载，效率高。
 */

class LazySingleton5 {

    private LazySingleton5(){}
    private static class LazySingleton5Instance{
        private static final LazySingleton5 INSTANCE = new LazySingleton5();
    }
    public static LazySingleton5 getInstance() {
        return LazySingleton5Instance.INSTANCE;
    }
}

