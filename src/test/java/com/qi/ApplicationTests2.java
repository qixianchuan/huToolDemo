package com.qi;

import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.ReUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：qixianchuan
 * @date ：Created in 2019-05-08 15:43
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests2 {

    @Test
    public void Test1() {
        int port1 = 80;
        int port2 = 68000;
        String ip1 = "220.181.57.216";
        String ip2 = "192.168.0.8";
        System.out.println("端口号" + port1 + "是否已经被占用" + !NetUtil.isUsableLocalPort(port1));
//        p2();
//        p2("端口号", port2, "是否一个有效的端口号", NetUtil.isValidPort(port2));
//        p2("ip地址", ip1, "是否是个内网地址", NetUtil.isInnerIP(ip1));
//        p2("ip地址", ip2, "是否是个内网地址", NetUtil.isInnerIP(ip2));
    }

    @Test
    public void Test2() {
        String content = "But just as he who called you is holy, so be holy in all you do; for it is written: “Be holy, because I am holy";

        System.out.println("字符串" + content);
        String regex = "\\w{5}";
        System.out.println(regex + " 表：" + "连续5个字母或者数字");
        Object result = ReUtil.get(regex, content, 0);
        System.out.println("正则表达式" + regex + "get 返回值" + result);

        result = ReUtil.contains(regex, content);
        System.out.println("正则表达式" + regex + "contain 返回值" + result);

        result = ReUtil.count(regex, content);
        System.out.println("正则表达式" + regex + "count 返回值" + result);

        result = ReUtil.delAll(regex, content);
        System.out.println("正则表达式" + regex + "delAll 返回值" + result);

        result = ReUtil.delFirst(regex, content);
        System.out.println("正则表达式" + regex + "delFirst 返回值" + result);

        result = ReUtil.delPre(regex, content);
        System.out.println("正则表达式" + regex + "delPre 返回值" + result);

        result = ReUtil.findAll(regex, content, 0);
        System.out.println("正则表达式" + regex + "findAll 返回值" + result);
    }
}
