package com.yasin.explore.utils.image.load;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class LoadImageConfig {
    public static final int IMAGE = 1;
    public static final int GIF = 2;
    public static final int VIDEO = 3;

    @IntDef({IMAGE,GIF,VIDEO})
    @Retention(RetentionPolicy.SOURCE)
    @interface ResouceType {}


    //资源类型 如 图片，视频，gif
    private int resouceType;

    //默认图片
    private int placeImg;
    private int errorImg;
    private int emptyImg;

    private int[] radius;

    public void setCornerRadius(int topLeft, int topRight, int bottomLeft, int bottomRight){
        if (radius==null) radius=new int[4];
        radius[0]=topLeft;
        radius[1]=topRight;
        radius[2]=bottomLeft;
        radius[3]=bottomRight;
    }

    public int[] getRadius() {
        return radius;
    }

    public int getResouceType() {
        return resouceType;
    }

    public void setResouceType(@ResouceType int type) {
        this.resouceType = type;
    }

    public int getPlaceImg() {
        return placeImg;
    }

    public void setPlaceImg(int placeImg) {
        this.placeImg = placeImg;
    }

    public int getErrorImg() {
        return errorImg;
    }

    public void setErrorImg(int errorImg) {
        this.errorImg = errorImg;
    }

    public int getEmptyImg() {
        return emptyImg;
    }

    public void setEmptyImg(int emptyImg) {
        this.emptyImg = emptyImg;
    }
}
