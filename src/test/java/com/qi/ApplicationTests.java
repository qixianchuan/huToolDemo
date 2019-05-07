package com.qi;

import cn.hutool.core.date.BetweenFormater;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.lang.Validator;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import cn.hutool.crypto.symmetric.AES;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.http.HttpUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.*;

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
        String f4 = DateUtil.format(new Date(), "yyyy-MM-dd");
        System.out.println("====================");
        System.out.println(f4);
    }

    @Test
    public void Test1a() {
        //计算年龄
        //根据出生日期计算年龄
        int age = DateUtil.ageOfNow("1988-04-14");
        System.out.println("====================");
        System.out.println(age);

        //使用DateUtil.isLeapYear(in year):boolean判断是否为闰年
        System.out.println("====================");
        System.out.println(DateUtil.isLeapYear(2008));

    }

    @Test
    public void Test1b() {
        //计算时间差
        //“糊涂”写法
        String dateStr1 = "2017-03-01 18:01:14";
        String dateStr2 = "2018-11-11 00:00:00";
        Date date1 = DateUtil.parse(dateStr1);
        Date date2 = DateUtil.parse(dateStr2);
        //参数1、2谁前谁后也不影响，没必要非得小时间在前，非常方便
        Long timeBetween1 = DateUtil.between(date1, date2, DateUnit.SECOND);
        Long timeBetween2 = DateUtil.between(date1, date2, DateUnit.WEEK);
        String timeBetween3 = DateUtil.formatBetween(date1, date2, BetweenFormater.Level.SECOND);
        System.out.printf("俩时间差%d秒\n", timeBetween1);
        System.out.printf("俩时间差%s周\n", timeBetween2);
        System.out.printf("俩时间差(精确到秒)为：%s\n", timeBetween3);
    }

    @Test
    //时间的加减计算，也就是时间偏移量的问题
    public void Test2c() {
        String dateStr = "2018-11-11 00:10:15.124";
        //传统写法
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        //"糊涂"写法
        Date hutoolDate = DateUtil.parse(dateStr);
        Date newDate = DateUtil.offsetMinute(hutoolDate, 10);
        System.out.printf("处理后的时间：%s\n", DateUtil.format(newDate, sdf));
    }

    @Test
    //字符串工具
    public void Test2() {
        String reverseStr = StrUtil.reverse("123456");
        System.out.println("====================");
        System.out.println(reverseStr);
        /**
         * Hutool可以去除字符串的前缀/后缀，这个特点非常适用于去除文件的后缀名。
         removeSuffix(CharSequence str, CharSequence suffix) 去除后缀
         removeSuffixIgnoreCase(CharSequence str, CharSequence suffix) 去除后缀，忽略大小写
         removePrefix(CharSequence str, CharSequence suffix) 去除前缀
         removePrefixIgnoreCase(CharSequence str, CharSequence suffix) 去除前缀，忽略大小写
         * **/
        String path1 = "smart.png";
        String path2 = "smart.PNg";
        System.out.println("====================");
        System.out.println(StrUtil.removeSuffix(path1, ".png"));
        System.out.println("====================");
        System.out.println(StrUtil.removeSuffixIgnoreCase(path2, ".png"));
    }

    @Test
    //HttpUtil
    public void Test3() {
        String url = "https://blog.csdn.net/";
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

        //POST请求栗子：
        HashMap<String, Object> paramMapP = new HashMap<>();
        paramMapP.put("city", "北京");
        String resultP = HttpUtil.post("https://www.baidu.com", paramMapP);
        System.out.println("====================");
        System.out.println(resultP);
    }

    @Test
    //加密
    public void Test4() {
        String beforeStr = "123456";
        //md5加密(摘要加密)
        Assert.assertEquals("e10adc3949ba59abbe56e057f20f883e", SecureUtil.md5(beforeStr));

        //AES加密(对称加密)
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        AES aes = SecureUtil.aes(key);
        String encryptStr = aes.encryptHex(beforeStr);
        String decryptStr = aes.decryptStr(encryptStr, CharsetUtil.CHARSET_UTF_8);
        Assert.assertEquals(beforeStr, decryptStr);

        //RSA加密（非对称加密）
        RSA rsa = SecureUtil.rsa();
        //签名，私钥加密，公钥解密
        byte[] encrypt = rsa.encrypt(StrUtil.bytes(beforeStr, CharsetUtil.CHARSET_UTF_8), KeyType.PublicKey);
        byte[] decrypt = rsa.decrypt(encrypt, KeyType.PrivateKey);
        Assert.assertEquals(beforeStr, StrUtil.str(decrypt, CharsetUtil.CHARSET_UTF_8));
        //加密私钥加密，公钥解密
        byte[] encrypt2 = rsa.encrypt(StrUtil.bytes(beforeStr, CharsetUtil.CHARSET_UTF_8), KeyType.PrivateKey);
        byte[] decrypt2 = rsa.decrypt(encrypt2, KeyType.PublicKey);
        Assert.assertEquals(beforeStr, StrUtil.str(decrypt2, CharsetUtil.CHARSET_UTF_8));
    }

    @Test
    //正则工具
    public void Test5() {
        System.out.println("====================");
        /**
         * 判断是否匹配
         使用 isMatch(String regex,CharSequence content):boolean 方法,第一个参数是正则，第二个是匹配的内容。
         */

        /**
         * 删除所匹配的内容
         delFirst(String regex,CharSequence content):String 删除匹配的第一个字符串，返回删除后的字符串
         delAll(String regex,CharSequence content):String 删除匹配的所有字符串，返回删除后的字符串
         **/
        String content = "smartPig,hello;my name is smartpig,smartPig";
        String result = ReUtil.delFirst("smart", content);
        System.out.println("删除第一个smart:");
        System.out.println(result);
        result = ReUtil.delAll("smart", content);
        System.out.println("删除所有smart:");
        System.out.println(result);

        /**
         得到匹配的内容
         使用findAll(String regex, CharSequence content, int group): List<String> 方法可以获得所有匹配的内容
         **/
        String content1 = "abjgjaaagjgaaaagj";
        //匹配所有a出现了1-4次的字符串
        List<String> results = ReUtil.findAll("a{1,4}", content1, 0);
        for (String s : results) {
            System.out.println(s);
        }

        /**
         * 替换匹配内容
         使用replaceAll(CharSequence content, String regex, String replacementTemplate):String方法可以替换匹配的内容。
         * **/
        String content2 = "hello1world2thank5you7";
        //将所有数字替换为下划线
        String result2 = ReUtil.replaceAll(content2, "[0-9]", "_");
        System.out.println(result2);

        /**
         * 自动转义特殊字符
         使用escape(CharSequence arg0):String方法可以将用于正则表达式中的某些特殊字符进行转义，变成转义字符。
         **/
        String content3 = "hello$smart[";
        String result3 = ReUtil.escape(content3);
        System.out.println(result3);
    }

    @Test
    //字段验证器
    public void Test6() {
        //常用的校验函数
        String parameter = "+8610000000000";
        int min = 5;
        int max = 8;
        //验证是否是身份证
        boolean isCitizenId = Validator.isCitizenId(parameter);
        System.out.println(isCitizenId);
        //验证是否是Email
        boolean isEmail = Validator.isEmail(parameter);
        System.out.println(isEmail);
        //验证是否是汉字
        boolean isChinese = Validator.isChinese(parameter);
        System.out.println(isChinese);
        //验证是否是生日
        boolean isBirthday = Validator.isBirthday(parameter);
        System.out.println(isBirthday);
        //验证是否是Ipv4地址
        boolean isIpv4 = Validator.isIpv4(parameter);
        System.out.println(isIpv4);
        //验证是否是mac地址
        boolean isMac = Validator.isMac(parameter);
        System.out.println(isMac);
        //验证是否是中国的手机号
        boolean isMobile = Validator.isMobile(parameter);
        System.out.println(isMobile);
        //验证是否是中国的车牌号
        boolean isPlateNumber = Validator.isPlateNumber(parameter);
        System.out.println(isPlateNumber);
        //验证是否是满足长度的仅含英文、数字、下划线的字符串
        boolean isGeneral = Validator.isGeneral(parameter, min, max);
        System.out.println(isGeneral);
    }

    @Test
    //随机数
    public void Test7() {
        //a.随机产生一个int数
        System.out.println(RandomUtil.randomInt());

        //b.随机产生一个小于10的int的数
        System.out.println(RandomUtil.randomInt(10));

        //c.随机产生一个<200且>=100的int数
        System.out.println(RandomUtil.randomInt(100, 102));

        //d.从指定字符串中产生一个随机字符
        System.out.println(RandomUtil.randomChar("smart"));

        //e.产生一个随机int数
        System.out.println(RandomUtil.randomNumber());

        //f.随机产生一个指定长度的字符串（只包含数字）
        System.out.println(RandomUtil.randomNumbers(4));

        //g.随机产生一个指定长度的字符串(只包含数字和字符）
        System.out.println(RandomUtil.randomString(5));

        //h.从指定字符串中随机产生指定长度的字符串(所有字符来源于指定字符串）
        System.out.println(RandomUtil.randomString("smartPig", 4));

        //i.从List中随机产生一个数据
        List<Integer> list = Arrays.asList(11, 52, 3, 40, 51, 96);
        System.out.println(RandomUtil.randomEle(list));

        //j.从List前n个数据中随机产生一个数据（n从1开始）
        System.out.println(RandomUtil.randomEle(list, 6));

        //k.从数组中随机产生一个数据
        Integer array01[] = {1, 2, 3, 4, 5, 6};
        System.out.println(RandomUtil.randomEle(array01));

    }
}
