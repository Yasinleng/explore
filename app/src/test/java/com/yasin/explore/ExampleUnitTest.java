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
import java.util.Random;

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

    @Test
    public void Test(){
        String a="qe";
        String b="abquqe";
        int count=0;

        for (int i=0;i<b.length();i++){
            int index=0;
            for (int j=0;j<a.length();j++){
                count++;
                if (b.charAt(i+j)==a.charAt(j)){
                    index++;
                }else {
                    break;
                }
            }
            if (index==a.length()){
                System.out.println("第一次位置"+i);
                break;
            }
        }

        System.out.println("count = "+count);
    }


    @Test
    public void test(){
        System.out.println(" 个数 = "+sum(3));

    }
    public int  sum(int n){
       if (n==1){
           return 1;
       }else {
           return n*n+sum(n-1);
       }
    }

    @Test
    public void count(){
        float vHour=180/6*60;
        float vMinute=360/60;
        int timeMinute=24*60;
        int count=0;
        for (int i=1;i<timeMinute;i++){
            if ((vMinute*i)%360==(vHour*i)%360){
                count++;
            }
        }
        System.out.println("次数 = "+count);
    }

    @Test
    public void day(){
        day(19);
    }

    public void day(int number){
        int day=0;
        int[] count={1,3,2};
        Random random=new Random();
        while (number>0){
            number=number-count[random.nextInt(count.length)];
            day++;
        }
        System.out.println("天数 = "+day);
    }

}