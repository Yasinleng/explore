package com.yasin.explore.create.factory.abstractfactory;


import org.junit.Test;

/**
 * @Email: yasinleng@163.com
 * @Author: yasin
 */
public class FactoryAbstract {
    @Test
    public void start(){
        AbstractFactory factory=new Factory1();
        factory.createFruits().eat();
        factory.createProduct().packing();

        factory=new Factory2();
        factory.createProduct().packing();
        factory.createFruits().eat();
    }
}

interface Product{
    void packing();
}

interface Fruits{
    void eat();
}

interface AbstractFactory{

    Product createProduct();
    Fruits createFruits();
}

class Factory1 implements AbstractFactory{

    @Override
    public Product createProduct() {
        return new Product1();
    }

    @Override
    public Fruits createFruits() {
        return new Fruits1();
    }
}

class Factory2 implements AbstractFactory{

    @Override
    public Product createProduct() {
        return new Product2();
    }

    @Override
    public Fruits createFruits() {
        return new Fruits1();
    }
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

class Fruits1 implements Fruits{
    @Override
    public void eat() {
        System.out.println("吃 Fruits1");
    }
}

class Fruits2 implements Fruits{
    @Override
    public void eat() {
        System.out.println("吃 Fruits2");
    }
}

