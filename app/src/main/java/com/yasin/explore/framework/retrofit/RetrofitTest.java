package com.yasin.explore.framework.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Email: yasinleng@163.com
 * @Author: yasin
 */
public class RetrofitTest {

    private String host="";


    public void create(){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(host)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(RetrofitTest.class);

    }
}
