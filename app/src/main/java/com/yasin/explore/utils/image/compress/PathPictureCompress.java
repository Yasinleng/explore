package com.yasin.explore.utils.image.compress;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import static java.lang.Math.ceil;
import static java.lang.Math.sqrt;

/**
 * create by yasin
 * email yasinleng@163.com
 */
final class PathPictureCompress implements PictureCompress {

    private int size=100;

    @Override
    public void compress(String path, String save, int limit) {
        if (limit==0) limit=size;
        double limitSize=limit*1024;

        Bitmap bitmap;

        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        BitmapFactory.decodeFile(path,options);
        if (PictureCompressManager.getInstance().isDebug()) {
            Log.i(TAG, "picture height=" + options.outHeight + " width=" + options.outWidth);
            Log.i(TAG, "picture size=" + bytes2kb(options.outHeight * options.outWidth * 4));
        }
        if (options.outHeight*options.outWidth*4>limitSize){
            options.inPreferredConfig= Bitmap.Config.RGB_565; //设置色彩模式，默认值是ARGB_8888 4个字节  RGB_565  2个字节
            double num=options.outHeight*options.outWidth/limitSize;
            options.inDensity= (int) ceil(sqrt(num)); //图片本身密度
            options.inTargetDensity=1;    //要显示的密度
        }
        options.inJustDecodeBounds=false;
        bitmap= BitmapFactory.decodeFile(path,options);
        if (PictureCompressManager.getInstance().isDebug()) {
            Log.i(TAG, "compress height=" + bitmap.getHeight() + " width=" + bitmap.getWidth());
            Log.i(TAG, "compress size=" + bytes2kb(bitmap.getAllocationByteCount()));
        }
        save(bitmap,savePath(path,save),path);

    }

    private void save(Bitmap bitmap, File file, String path){
        FileOutputStream fos=null;
        try {
            fos = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
        } catch (FileNotFoundException e) {
            call(path,false,e.getMessage());
        } catch (IOException e) {
            call(path,false,e.getMessage());
        }finally {
            if (fos!=null) {
                try {
                    fos.close();
                    call(path,true,file.getPath());
                    if (PictureCompressManager.getInstance().isDebug())
                        Log.i(TAG, "compress save path = "+file.getPath());
                } catch (IOException e) {
                    call(path,false,e.getMessage());
                }

            }
        }
    }

    private void call(String key, boolean isSuccess, String result){
        List<CompressCallBack> list = PictureCompressManager.getInstance().obtainCallback(key);
        if (list==null) return;
        for (CompressCallBack callBack:list){
            callBack.callback(isSuccess,result);
        }
    }

    private File savePath(String path, String save){
        File dirFile = new File(save);
        if (!dirFile.exists()) {              //如果不存在，那就建立这个文件夹
            dirFile.mkdirs();
        }
        File temp=new File(path);
        String name=temp.getName();
        name=name.substring(0,name.indexOf("."))+"compress"+".jpg";
        return new File(save,name);
    }

    private String bytes2kb(long bytes){
        //格式化小数
        int GB= 1024 * 1024 *1024;
        int MB=1024 * 1024;
        int KB=1024;
        DecimalFormat format = new DecimalFormat("###.00");
        if (bytes / GB >= 1){
            return format.format(bytes / GB) + "GB";
        }
        else if (bytes / MB >= 1){
            return format.format(bytes / MB) + "MB";
        }
        else if (bytes / KB >= 1){
            return format.format(bytes / KB) + "KB";
        }else {
            return bytes + "B";
        }
    }
}
