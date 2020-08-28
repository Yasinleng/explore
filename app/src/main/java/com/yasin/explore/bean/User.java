package com.yasin.explore.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class User {
    private String name;
    private String type;
    private int age;

    private List<String> url;

    public User(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public User() {
        this.name = name;
        this.type = type;
    }

    public User(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;

        url=new ArrayList<>();
        url.add(name);
        url.add(type);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", age=" + age +
                ", url=" + url +
                '}';
    }
}
