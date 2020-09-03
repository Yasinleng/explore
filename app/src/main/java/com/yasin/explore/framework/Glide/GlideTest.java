package com.yasin.explore.framework.Glide;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yasin.explore.App;

/**
 * @Email: yasinleng@163.com
 * @Author: yasin
 */
public class GlideTest {

    public void load(){
        ImageView imageView=new ImageView(App.context);
        String url="";

        Glide.with(imageView).asGif().load(url).into(imageView);
    }
}
