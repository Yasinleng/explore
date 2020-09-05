package com.yasin.explore.modifier.static_modifier;

import org.junit.Test;

/**
 * @Email: yasinleng@163.com
 * @Author: yasin
 */
public class StaticModifier {
    @Test
    public void start(){
        Student student=new Student();
        student.print("测试顺序");
    }
}

class Person{
    static {
        System.out.println("Person 静态代码块");
    }

    {
        System.out.println("Person 代码块");
    }

    public Person(){
        System.out.println("Person 无参构造函数");
    }
}

class Student extends Person{
    static {
        System.out.println("Student 静态代码块");
    }

    {
        System.out.println("Student 代码块");
    }

    public Student(){
        System.out.println("Student 无参构造函数");
    }

    public void print(String msg){
        System.out.println("Student print "+msg);

    }
}
