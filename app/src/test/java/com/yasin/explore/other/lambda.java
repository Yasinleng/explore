package com.yasin.explore.other;

import org.junit.Test;

/**
 * @Email: yasinleng@163.com
 * @Author: yasin
 */
public class lambda {
    @FunctionalInterface
    public interface lambdaInterface {
        void start();
    }

    @FunctionalInterface
    public interface lambdaInterface1 {
        void start(int number);
    }

    @FunctionalInterface
    public interface lambdaInterface2 {
        void start(String message);
    }

    @FunctionalInterface
    public interface lambdaInterface3 {
        void start(String message,int number);
    }

    @FunctionalInterface
    public interface lambdaInterface4 {
        int start();
    }

    @Test
    public void start(){
        //左侧函数参数，右侧函数体
//        lambdaInterface1 lambdaInterface2=new lambdaInterface1() {
//            @Override
//            public void start(int number) {
//                System.out.println(number);
//            }
//        };
//        lambdaInterface2.start(9);
//        lambdaInterface lambdaInterface=()-> System.out.println(1);
//        lambdaInterface.start();

        lambdaInterface1 lambdaInterface1=(x)-> {System.out.println(x);};
        //一个参数，括号可以省略
//        lambdaInterface1 lambdaInterface1=x-> System.out.println(x);
        lambdaInterface1.start(6);

        lambdaInterface4 lambda1=()->{
            System.out.println("有返回值");
            return 2;
        };

        lambda1.start();

        lambdaInterface4 lambda2=()-> 2;
        lambda1.start();


    }
}
