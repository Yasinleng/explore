package com.yasin.explore.utils.image.load;

import android.widget.ImageView;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public interface ImageLoader {

    /**
     *
     * @param imageView  控件
     * @param object   加载资源
     * @param config
     */
    void loadImage(ImageView imageView, Object object, LoadImageConfig config);
}
