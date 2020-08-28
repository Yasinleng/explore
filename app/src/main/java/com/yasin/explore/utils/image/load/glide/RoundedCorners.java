package com.yasin.explore.utils.image.load.glide;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;

import java.security.MessageDigest;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class RoundedCorners extends BitmapTransformation {

    private static final String ID = RoundedCorners.class.getName();
    private int[] radius;

    public RoundedCorners(int topLeft, int topRight, int bottomLeft, int bottomRight){
        if (radius==null) radius=new int[4];
        radius[0]=topLeft;
        radius[1]=topRight;
        radius[2]=bottomLeft;
        radius[3]=bottomRight;
    }

    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        return BitmapHandle.circleBitmap(toTransform);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof RoundedCorners;
    }

    @Override
    public int hashCode() {
        return ID.hashCode();
    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(ID.getBytes());
    }
}
