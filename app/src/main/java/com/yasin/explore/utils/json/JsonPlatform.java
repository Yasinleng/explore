package com.yasin.explore.utils.json;


import java.util.List;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class JsonPlatform {

    private JsonParse parse;

    private final static JsonPlatform platform=new JsonPlatform();
    private JsonPlatform(){
    }

    public static JsonPlatform getInstance(){
        return platform;
    }

    public void initJsonParse(JsonParse parse){
        this.parse=parse;

    }

    public void release(){
        parse=null;
    }


    /**
     * 把对象转成json字符串
     * @param object
     * @return
     */
    public <T> String toJsonString(T object){
        return parse.toJsonString(object);
    }

    /**
     * 把json 转换成对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T toObject(String json, Class<T> clazz){
        return parse.toObject(json, clazz);
    }


    /**
     * 把json 转换成集合
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> List<T> toObjectList(String json, Class<T> clazz){
        return parse.toObjectList(json, clazz);
    }
}
