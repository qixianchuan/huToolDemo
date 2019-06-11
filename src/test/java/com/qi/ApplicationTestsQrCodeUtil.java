package com.qi;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.*;

/**
 * @author ：qixianchuan
 * @date ：Created in 2019-05-07 11:18
 * @description：huTool 二维码测试
 * @modified By：
 * @version: $version$
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTestsQrCodeUtil {
    /**
     * 生成二维码
     **/
    @Test
    public void Test1() {
        QrCodeUtil.generate("https://hutool.cn/", 300, 300, FileUtil.file("E:/qrcode.jpg"));
    }

    /**
     * 自定义参数（since 4.1.2）
     **/
    @Test
    public void Test2() {
        QrConfig config = new QrConfig(300, 300);
        // 设置边距，既二维码和背景之间的边距
        config.setMargin(3);
        // 设置前景色，既二维码颜色（青色）
        config.setForeColor(Color.CYAN.getRGB());
        // 设置背景色（灰色）
        config.setBackColor(Color.GRAY.getRGB());
        // 生成二维码到文件，也可以到流
        QrCodeUtil.generate("http://hutool.cn/", config, FileUtil.file("e:/qrcode.jpg"));
    }

    /**
     * 附带logo小图标
     **/
    @Test
    public void Test3() {
//        QrCodeUtil.generate(//
//                "http://hutool.cn/", //二维码内容
//                QrConfig.create().setImg("e:/logo_small.jpg"), //附带logo
//                FileUtil.file("e:/qrcodeWithLogo.jpg")//写出到的文件
//        );
    }
}
