package com.yasin.explore.reflect;

import org.junit.Test;

import java.io.File;
import java.lang.reflect.Field;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class Reflect {

    @Test
    public void obtain() throws ClassNotFoundException {
        Class<?> clazz=Class.forName("com.yasin.explore.reflect.Person");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field:fields) {
            System.out.println(field);
        }

    }
}
