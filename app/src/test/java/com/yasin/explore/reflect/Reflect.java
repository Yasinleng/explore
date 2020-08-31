package com.yasin.explore.reflect;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class Reflect {

    @Test
    public void obtainClass() throws ClassNotFoundException {
        //获取Class 对象三种方式
        //方式1
        Class<?> clazz=Class.forName("com.yasin.explore.reflect.Person");
        //方式2
//        Class<?> clazz=Person.class;
        //方式3
//        Person person=new Person();
//        Class<?> clazz=person.getClass();
        System.out.println(clazz);

    }

    @Test
    public void obtainField(){
        Class<?> clazz=Student.class;
        //clazz.getDeclaredFields() 获取当前Class 对象的所有方法包括 private，protected，public
        System.out.println("================获取所有属性=======================");
        Field[] fields = clazz.getDeclaredFields();
        //clazz.getFields  获取当前Class 对象的所有public方法包括父类
//        fields=clazz.getFields();
        for (Field field:fields) {
            System.out.println(field);
        }
        System.out.println("==================获取单个属性================");
        Field field=null;
        try {
//            field=clazz.getField("nameStudent");
            field=clazz.getDeclaredField("nameStudent");
            System.out.println(field);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void setField(){
        Student student=new Student("张三");
        System.out.println(student);

        Class<?> clazz=student.getClass();
        try {
//            System.out.println("===============给普通变量设置值================");
//            Field field=clazz.getDeclaredField("namePublicStudent");
//            if (!field.isAccessible())field.setAccessible(true);
//            //获取属性值，通过属性字段+实例对象获取，即field.get(Object)。
//            // 如果是静态变量，对象传空，即field.get(null)
//            System.out.println("获取属性 "+field.getName()+" = "+field.get(student));
//            //设置属性值，通过属性字段+实例对象获取，设置值，即field.set(Object,value)。
//            // 如果是静态变量，对象传空，即field.set(null,value)
//            field.set(student,"李四");
//            System.out.println(student);

            //反射修改 final 修饰的变量，不能改变该变量的值。如果该变量还被static修饰，
            // 则会报错java.lang.IllegalAccessException: Can not set static final
            System.out.println("===============给final变量设置值================");
            Field field=clazz.getDeclaredField("nameFinal");
            if (!field.isAccessible())field.setAccessible(true);
            //获取属性值，通过属性字段+实例对象获取，即field.get(Object)。
            // 如果是静态变量，对象传空，即field.get(null)
            System.out.println("获取属性 "+field.getName()+" = "+field.get(student));
            //设置属性值，通过属性字段+实例对象获取，设置值，即field.set(Object,value)。
            // 如果是静态变量，对象传空，即field.set(null,value)
            field.set(student,"李四");
            System.out.println(student);



//            System.out.println("================给静态变量设置值======================");
//            System.out.println(Student.namestatic);
//            Field field=clazz.getDeclaredField("namestatic");
//            if (!field.isAccessible())field.setAccessible(true);
//            field.set(null,"李四");
//            System.out.println(Student.namestatic);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void obtainMethod(){
        Student student=new Student("张三");
        student.methodPublic("调用共有方法",5);
        System.out.println(student);

        Class<?> clazz=student.getClass();
        //clazz.getDeclaredMethods() 获取当前Class 对象的所有方法包括 private，protected，public
        System.out.println("=======获取所有方法=======");
        Method[] methods = clazz.getDeclaredMethods();
        //clazz.getMethods  获取当前Class 对象的所有public方法包括父类
//        methods=clazz.getMethods();
        for (Method method:methods) {
            System.out.println(method);
        }


        System.out.println("======获取单个方法=======");
        try {
            //获取方法，需要传递方法名，参数类型，次序一致，如果是基本数据类型，基本数据类型.class  如 参数为int  参数类型为int.class  不是Integer.class
            //获取功能无参数的方法
            Method method=clazz.getMethod("methodPublic",String.class,int.class);
            if (!method.isAccessible()) method.setAccessible(true);

            method.invoke(student,"反射调用方法",8);

            System.out.println(method);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}