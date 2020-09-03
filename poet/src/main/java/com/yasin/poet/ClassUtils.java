package com.yasin.poet;

import com.squareup.javapoet.ClassName;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class ClassUtils {

    public static ClassName getClassName(Class<?> clazz){
        return ClassName.get(clazz);

    }
}
