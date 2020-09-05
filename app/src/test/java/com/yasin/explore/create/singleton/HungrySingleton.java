package com.yasin.explore.create.singleton;



/**
 * @Email: yasinleng@163.com
 * @Author: yasin
 * 饿汉式单例
 */
class HungrySingleton1 {
    //方式1

    private static final HungrySingleton1 instance=new HungrySingleton1();
    private HungrySingleton1(){}
    public static HungrySingleton1 getInstance(){
        return instance;
    }
}
class HungrySingleton2 {
    //方式2
    private static HungrySingleton2 instance;
    static {
        instance = new HungrySingleton2();
    }
    private HungrySingleton2() {}
    public static HungrySingleton2 getInstance() {
        return instance;
    }
}
