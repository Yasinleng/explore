package com.yasin.explore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.yasin.explore.utils.image.load.ImageConfig;
import com.yasin.explore.utils.image.load.ImageLoaderManager;
import com.yasin.explore.utils.image.load.LoadImageConfig;

public class MainActivity extends AppCompatActivity {

//    I/id1234: https://t-youpin.quanhoo.cn/txcloud/biz/after/20200806/55295777-5c63-4d96-9b17-7ecd3d7c43da4456373922110971020.jpg
//    I/id1234: https://t-youpin.quanhoo.cn/txcloud/biz/after/20200813/0e9d885c-d6a7-4211-b315-c372d15c7f726758572739270479401.jpg
//    I/id1234: https://t-youpin.quanhoo.cn/txcloud/biz/after/20200729/147bcc66-6a42-400b-a2c2-5a3bb2ff9ebd5937440132523899808.jpg
//    I/id1234: https://t-youpin.quanhoo.cn/txcloud/biz/after/20200811/a2383725-9571-4878-9b60-ca7de13c183a3697904494515354447.jpeg
//    I/id1234: https://t-youpin.quanhoo.cn/txcloud/biz/after/20200811/4d365312-832b-4c21-8b8a-863afc16cf034978921428327752158.jpeg

    private ImageView image;
    private String url="https://t-youpin.quanhoo.cn/txcloud/biz/after/20200811/4d365312-832b-4c21-8b8a-863afc16cf034978921428327752158.jpeg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image=findViewById(R.id.image);

        ImageLoaderManager.getInstance().init(() -> new LoadImageConfig.Builder().setCornerRadius(50,150,250,0).build());
        ImageLoaderManager.getInstance().loadImage(image,url);
    }
}
