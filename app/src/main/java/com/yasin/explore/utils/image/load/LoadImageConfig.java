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

    public LoadImageConfig(int resouceType, int placeImg, int errorImg, int emptyImg, int[] radius) {
        this.resouceType = resouceType;
        this.placeImg = placeImg;
        this.errorImg = errorImg;
        this.emptyImg = emptyImg;
        this.radius = radius;
    }

    public int getResouceType() {
        return resouceType;
    }

    public int getPlaceImg() {
        return placeImg;
    }

    public int getErrorImg() {
        return errorImg;
    }

    public int getEmptyImg() {
        return emptyImg;
    }

    public int[] getRadius() {
        return radius;
    }

    public final static class Builder{

        //资源类型 如 图片，视频，gif
        private int resouceType;

        //默认图片
        private int place;
        private int error;
        private int empty;

        private int[] radius;

        public Builder place(int place){
            this.place=place;
            return this;
        }

        public Builder error(int error){
            this.error=error;
            return this;
        }

        public Builder empty(int empty){
            this.empty=empty;
            return this;
        }
        public Builder resouceType(@ResouceType int resouceType){
            this.resouceType=resouceType;
            return this;
        }

        public Builder setCornerRadius(int topLeft, int topRight, int bottomLeft, int bottomRight){
            if (radius==null) radius=new int[4];
            radius[0]=topLeft;
            radius[1]=topRight;
            radius[2]=bottomLeft;
            radius[3]=bottomRight;

            return this;
        }

        public LoadImageConfig build(){
            return new LoadImageConfig(resouceType,place,error,empty,radius);
        }
    }
}
