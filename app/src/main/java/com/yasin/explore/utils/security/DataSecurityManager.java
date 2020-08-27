package com.yasin.explore.utils.security;




/**
 * create by yasin
 * email yasinleng@163.com
 */
public class DataSecurityManager {
    private static final int MD5=1;




    private volatile static DataSecurityManager instance;

    private DataSecurity security;

    private DataSecurityManager() {
        security= new DefaultDataSecurity();
    }

    public static DataSecurityManager getInstance() {
        if (instance == null) {
            synchronized (DataSecurityManager.class) {
                if (instance == null) {
                    instance = new DataSecurityManager();
                }
            }
        }
        return instance;
    }


    public DataSecurityManager initSecurity(DataSecurity security){
        this.security=security;
        return instance;
    }



    void encrypt(String message,String key){

    }




}
