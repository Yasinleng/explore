package com.yasin.poet;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.ParameterSpec;
import com.squareup.javapoet.TypeName;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.lang.model.element.Modifier;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class Poet {


    public static void main(String[] args) {
        String fileName="name";

        FieldSpec name=FieldSpec.builder(String.class,fileName,Modifier.PRIVATE).build();

        String methodName=new StringBuilder("set")
                .append(fileName.substring(0,1).toUpperCase())
                .append(fileName.substring(1))
                .toString();
        ParameterSpec parameterSpec= ParameterSpec.builder(String.class,fileName).build();
        MethodSpec setName=MethodSpec.methodBuilder(methodName)
                .addModifiers(Modifier.PUBLIC)
                .addParameter(parameterSpec)
                .addStatement("this.$N = $N",fileName,fileName)
                .build();


        String getmethodName=new StringBuilder("get")
                .append(fileName.substring(0,1).toUpperCase())
                .append(fileName.substring(1))
                .toString();
        TypeName re=TypeName.get(String.class);
        MethodSpec getName=MethodSpec.methodBuilder(getmethodName)
                .addModifiers(Modifier.PUBLIC)
                .returns(re)
                .addStatement("return $N",fileName)
                .build();

        MethodSpec test=MethodSpec.methodBuilder("test")
                .addStatement("$T<$T,$T> list=new $T<>()",
                        ClassUtils.getClassName(Map.class),
                        ClassUtils.getClassName(String.class),
                        ClassUtils.getClassName(String.class),
                        ClassUtils.getClassName(HashMap.class))
                //Map<String, Class<? extends ARouterPath>> groupMap = new HashMap<>();
                .addStatement("$T<$T, $T<? extends $T>> groupMap = new $T<>()",
                        ClassUtils.getClassName(Map.class),
                        ClassUtils.getClassName(String.class),
                        ClassUtils.getClassName(Class.class),
                        ClassUtils.getClassName(FilePathConfig.class),
                        ClassUtils.getClassName(HashMap.class)
                        )
                .build();



        TypeSpec className=TypeSpec.classBuilder("Person")
                .addModifiers(Modifier.PUBLIC)
                .addField(name)
                .addMethod(setName)
                .addMethod(getName)
                .addMethod(test)
                .build();

        JavaFile file=JavaFile.builder("com.yasin.poet",className).build();

        try {
            file.writeTo(FilePathConfig.javaPath());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
