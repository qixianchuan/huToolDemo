package com.qi;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.TypeUtil;
import cn.hutool.extra.emoji.EmojiUtil;
import com.qi.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author ：qixianchuan
 * @date ：Created in 2019-05-24 15:26
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests4 {

    @Test
    public void Test1() {
        Stream<String> stream = Stream.of("张三", "李四", "王五", "赵六", "田七");
        //使用Stream流中的方法forEach对Stream流中的数据进行遍历
        stream.forEach((String name) -> {
            System.out.println(name);
        });
    }

    @Test
    public void Test2() {
        //创建一个Stream流
        Stream<String> stream = Stream.of("张三丰", "张翠山", "赵敏", "周芷若", "张无忌");
        //对Stream流中的元素进行过滤,只要姓张的人
        Stream<String> stream2 = stream.filter((String name) -> {
            return name.startsWith("张");
        });
        //遍历stream2流
        stream2.forEach(name -> System.out.println(name));

        /*
            Stream流属于管道流,只能被消费(使用)一次
            第一个Stream流调用完毕方法,数据就会流转到下一个Stream上
            而这时第一个Stream流已经使用完毕,就会关闭了
            所以第一个Stream流就不能再调用方法了
            IllegalStateException: stream has already been operated upon or closed
         */
        //遍历stream流
        //以下代码会报错 llegalStateException: stream has already been operated upon or closed
//        stream.forEach(name-> System.out.println(name));
    }

    /*
    Stream流中的常用方法_map:用于类型转换
    如果需要将流中的元素映射到另一个流中，可以使用map方法.
    <R> Stream<R> map(Function<? super T, ? extends R> mapper);
    该接口需要一个Function函数式接口参数，可以将当前流中的T类型数据转换为另一种R类型的流。
    Function中的抽象方法:
        R apply(T t);
    */

    @Test
    public void Test3() {
        //获取一个String类型的Stream流
        Stream<String> stream = Stream.of("1", "2", "3", "4");
        //使用map方法,把字符串类型的整数,转换(映射)为Integer类型的整数
        Stream<Integer> stream2 = stream.map((String s) -> {
            return Integer.parseInt(s);
        });
        //遍历Stream2流
        stream2.forEach(i -> System.out.println(i));
    }

    @Test
    public void Test4() {
        //获取一个Stream流
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        Stream<Integer> stream = list.stream();
        long count = stream.count();
        System.out.println(count);//7
    }

    /*
    Stream流中的常用方法_limit:用于截取流中的元素
    limit方法可以对流进行截取，只取用前n个。方法签名：
    Stream<T> limit(long maxSize);
        参数是一个long型，如果集合当前长度大于参数则进行截取；否则不进行操作
    limit方法是一个延迟方法,只是对流中的元素进行截取,返回的是一个新的流,所以可以继续调用Stream流中的其他方法
 */
    @Test
    public void Test5() {
        //获取一个Stream流
        String[] arr = {"美羊羊", "喜洋洋", "懒洋洋", "灰太狼", "红太狼"};
        Stream<String> stream = Stream.of(arr);
        //使用limit对Stream流中的元素进行截取,只要前3个元素
        Stream<String> stream2 = stream.limit(3);
        //遍历stream2流
        stream2.forEach(name -> System.out.println(name));
    }

    @Test
    public void Test6() {
        //第一支队伍
        ArrayList<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("石破天");
        one.add("石中玉");
        one.add("老子");
        one.add("庄子");
        one.add("洪七公");
        //1. 第一个队伍只要名字为3个字的成员姓名；存储到一个新集合中。
        //2. 第一个队伍筛选之后只要前3个人；存储到一个新集合中。
        Stream<String> oneStream = one.stream().filter(name -> name.length() == 3).limit(3);

//        oneStream.forEach((String name) -> {
//            System.out.println(name);
//        });

        //第二支队伍
        ArrayList<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("赵丽颖");
        two.add("张三丰");
        two.add("尼古拉斯赵四");
        two.add("张天爱");
        two.add("张二狗");
        //3. 第二个队伍只要姓张的成员姓名；存储到一个新集合中。
        //4. 第二个队伍筛选之后不要前2个人；存储到一个新集合中。
        Stream<String> twoStream = two.stream().filter(name -> name.startsWith("张")).skip(2);

        //5. 将两个队伍合并为一个队伍；存储到一个新集合中。
        //6. 根据姓名创建Person对象；存储到一个新集合中。
        //7. 打印整个队伍的Person对象信息。
        Stream.concat(oneStream, twoStream).map(name -> new Person(name)).forEach(p -> System.out.println(p));
    }
    @Test
    public void TestX(){
        String str = "sdfsdfsefbfgdgde";
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        //forr 倒序
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.println(chars[i]);
        }
    }
}
