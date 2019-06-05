package com.qi;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.TypeUtil;
import cn.hutool.extra.emoji.EmojiUtil;
import cn.hutool.extra.tokenizer.Result;
import cn.hutool.extra.tokenizer.TokenizerEngine;
import cn.hutool.extra.tokenizer.TokenizerUtil;
import cn.hutool.extra.tokenizer.Word;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author ：qixianchuan
 * @date ：Created in 2019-05-24 15:26
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests3 {

    /**类型转换工具类-Convert**/
    @Test
    public void Test1(){
        // 转换为字符串
        int a = 1;
        //aStr为"1"
        String aStr = Convert.toStr(a);
        long[] b = {1,2,3,4,5};
        //bStr为："[1, 2, 3, 4, 5]"
        String bStr = Convert.toStr(b);

        String a2 = "2017-05-06";
        Date value = Convert.toDate(a2);
        System.out.println("====================");
        System.out.println(value);

        //转换为集合
        Object[] a3 = {"a", "你", "好", "", 1};
        List<?> list1 = Convert.convert(List.class, a3);
        System.out.println("====================");
        System.out.println(list1);
        //从4.1.11开始可以这么用
        List<?> list2 = Convert.toList(a3);
        System.out.println("====================");
        System.out.println(list2);
    }

    //test2 有问题，报错，还不知道为什么
//    /**中文分词封装-TokenizerUtil**/
//    @Test
//    public void Test2(){
//        //自动根据用户引入的分词库的jar来自动选择使用的引擎
//        TokenizerEngine engine = TokenizerUtil.createEngine();
//        //解析文本
//        String text = "这两个方法的区别在于返回值";
//        Result result = engine.parse(text);
//        //输出：这 两个 方法 的 区别 在于 返回 值
//        String resultStr = CollUtil.join((Iterator<Word>)result, " ");
//        System.out.println(resultStr);
//    }

    /**
     * 考虑到MySQL等数据库中普通的UTF8编码并不支持Emoji（只有utf8mb4支持），
     * 因此对于数据中的Emoji字符进行处理（转换、清除）变成一项必要工作。
     * 因此Hutool基于emoji-java库提供了Emoji工具实现。
       此工具在Hutoo-4.2.1之后版本可用。
     * **/
    @Test
    public void Test3(){
        //转义Emoji字符
        String alias = EmojiUtil.toAlias("😄");//:smile:
        System.out.println("====================");
        System.out.println(alias);
        //将转义的别名转为Emoji字符
        String emoji = EmojiUtil.toUnicode(":smile:");//😄
        System.out.println("====================");
        System.out.println(emoji);
        //将字符串中的Unicode Emoji字符转换为HTML表现形式
        String alias1 = EmojiUtil.toHtml("😄");//&#128102;
        System.out.println(alias1);
    }

    /**泛型类型工具-TypeUtil
     *
     * 针对 java.lang.reflect.Type 的工具类封装，最主要功能包括：
       获取方法的参数和返回值类型（包括Type和Class）
       获取泛型参数类型（包括对象的泛型参数或集合元素的泛型类型）
     **/
    @Test
    public void Test4(){
        /**getParamType**/
        Method method = ReflectUtil.getMethod(TestClass.class, "intTest", Integer.class);
        Type type = TypeUtil.getParamType(method, 0);
        // 结果：Integer.class
        System.out.println("====================");
        System.out.println(type);
    }

    /**getReturnType 获取方法的返回值类型**/
    @Test
    public void Test4a(){
        Method method = ReflectUtil.getMethod(TestClass.class, "getList");
        Type type = TypeUtil.getReturnType(method);
        // 结果：java.util.List<java.lang.String>
        System.out.println("====================");
        System.out.println(type);
    }

    /**getTypeArgument 获取泛型类子类中泛型的填充类型**/
    @Test
    public void Test4b(){
        Method method = ReflectUtil.getMethod(TestClass.class, "getList");
        Type type = TypeUtil.getReturnType(method);
        Type type2 = TypeUtil.getTypeArgument(type);
        // 结果：String.class
        System.out.println("====================");
        System.out.println(type);
        System.out.println("====================");
        System.out.println(type2);
    }

    public class TestClass {
        public List<String> getList(){
            return new ArrayList<>();
        }

        public Integer intTest(Integer integer) {
            return 1;
        }
    }
}
