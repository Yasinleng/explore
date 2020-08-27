package com.yasin.explore.utils.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class GsonJsonParse implements JsonParse {
    private Gson gson;

    public GsonJsonParse() {
        gson=new Gson();
    }


    @Override
    public <T> String toJsonString(T object) {
        if (object instanceof List){
            return gson.toJson(object,new TypeToken<List<Object>>(){}.getType());
        }
        return gson.toJson(gson);
    }

    @Override
    public <T> T toObject(String json, Class<T> clazz) {
        return gson.fromJson(json,clazz);
    }

    @Override
    public <T> List<T> toObjectList(String json, Class<T> clazz) {
        Type listType = new TypeToken<List<T>>(){}.getType();
        return gson.fromJson(json, listType);
    }
}
