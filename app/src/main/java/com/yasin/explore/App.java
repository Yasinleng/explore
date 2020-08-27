package com.yasin.explore;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.github.moduth.blockcanary.BlockCanary;
import com.github.moduth.blockcanary.BlockCanaryContext;
import com.github.moduth.blockcanary.internal.BlockInfo;

/**
 * create by yasin
 * email yasinleng@163.com
 */
public class App extends Application {


    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        BlockCanary.install(this,new BlockCanaryContext(){
            @Override
            public int provideBlockThreshold() {
                return 160;
            }

            @Override
            public void onBlock(Context context, BlockInfo blockInfo) {
                Log.d("id1234", "卡顿 blockInfo = [" + blockInfo + "]");
            }
        }).start();
    }
}
