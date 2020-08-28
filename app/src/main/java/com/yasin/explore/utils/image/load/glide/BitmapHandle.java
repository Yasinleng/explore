package com.yasin.explore.utils.image.load.glide;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class BitmapHandle {

    public static Bitmap radiusBitmap(Bitmap bitmap,int topLeft, int topRight, int bottomLeft, int bottomRight){
        Bitmap radius=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(radius);

        Path path=new Path();
        path.addRoundRect(0,0,bitmap.getWidth(),bitmap.getHeight(),new float[] { topLeft/2, topLeft/2,topRight/2, topRight/2,
                bottomRight/2, bottomRight/2,bottomLeft/2, bottomLeft/2, },Path.Direction.CW);
        path.close();

        Paint paint = new Paint();
        //设置TileMode的样式 CLAMP 拉伸 REPEAT 重复  MIRROR 镜像
        paint.setShader(new BitmapShader(bitmap, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        canvas.drawPath(path,paint);
        return radius;
    }


    public static Bitmap circleBitmap(Bitmap bitmap){
        int size = Math.min(bitmap.getWidth(), bitmap.getHeight());

        Bitmap circle=Bitmap.createBitmap(size,size, Bitmap.Config.ARGB_8888);
        Canvas canvas=new Canvas(circle);

        int x = (bitmap.getWidth() - size) / 2;
        int y = (bitmap.getHeight() - size) / 2;
        //创建新的bitmaop
        Bitmap square = Bitmap.createBitmap(bitmap, x, y, size, size);
        Paint paint = new Paint();
        //设置TileMode的样式 CLAMP 拉伸 REPEAT 重复  MIRROR 镜像
        paint.setShader(new BitmapShader(square, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        int radius=size/2;
        canvas.drawCircle(radius,radius,radius,paint);
        return circle;
    }
}
