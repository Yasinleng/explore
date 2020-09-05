package com.yasin.explore.create.factory;

import android.util.ArrayMap;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class Factory {
    @Test
    public void start(){

        AbstractFactory factory=new DefaultFactory();
        Student student = factory.create(Student.class,"张三",5);
        System.out.println(student.toString());

    }
}


class DefaultFactory implements AbstractFactory{

    private static Map<Class,Class> classMap;

    static {
        classMap=new HashMap<>();
        classMap.put(Integer.class,int.class);
        classMap.put(Byte.class,byte.class);
        classMap.put(Boolean.class,boolean.class);
        classMap.put(Short.class,short.class);
        classMap.put(Float.class,float.class);
        classMap.put(Double.class,double.class);
        classMap.put(Character.class,char.class);
        classMap.put(Long.class,long.class);
    }

    @Override
    public <T> T create(Class<T> tClass, Object... parameter) {
        try {
            if (parameter.length>0){
                Class[] classes = new Class[parameter.length];
                for (int i = 0; i < parameter.length; i++) {
                    classes[i] = getClass(parameter[i].getClass());
                }
                Constructor<T> constructor = tClass.getDeclaredConstructor(classes);
                if (!constructor.isAccessible()) constructor.setAccessible(true);
                return constructor.newInstance(parameter);
            }
            return tClass.newInstance();
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Class<?> getClass(Class<?> clazz){
       Class<?> temp=classMap.get(clazz);
       if (temp!=null) return temp;
       return clazz;
    }

}


class Student{
    private String name;
    private int age;
    private String address;

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
        System.out.println("3 参构成函数");

    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("2 参构成函数");

    }

    public Student(String name) {
        this.name = name;
        System.out.println("1 参构成函数");

    }

    public Student() {
        System.out.println("无参构成函数");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}



interface AbstractFactory{
   <T> T create(Class<T> tClass,Object... parameter);
}

interface Animal{
    void eat();
}

interface Person{
    void eat();
}


class Person1 implements Person{

    @Override
    public void eat() {
        System.out.println("Person1 eat");
    }
}



