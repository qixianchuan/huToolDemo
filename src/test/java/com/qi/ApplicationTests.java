package com.qi;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：qixianchuan
 * @date ：Created in 2019-05-07 11:18
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Test
    //时间日期工具
    public void Test1() {
        String now = DateUtil.now();
        System.out.println("====================");
        System.out.println(now);
        String today = DateUtil.today();
        System.out.println("====================");
        System.out.println(today);

        String dateTime1 = "2018-02-18 20:53:45";
        String dateTime2 = "2018-02-18";
        String dateTime3 = "20:53:45";
        String dateTime4 = "2018-02-18 20:53";

        //将不同的格式转换为Date对象
        Date date1 = DateUtil.parse(dateTime1);
        System.out.println("date1:" + date1.toString());
        Date date2 = DateUtil.parse(dateTime2);
        System.out.println("date2:" + date2.toString());
        Date date3 = DateUtil.parse(dateTime3);
        System.out.println("date3:" + date3.toString());
        Date date4 = DateUtil.parse(dateTime4);
        System.out.println("date4:" + date4.toString());

        //使用DateUtil.parse(String,String):Date 转换为指定格式的Date对象
        Date date5 = DateUtil.parse(dateTime1, "yyyy-MM-dd");
        System.out.println("date5:" + date5.toString());
        /**
         * 使用DateUtil.formatDateTime(Date date):String 将返回“yyyy-MM-dd hh:mm:ss”格式字符串
           使用DateUtil.formatDate(Date date):String 将返回“yyyy-MM-dd“格式字符串
           使用DateUtil.formatTime(Date date):String将返回“hh:mm:ss“格式字符串
           使用DateUtil.format(Date,String):String 将返回指定格式的字符串
         * **/
        String f1 = DateUtil.formatDateTime(new Date());
        System.out.println("====================");
        System.out.println(f1);
        String f2 = DateUtil.formatDate(new Date());
        System.out.println("====================");
        System.out.println(f2);
        String f3 = DateUtil.formatTime(new Date());
        System.out.println("====================");
        System.out.println(f3);
        String f4 = DateUtil.format(new Date(),"yyyy-MM-dd");
        System.out.println("====================");
        System.out.println(f4);
    }

    @Test
    //字符串工具
    public void Test2(){
        System.out.println("====================");

    }

    @Test
    //HttpUtil
    public void Test3(){
        String url = "http://www.qipengtech.com";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("query", 10086);
        // 无参GET请求
        String result = HttpUtil.get(url);
        System.out.println("====================");
        System.out.println(result);
        // 带参GET请求
        String result2 = HttpUtil.get(url, paramMap);
        System.out.println("====================");
        System.out.println(result2);
    }
}
