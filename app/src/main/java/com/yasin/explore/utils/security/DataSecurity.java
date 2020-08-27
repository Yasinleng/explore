package com.yasin.explore.utils.security;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public interface DataSecurity {

    String encrypt(String message, String key, int type);

    String decode(String password, int type);


}
