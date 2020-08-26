package com.yasin.explore.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.annotation.IntDef;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class SizeUtils {

    public static final int PX = 0;
    public static final int DP = 1;
    public static final int SP = 2;
    public static final int PT = 3;
    public static final int IN = 4;
    public static final int MM = 5;

    @IntDef({PX, DP,SP,PT,IN,MM})
    @Retention(RetentionPolicy.SOURCE)
    @interface SizeUnit {}

    public static float size(int value,@SizeUnit int unit){
        if (metrics==null)
            throw new InitException("请 init() 初始化");

        switch (unit) {
            case PX:
                return value;
            case DP:
                return value * metrics.density;
            case SP:
                return value * metrics.scaledDensity;
            case PT:
                return value * metrics.xdpi * (1.0f/72);
            case IN:
                return value * metrics.xdpi;
            case MM:
                return value * metrics.xdpi * (1.0f/25.4f);
        }
        return 0;

    }


    private static DisplayMetrics metrics;

    public static void init(Context context){
        metrics=context.getResources().getDisplayMetrics();
    }
}
