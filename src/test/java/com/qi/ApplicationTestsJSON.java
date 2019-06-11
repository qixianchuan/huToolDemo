package com.qi;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.qi.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：qixianchuan
 * @date ：Created in 2019-05-07 11:18
 * @description：huTool json测试
 * @modified By：
 * @version: $version$
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTestsJSON {
    /**
     * JSONUtil方法
     **/
    @Test
    public void Test1() {
        List<String> stringList = new ArrayList<>();
        stringList.add("测试1");
        stringList.add("测试2");
        stringList.add("测试3");

        String json = JSONUtil.toJsonStr(stringList);
        System.out.println("====================");
        System.out.println("测试json1:" + json);

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("测试人1"));
        personList.add(new Person("测试人2"));
        personList.add(new Person("测试人3"));
        String toJsonStr = JSONUtil.toJsonStr(personList);
        System.out.println("====================");
        System.out.println("测试json2:" + toJsonStr);
        String formatJsonStr = JSONUtil.formatJsonStr(toJsonStr);
        System.out.println("====================");
        System.out.println("格式化后的formatJsonStr:" + formatJsonStr);
        JSONArray objects = JSONUtil.parseArray(toJsonStr);
        List<Person> personList1 = JSONUtil.toList(objects, Person.class);
        System.out.println("====================");
        System.out.println("jsonStr还原list:" + personList1);
    }

    /**
     * JSONObject
     **/
    @Test
    public void Test2() {
        JSONObject json1 = JSONUtil.createObj();
        json1.put("a", "value1");
        json1.put("b", "value2");
        json1.put("c", "value3");

        String jsonStr = "{\"b\":\"value2\",\"c\":\"value3\",\"a\":\"value1\"}";
        //方法一：使用工具类转换
        JSONObject jsonObject = JSONUtil.parseObj(jsonStr);
        //方法二：new的方式转换
        JSONObject jsonObject2 = new JSONObject(jsonStr);
        //JSON对象转字符串
        String s = jsonObject.toString();
        System.out.println("====================");
        System.out.println("JSON对象转字符串:" + s);
    }

    /**
     * JSONArray
     **/
    @Test
    public void Test3() {
        //方法1
        JSONArray array = JSONUtil.createArray();
        //方法2
        JSONArray array1 = new JSONArray();

        array.add("value1");
        array.add("value2");
        array.add("value3");
        //转为JSONArray字符串
        array.toString();

        String jsonStr = "[\"value1\", \"value2\", \"value3\"]";
        JSONArray array2 = JSONUtil.parseArray(jsonStr);

        System.out.println("====================");
        System.out.println("转为JSONArray字符串:" + array2);
    }
}
