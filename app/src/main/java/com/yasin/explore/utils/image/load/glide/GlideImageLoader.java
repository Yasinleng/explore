package com.yasin.explore.utils.image.load.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.yasin.explore.utils.image.load.ImageLoader;
import com.yasin.explore.utils.image.load.LoadImageConfig;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class GlideImageLoader implements ImageLoader {

    @Override
    public void loadImage(ImageView imageView, Object object, LoadImageConfig config) {

        RequestManager with = Glide.with(imageView);

        if (config!=null) {
            if (config.getResouceType()==LoadImageConfig.GIF) with.asGif();

            RequestOptions options = new RequestOptions();
            if (config.getPlaceImg()!=0) options.placeholder(config.getPlaceImg());
            if (config.getErrorImg()!=0) options.error(config.getErrorImg());
            if (config.getEmptyImg()!=0) options.fallback(config.getEmptyImg());

            if (config.getRadius()!=null){
            }


            loadResource(with, object).apply(options).into(imageView);
        }else {
            loadResource(with, object).into(imageView);
        }

    }

    private RequestBuilder<Drawable> loadResource(RequestManager with, Object object){
        RequestBuilder<Drawable> requestBuilder=null ;
        if (object instanceof String) {
            requestBuilder=with.load((String)object);
        } else if (object instanceof Integer){
            requestBuilder=with.load((Integer)object);
        } else if (object instanceof Drawable){
            requestBuilder=with.load((Drawable)object);
        } else if (object instanceof Bitmap){
            requestBuilder=with.load((Bitmap)object);
        }
        return requestBuilder;
    }
}
