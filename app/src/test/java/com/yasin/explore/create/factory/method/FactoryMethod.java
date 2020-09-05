package com.yasin.explore.create.factory.method;

import org.junit.Test;

/**
 * @Email: yasinleng@163.com
 * @Author: yasin
 * 工厂方法模式
 */
public class FactoryMethod {
    @Test
    public void start(){
        AbstractFactory factory=new Product1Factory();
        factory.create().packing();

        factory=new Product2Factory();
        factory.create().packing();
    }
}

interface Product{
    void packing();
}

interface AbstractFactory{
    Product create();
}

class Product1 implements Product{
    @Override
    public void packing() {
        System.out.println("包装 Product1");
    }
}

class Product2 implements Product{
    @Override
    public void packing() {
        System.out.println("包装 Product2");
    }
}

class Product1Factory implements AbstractFactory{

    @Override
    public Product create() {
        return new Product1();
    }
}

class Product2Factory implements AbstractFactory{

    @Override
    public Product create() {
        return new Product2();
    }
}

