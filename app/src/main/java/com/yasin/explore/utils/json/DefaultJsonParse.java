package com.yasin.explore.utils.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class DefaultJsonParse implements JsonParse {
    @Override
    public <T> String toJsonString(T object) {
        return null;
    }

    @Override
    public <T> T toObject(String json, Class<T> clazz) {
        try {
            JSONObject jsonObject=new JSONObject(json);
            return parse(jsonObject,clazz);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public <T> List<T> toObjectList(String json, Class<T> clazz) {
        return null;
    }


    public <T> T parse(JSONObject object,Class<T> clazz){
        try {
            T temp=clazz.newInstance();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field:fields){
                if (!field.isAccessible()) field.setAccessible(true);
                if (object.has(field.getName())){
                    Object o=object.opt(field.getName());

                    if (o instanceof JSONObject){
                        parse((JSONObject) o,field.getType());
                    }else if (o instanceof JSONArray){
                        field.set(temp, parseArray((JSONArray) o,field));
                    }else {
                        field.set(temp, object.opt(field.getName()));
                    }
                }
            }
            return temp;

        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return null;

    }

    public List parseArray(JSONArray array,Field field){
        Class genericType=null;
        if (field.getType()==List.class){
            Type type=field.getGenericType();
            if (type instanceof ParameterizedType){
                ParameterizedType pt = (ParameterizedType) type;
                // 得到泛型里的class类型对象
                genericType = (Class<?>)pt.getActualTypeArguments()[0];
            }
        }
        List list=new ArrayList();

        for (int i=0;i<array.length();i++){

            Object current=array.opt(i);
            if (current instanceof JSONObject){
                parse((JSONObject) current,genericType);
            }else {
                list.add(current);
            }

        }
        return list;
    }
}
