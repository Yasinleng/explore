package com.yasin.explore.utils.json;

import java.util.List;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public interface JsonParse {
    /**
     * 把对象转成json字符串
     * @param object
     * @return
     */
    <T> String toJsonString(T object);

    /**
     * 把json 转换成对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T toObject(String json, Class<T> clazz);


    /**
     * 把json 转换成集合
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    <T> List<T> toObjectList(String json, Class<T> clazz);
}
