package com.yasin.explore.utils.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class Md5DataSecurity implements DataSecurity {
    @Override
    public String encrypt(String message, String key, int type) {
        String md5="md5";
        try {
            MessageDigest instance = MessageDigest.getInstance(md5);
            byte[] bytes = instance.digest(message.getBytes());
            StringBuffer buffer=new StringBuffer();
            for (byte b:bytes){
                String temp=Integer.toHexString(b & 0xff);
                if (temp.length()==1)buffer.append(0);
                buffer.append(temp);
            }
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String decode(String password, int type) {
        return null;
    }
}
