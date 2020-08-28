package com.yasin.explore;

import android.util.Log;

import com.yasin.explore.utils.json.DefaultJsonParse;
import com.yasin.explore.utils.json.GsonJsonParse;
import com.yasin.explore.utils.json.JsonPlatform;
import com.yasin.explore.bean.User;
import com.yasin.explore.utils.security.Md5DataSecurity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void parse(){

        ArrayList<User> list=new ArrayList<>();
        for(int i=0;i<15;i++){
            list.add(new User("姓名"+i,i%3==0?"男":"女"));
        }

        int i=5;

        JsonPlatform.getInstance().initJsonParse(new GsonJsonParse());
        String result=JsonPlatform.getInstance().toJsonString(new User("姓名"+i,i%3==0?"男":"女"));
        System.out.println(result);
        System.out.println("==========================================");
        JsonPlatform.getInstance().initJsonParse(new DefaultJsonParse());
        User users = JsonPlatform.getInstance().toObject(result, User.class);
        System.out.println(users);

    }

    @Test
    public void security(){
        String message="AES加密标准又称为高级加密标准Rijndael加密法，是美国国家标准技术研究所NIST旨在取代DES的21世纪的加密标准。AES的基本要";

//        new Md5DataSecurity().encrypt()

    }


}