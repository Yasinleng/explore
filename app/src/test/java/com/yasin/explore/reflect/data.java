package com.yasin.explore.reflect;

import androidx.annotation.NonNull;

/**
 * create by yasin
 * email yasinleng@163.com
 */

class Person {

    private String namePrivate;
    protected String nameProtected;
    String name;
    public String namePublic;

}

class Student extends Person{
    private String namePrivateStudent;
    protected String nameProtectedStudent;
    String nameStudent;
    public String namePublicStudent;

    public final String nameFinal="冷亚城";

    public static String namestatic="静态";

    public Student(String namePrivateStudent) {
        this.namePrivateStudent = namePrivateStudent;
    }

    public void methodPublic(String message,int count){
        System.out.println("methodPublic"+message+count);

        methodPrivate(5);

    }

    //方法重载时，基本数据类型和包装数据类型是两个不同的方法
    private void methodPrivate(int number){
        System.out.println("methodPrivate int");

    }
    private void methodPrivate(Integer number){
        System.out.println("methodPrivate Integer");
    }

    protected void methodProtected(){
        System.out.println("methodProtected");

    }

    public static void methodStatic(){
        System.out.println("methodStatic");

    }

    @Override
    public String toString() {
        return "Student{" +
                "namePrivateStudent='" + namePrivateStudent + '\'' +
                ", nameProtectedStudent='" + nameProtectedStudent + '\'' +
                ", nameStudent='" + nameStudent + '\'' +
                ", namePublicStudent='" + namePublicStudent + '\'' +
                ", nameFinal='" + nameFinal + '\'' +
                '}';
    }
}



