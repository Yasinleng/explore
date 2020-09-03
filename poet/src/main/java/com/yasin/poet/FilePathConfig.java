package com.yasin.poet;

import java.io.File;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class FilePathConfig {

    private static final String JAVA_PAHT="poet\\src\\main\\java";


    public static File javaPath(){
        return new File(JAVA_PAHT);
    }
}
