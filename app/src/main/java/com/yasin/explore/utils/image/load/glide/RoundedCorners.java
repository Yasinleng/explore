package com.yasin.explore.utils.image.load.glide;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

import java.security.MessageDigest;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class RoundedCorners extends BitmapTransformation {

    private Paint paint;

    private int[] radius;

    public void RoundedCorners(int topLeft, int topRight, int bottomLeft, int bottomRight){
        if (radius==null) radius=new int[4];
        radius[0]=topLeft;
        radius[1]=topRight;
        radius[2]=bottomLeft;
        radius[3]=bottomRight;

        paint=new Paint();
    }

    @Override
    protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
        Canvas canvas = new Canvas(toTransform);
        Path path=new Path();
//        path.addRoundRect();

//        canvas.
        return toTransform;
    }

    @Override
    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        messageDigest.update(this.getClass().getName().getBytes());
    }
}
