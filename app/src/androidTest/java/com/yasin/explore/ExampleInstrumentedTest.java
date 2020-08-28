package com.yasin.explore;

import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.yasin.explore.bean.User;
import com.yasin.explore.utils.json.DefaultJsonParse;
import com.yasin.explore.utils.json.GsonJsonParse;
import com.yasin.explore.utils.json.JsonPlatform;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.yasin.explore", appContext.getPackageName());
    }

    @Test
    public void parse(){

        ArrayList<User> list=new ArrayList<>();
        for(int i=0;i<15;i++){
            list.add(new User("姓名"+i,i%3==0?"男":"女"));
        }

        int i=5;

        JsonPlatform.getInstance().initJsonParse(new GsonJsonParse());
        String result=JsonPlatform.getInstance().toJsonString(new User("姓名"+i,i%3==0?"男":"女",16));
        System.out.println(result);
        System.out.println("==========================================");
        JsonPlatform.getInstance().initJsonParse(new DefaultJsonParse());
        User users = JsonPlatform.getInstance().toObject(result, User.class);
        System.out.println(users);

    }


}
