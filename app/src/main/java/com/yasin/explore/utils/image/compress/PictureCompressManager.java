package com.yasin.explore.utils.image.compress;

import android.util.SparseArray;

import java.util.ArrayList;
import java.util.List;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class PictureCompressManager {

    private volatile static PictureCompressManager instance;

    private PictureCompress compress;

    private SparseArray<List<CompressCallBack>> calls;

    private boolean isDebug=false;



    private PictureCompressManager() {
        compress= new PathPictureCompress();
        calls=new SparseArray<>();
    }

    public static PictureCompressManager getInstance() {
        if (instance == null) {
            synchronized (PictureCompressManager.class) {
                if (instance == null) {
                    instance = new PictureCompressManager();
                }
            }
        }
        return instance;
    }

    public void compress(String path, String save, int limit){
        compress.compress(path, save, limit);
    }


    public void compress(String path, String save, int limit,PictureCompress compress){
        compress.compress(path, save, limit);
    }


    public void addCompressCallBack(String path, CompressCallBack compressCallBack){
        List<CompressCallBack> list = calls.get(path.hashCode());
        if (list==null) {
            list=new ArrayList<>();
            calls.put(path.hashCode(),list);
        }
        list.add(compressCallBack);
    }

    public List<CompressCallBack> obtainCallback(String path){
        return calls.get(path.hashCode());
    }

    public void setDebug(boolean isDebug){
        this.isDebug=isDebug;
    }

    public boolean isDebug(){
        return isDebug;
    }
}
