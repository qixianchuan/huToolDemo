package com.qi;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Filter;
import cn.hutool.core.util.*;
import cn.hutool.system.SystemUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
public class ApplicationTests1 {

    @Test
    // JAVA 数字工具
    public void Test1() {
        double result1 = (1.2 - 0.4);
        System.out.println("====================");
        System.out.println(result1);
        double result2 = NumberUtil.sub(1.2, 0.4);
        System.out.println("====================");
        System.out.println(result2);

        double a = 100.123;
        double b = 100.125;
        double result3 = NumberUtil.round(a, 2).doubleValue();
        System.out.println("====================");
        System.out.println(result3);
        double result4 = NumberUtil.round(b, 2).doubleValue();
        System.out.println("====================");
        System.out.println(result4);

//        p3("对π进行格式化，π的值是",Math.PI);
        double pi = Math.PI;
        String format = null;
        String str = null;
        format = "0";
        str = NumberUtil.decimalFormat(format, pi);
//        p2("格式",format,"格式化后得到", str);
        System.out.println("====================");
        System.out.println(str);

        format = "0.00";
        str = NumberUtil.decimalFormat(format, pi);
//        p2("格式",format,"格式化后得到", str);
        System.out.println("====================");
        System.out.println(str);

        format = "00.000";
        str = NumberUtil.decimalFormat(format, pi);
//        p2("格式",format,"格式化后得到", str);
        System.out.println("====================");
        System.out.println(str);
        format = "#";
        str = NumberUtil.decimalFormat(format, pi);
//        p2("格式",format,"格式化后得到", str);
        System.out.println("====================");
        System.out.println(str);
        format = "#.##";
        str = NumberUtil.decimalFormat(format, pi);
//        p2("格式",format,"格式化后得到", str);
        System.out.println("====================");
        System.out.println(str);
        format = "#.##%";
        str = NumberUtil.decimalFormat(format, pi);
//        p2("格式",format,"格式化后得到", str);
        System.out.println("====================");
        System.out.println(str);
        format = "#.####E0";
        str = NumberUtil.decimalFormat(format, pi);
//        p2("格式",format,"格式化后得到", str);
        System.out.println("====================");
        System.out.println(str);
        format = ",###";
        str = NumberUtil.decimalFormat(format, pi * 10000);
//        p2("格式",format,"x1000 再格式化后得到", str);
        System.out.println("====================");
        System.out.println(str);
        format = ",####";
        str = NumberUtil.decimalFormat(format, pi * 10000);
//        p2("格式",format,"x1000 再格式化后得到", str);
        System.out.println("====================");
        System.out.println(str);
        format = "π的大小是#.##########，请课后记忆";
        str = NumberUtil.decimalFormat(format, pi);
//        p2("格式",format,"格式化后得到", str);
        System.out.println("====================");
        System.out.println(str);
    }

    @Test
    public void Test1a() {
        //数字判断
        String s1 = "3.1415926";
        int n = 11;
        System.out.println("字符串" + s1 + "是否数字");
        System.out.println(NumberUtil.isNumber(s1));
        System.out.println("字符串" + s1 + "是否整数(这个有问题)");
        System.out.println(NumberUtil.isInteger(s1));
        System.out.println("字符串" + s1 + "是否浮点数");
        System.out.println(NumberUtil.isDouble(s1));
        System.out.println("整数" + n + "是否质数");
        System.out.println(NumberUtil.isPrimes(n));

        int random[] = NumberUtil.generateRandomNumber(1, 1000, 10);
        System.out.println("最小是1，最大是1000，总长度是10的不重复随机数组");
        System.out.println(Convert.toStr(random));

        //数字计算
        System.out.println("计算3的阶乘");
        System.out.println(NumberUtil.factorial(3));
        System.out.println("计算9的平方根");
        System.out.println(NumberUtil.sqrt(9));
        System.out.println("计算9和6的最大公约数");
        System.out.println(NumberUtil.divisor(9, 6));
        System.out.println("计算9和6的最小公倍数");
        System.out.println(NumberUtil.multiple(9, 6));
        System.out.println("获得数字9对应的二进制字符串");
        System.out.println(NumberUtil.getBinaryStr(9));
        System.out.println("获取123456789对应金额");
        System.out.println(NumberUtil.decimalFormatMoney(123456789));
    }

    @Test
    //数组工具
    public void Test2() {
        //为空判断
        int[] a = null;
        int[] b = new int[5];
        int[] c = new int[]{10, 11, 12};
        System.out.println("数组" + Convert.toStr(a) + "是否为空");
        System.out.println(ArrayUtil.isEmpty(a));
        System.out.println("数组" + Convert.toStr(b) + "是否为空");
        System.out.println(ArrayUtil.isEmpty(b));
        System.out.println("数组" + Convert.toStr(c) + "是否为空");
        System.out.println(ArrayUtil.isEmpty(c));
        //调整数组大小
        Integer[] a1 = new Integer[]{10, 11, 12};
        Integer[] b1 = ArrayUtil.resize(a1, 5);
        System.out.println("调整大小前的数组" + Convert.toStr(a1));
        System.out.println("调整大小后的数组" + Convert.toStr(b1));
        //合并数组
        Integer[] a2 = {1, 2, 3};
        Integer[] b2 = {10, 11, 12};
        Integer[] c2 = ArrayUtil.addAll(a2, b2);
        System.out.println("合并前的两个数组 " + Convert.toStr(a2) + ", " + Convert.toStr(b2));
        System.out.println("合并后的数组是" + Convert.toStr(c2));

        Integer[] a3 = {1, 2, 3};
        Integer b3[] = ArrayUtil.clone(a3);
        System.out.println("原数组" + Convert.toStr(a3));
        System.out.println("克隆的数组" + Convert.toStr(b3));


    }

    @Test
    //过滤
    public void Test2a() {
        Integer[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[] b = ArrayUtil.filter(a, new Filter<Integer>() {
            @Override
            public boolean accept(Integer t) {
                if (0 == t % 3)
                    return true;
                return false;
            }
        });
        System.out.println("原数组" + Convert.toStr(a));
        System.out.println("3的倍数过滤之后" + Convert.toStr(b));
    }

    @Test
    //转换为map
    public void Test2b() {
        Integer a[] = {1, 2, 3};
        String c[] = {"a", "b", "c"};
        Map<Integer, String> m = ArrayUtil.zip(a, c);
        System.out.println("两个数组" + Convert.toStr(a) + Convert.toStr(c));
        System.out.println("转换为 Map " + m);
    }

    @Test
    //是否包含某元素
    public void Test2c() {
        Integer a[] = {1, 2, 3};
        System.out.println("数组" + Convert.toStr(a) + "是否包含元素3");
        System.out.println(ArrayUtil.contains(a, 3));
    }

    @Test
    //装箱拆箱
    public void Test2d() {
        int a[] = {1, 2, 3};
        Integer b[] = ArrayUtil.wrap(a);
        int c[] = ArrayUtil.unWrap(b);
        System.out.println("数组基本类型的装箱拆箱" + "ArrayUtil.wrap | ArrayUtil.unWrap");
    }

    @Test
    //转换为字符串
    public void Test2e() {
        int a[] = {1, 2, 3};
        System.out.println("数组转换为默认字符串");
        System.out.println(ArrayUtil.toString(a));
        System.out.println("数组转换为自定义分隔符的字符串");
        System.out.println(ArrayUtil.join(a, "-"));
    }

    @Test
    //拆分
    public void Test2f() {
        byte[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[][] b = ArrayUtil.split(a, 2);
        System.out.println("数组被拆成2为长度的等份");
        System.out.println(Convert.toStr(a));
        System.out.println("拆分后的数组：");
        System.out.println(Convert.toStr(b));
    }

    @Test
    //系统属性工具
    public void Test3() {
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("java虚拟机规范");
        System.out.println("++++++++++++++++++++++++++");
        System.out.println(StrUtil.trim(SystemUtil.getJvmSpecInfo().toString()));
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("当前虚拟机信息");
        System.out.println("++++++++++++++++++++++++++");
        System.out.println(StrUtil.trim(SystemUtil.getJvmInfo().toString()));
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("java规范");
        System.out.println("++++++++++++++++++++++++++");
        System.out.println(StrUtil.trim(SystemUtil.getJavaSpecInfo().toString()));
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("当前java信息");
        System.out.println("++++++++++++++++++++++++++");
        System.out.println(StrUtil.trim(SystemUtil.getJavaInfo().toString()));
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("java运行时信息");
        System.out.println("++++++++++++++++++++++++++");
        System.out.println(StrUtil.trim(SystemUtil.getJavaRuntimeInfo().toString()));
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("操作系统信息");
        System.out.println("++++++++++++++++++++++++++");
        System.out.println(StrUtil.trim(SystemUtil.getOsInfo().toString()));
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("用户信息");
        System.out.println("++++++++++++++++++++++++++");
        System.out.println(StrUtil.trim(SystemUtil.getUserInfo().toString()));
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("主机信息");
        System.out.println("++++++++++++++++++++++++++");
        System.out.println(StrUtil.trim(SystemUtil.getHostInfo().toString()));
        System.out.println("++++++++++++++++++++++++++");
        System.out.println("内存信息");
        System.out.println("++++++++++++++++++++++++++");
        System.out.println(StrUtil.trim(SystemUtil.getRuntimeInfo().toString()));
        System.out.println("++++++++++++++++++++++++++");
    }
}


/**
 * package cn.how2j.test;
 * <p>
 * import static java.lang.annotation.ElementType.METHOD;
 * import static java.lang.annotation.ElementType.TYPE;
 * <p>
 * import java.lang.annotation.Documented;
 * import java.lang.annotation.Inherited;
 * import java.lang.annotation.Retention;
 * import java.lang.annotation.RetentionPolicy;
 * import java.lang.annotation.Target;
 * import java.lang.reflect.Method;
 * import java.util.Date;
 * <p>
 * import org.junit.Test;
 * <p>
 * import cn.hutool.core.convert.Convert;
 * import cn.hutool.core.date.BetweenFormater.Level;
 * import cn.hutool.core.date.DateField;
 * import cn.hutool.core.date.DateUnit;
 * import cn.hutool.core.date.DateUtil;
 * import cn.hutool.core.date.TimeInterval;
 * import cn.hutool.core.util.ReflectUtil;
 * import cn.hutool.core.util.StrUtil;
 * <p>
 * public class TestDate {
 *
 * @Test
 * @Comment("字符串转日期") public void test0() {
 * printDefaultFormat();
 * Date d;
 * String str3 = "12:12:12";
 * d = DateUtil.parse(str3);
 * p1("字符串",str3, "日期格式",d);
 * <p>
 * String str1 = "2012-12-12";
 * d = DateUtil.parse(str1);
 * p1("字符串",str1, "日期格式",d);
 * <p>
 * String str4 = "2012-12-12 12:12";
 * d = DateUtil.parse(str4);
 * p1("字符串",str4, "日期格式",d);
 * <p>
 * String str2 = "2012-12-12 12:12:12";
 * d = DateUtil.parse(str2);
 * p1("字符串",str2, "日期格式",d);
 * }
 * @Test
 * @Comment("日期转字符串") public void test1() {
 * Date d = new Date();
 * <p>
 * //结果 2017/03/01
 * String format = DateUtil.format(d, "yyyy/MM/dd");
 * <p>
 * //常用格式的格式化，结果：2017-03-01
 * String formatDate = DateUtil.formatDate(d);
 * <p>
 * //结果：2017-03-01 00:00:00
 * String formatDateTime = DateUtil.formatDateTime(d);
 * <p>
 * //结果：00:00:00
 * String formatTime = DateUtil.formatTime(d);
 * <p>
 * p1("日期格式",d, "自定义格式的字符串",format);
 * p1("日期格式",d, "只是日期格式",formatDate);
 * p1("日期格式",d, "日期和时间格式",formatDateTime);
 * p1("日期格式",d, "只是时间格式",formatTime);
 * }
 * @Test
 * @Comment("获取部分信息") public void test2() {
 * Date d = new Date();
 * //获得年的部分
 * int year= DateUtil.year(d);
 * //获得月份，从0开始计数
 * int month = DateUtil.month(d);
 * //获得月份枚举
 * Enum months= DateUtil.monthEnum(d);
 * <p>
 * p2("当前日期",DateUtil.formatDateTime(d), "年份",year);
 * p2("当前日期",DateUtil.formatDateTime(d), "月份",month);
 * p2("当前日期",DateUtil.formatDateTime(d), "月份枚举信息",months);
 * <p>
 * }
 * @Test
 * @Comment("开始和结束时间") public void test3() {
 * Date date = new Date();
 * <p>
 * //一天的开始，结果：2017-03-01 00:00:00
 * Date beginOfDay = DateUtil.beginOfDay(date);
 * <p>
 * //一天的结束，结果：2017-03-01 23:59:59
 * Date endOfDay = DateUtil.endOfDay(date);
 * p2("当前日期",DateUtil.formatDateTime(date), "开始时间",beginOfDay);
 * p2("当前日期",DateUtil.formatDateTime(date), "结束时间",endOfDay);
 * c("这个在查询数据库时，根据日期查一个范围内的数据就很有用");
 * }
 * @Test
 * @Comment("日期时间偏移") public void test4() {
 * Date date = new Date();
 * <p>
 * Date d1 = DateUtil.offset(date, DateField.DAY_OF_MONTH, 2);
 * <p>
 * Date d2 = DateUtil.offsetDay(date, 3);
 * <p>
 * Date d3= DateUtil.offsetHour(date, -3);
 * <p>
 * p2("当前日期",DateUtil.formatDateTime(date), "两天之后的日期",d1);
 * p2("当前日期",DateUtil.formatDateTime(date), "三天之后的日期",d2);
 * p2("当前日期",DateUtil.formatDateTime(date), "三小时之前的日期",d3);
 * <p>
 * }
 * @Test
 * @Comment("偏移简化用法") public void test5() {
 * Date date = new Date();
 * Date d1= DateUtil.yesterday();
 * Date d2=DateUtil.tomorrow();
 * Date d3=DateUtil.lastWeek();
 * Date d4=DateUtil.nextWeek();
 * Date d5=DateUtil.lastMonth();
 * Date d6=DateUtil.nextMonth();
 * p2("当前日期",DateUtil.formatDateTime(date), "昨天",d1);
 * p2("当前日期",DateUtil.formatDateTime(date), "明天",d2);
 * p2("当前日期",DateUtil.formatDateTime(date), "上周",d3);
 * p2("当前日期",DateUtil.formatDateTime(date), "下周",d4);
 * p2("当前日期",DateUtil.formatDateTime(date), "上个月",d5);
 * p2("当前日期",DateUtil.formatDateTime(date), "下个月",d6);
 * <p>
 * }
 * @Test
 * @Comment("日期时间差") public void test6() {
 * Date date1 = DateUtil.parse("2012-12-12 12:12:12");
 * Date date2 = DateUtil.parse("2013-13-13 13:13:13");
 * <p>
 * long b1 = DateUtil.between(date1, date2, DateUnit.MS);
 * long b2 = DateUtil.between(date1, date2, DateUnit.SECOND);
 * long b3 = DateUtil.between(date1, date2, DateUnit.MINUTE);
 * long b4 = DateUtil.between(date1, date2, DateUnit.HOUR);
 * long b5 = DateUtil.between(date1, date2, DateUnit.DAY);
 * long b6 = DateUtil.between(date1, date2, DateUnit.WEEK);
 * <p>
 * p2("当前如下两个日期",date1 + " " + date2, "相差毫秒",b1);
 * p2("当前如下两个日期",date1 + " " + date2, "相差秒",b2);
 * p2("当前如下两个日期",date1 + " " + date2, "相差分",b3);
 * p2("当前如下两个日期",date1 + " " + date2, "相差小时",b4);
 * p2("当前如下两个日期",date1 + " " + date2, "相差天",b5);
 * p2("当前如下两个日期",date1 + " " + date2, "相差星期",b6);
 * }
 * @Test
 * @Comment("格式化时间差") public void test7() {
 * long between = System.currentTimeMillis();
 * <p>
 * String s0 = DateUtil.formatBetween(between, Level.MILLSECOND);
 * String s1 = DateUtil.formatBetween(between, Level.SECOND);
 * String s2 = DateUtil.formatBetween(between, Level.MINUTE);
 * String s3 = DateUtil.formatBetween(between, Level.HOUR);
 * String s4 = DateUtil.formatBetween(between, Level.DAY);
 * p2("毫秒数",between, "对应时间，精度到毫秒",s0);
 * p2("毫秒数",between, "对应时间，精度到秒",s1);
 * p2("毫秒数",between, "对应时间，精度到秒分钟",s2);
 * p2("毫秒数",between, "对应时间，精度到秒小时",s3);
 * p2("毫秒数",between, "对应时间，精度到秒天",s4);
 * <p>
 * }
 * @Test
 * @Comment("性能统计") public void test8() {
 * int loopcount = 100;
 * TimeInterval timer = DateUtil.timer();
 * forloop(loopcount);
 * long interval1= timer.interval();
 * forloop(loopcount);
 * long interval2 = timer.intervalRestart();
 * forloop(loopcount);
 * long interval3 = timer.interval();
 * <p>
 * p3("性能统计，总共花费了 (毫秒数)",interval1);
 * p3("性能统计，总共花费了 (毫秒数),并重置",interval2);
 * p3("性能统计，总共花费了 (毫秒数)",interval3);
 * <p>
 * }
 * @Test
 * @Comment("其他") public void test9() {
 * <p>
 * String birthDay = "1949-10-01";
 * int age = DateUtil.ageOfNow(birthDay);
 * <p>
 * int year = 2012;
 * boolean isLeap= DateUtil.isLeapYear(year);
 * <p>
 * String now = DateUtil.now();
 * String today =  DateUtil.today();
 * <p>
 * p2("生日",birthDay,"年龄",age);
 * p2("年份",year,"是否闰年",isLeap);
 * <p>
 * p3("现在",now);
 * p3("今天",today);
 * <p>
 * }
 * <p>
 * private void forloop(int total) {
 * for (int i = 0; i < total; i++) {
 * try {
 * Thread.sleep(1);
 * } catch (InterruptedException e) {
 * // TODO Auto-generated catch block
 * e.printStackTrace();
 * }
 * }
 * }
 * <p>
 * public void printDefaultFormat() {
 * System.out.println("DateUtil默认会对如下格式进行识别：");
 * System.out.println();
 * <p>
 * System.out.println("\tyyyy-MM-dd HH:mm:ss");
 * System.out.println("\tyyyy/MM/dd HH:mm:ss");
 * System.out.println("\tyyyy.MM.dd HH:mm:ss");
 * System.out.println("\tyyyy年MM月dd日 HH时mm分ss秒");
 * System.out.println("\tyyyy-MM-dd");
 * System.out.println("\tyyyy/MM/dd");
 * System.out.println("\tyyyy.MM.dd");
 * System.out.println("\tHH:mm:ss");
 * System.out.println("\tHH时mm分ss秒");
 * System.out.println("\tyyyy-MM-dd HH:mm");
 * System.out.println("\tyyyy-MM-dd HH:mm:ss.SSS");
 * System.out.println("\tyyyyMMddHHmmss");
 * System.out.println("\tyyyyMMddHHmmssSSS");
 * System.out.println("\tyyyyMMdd");
 * System.out.println();
 * <p>
 * }
 * private String preComment = null;
 * private void c(String msg) {
 * System.out.printf("\t备注：%s%n",msg);
 * }
 * private void p1(String type1, Object value1, String type2, Object value2) {
 * p(type1, value1, type2, value2, "format1");
 * }
 * private void p2(String type1, Object value1, String type2, Object value2) {
 * p(type1, value1, type2, value2, "format2");
 * }
 * private void p3(String type1, Object value1) {
 * p(type1, value1, "", "", "format3");
 * }
 * <p>
 * private void p(String type1, Object value1, String type2, Object value2, String format) {
 * try {
 * throw new Exception();
 * } catch (Exception e) {
 * <p>
 * String methodName = getTestMethodName(e.getStackTrace());
 * Method m =ReflectUtil.getMethod(this.getClass(), methodName);
 * Comment annotation = m.getAnnotation(Comment.class);
 * if(null!=annotation) {
 * String comment= annotation.value();
 * if(!comment.equals(preComment)) {
 * System.out.printf("%n%s 例子： %n%n",comment);
 * preComment = comment;
 * }
 * <p>
 * }
 * }
 * int padLength = 12;
 * type1=StrUtil.padEnd(type1,padLength,Convert.toSBC(" ").charAt(0));
 * type2=StrUtil.padEnd(type2,padLength,Convert.toSBC(" ").charAt(0));
 * if("format1".equals(format)) {
 * System.out.printf("\t%s的:\t\"%s\" %n\t被转换为----->%n\t%s的 :\t\"%s\" %n%n",type1,value1, type2, value2);
 * }
 * if("format2".equals(format)) {
 * System.out.printf("\t基于 %s:\t\"%s\" %n\t获取 %s:\t\"%s\"%n%n",type1,value1, type2, value2);
 * }
 * if("format3".equals(format)) {
 * System.out.printf("\t%s:\t\"%s\" %n\t%n",type1,value1);
 * <p>
 * }
 * }
 * <p>
 * private String getTestMethodName(StackTraceElement[] stackTrace) {
 * for (StackTraceElement se : stackTrace) {
 * String methodName = se.getMethodName();
 * if(methodName.startsWith("test"))
 * return methodName;
 * }
 * return null;
 * }
 * @Target({METHOD,TYPE})
 * @Retention(RetentionPolicy.RUNTIME)
 * @Inherited
 * @Documented public @interface Comment {
 * String value();
 * }
 * }
 **/
