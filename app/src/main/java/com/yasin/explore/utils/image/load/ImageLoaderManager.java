package com.yasin.explore.utils.image.load;

import android.widget.ImageView;

import com.yasin.explore.utils.image.load.glide.GlideImageLoader;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class ImageLoaderManager {

    private volatile static ImageLoaderManager instance;

    private ImageLoader loader;
    private ImageConfig config;

    private ImageLoaderManager() {
        loader= new GlideImageLoader();
    }

    public static ImageLoaderManager getInstance() {
        if (instance == null) {
            synchronized (ImageLoaderManager.class) {
                if (instance == null) {
                    instance = new ImageLoaderManager();
                }
            }
        }
        return instance;
    }

    public void init(ImageConfig config){
        this.config=config;
    }

    void loadImage(ImageView imageView, Object object){
        loader.loadImage(imageView,object,config.create());
    }

    void loadImage(ImageView imageView, Object object,ImageConfig config){
        if (config==null)
            throw new IllegalArgumentException("config 不能为空");
        loader.loadImage(imageView,object,config.create());
    }

}
