package com.qi;

import cn.hutool.core.lang.ObjectId;
import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：qixianchuan
 * @date ：Created in 2019-05-07 11:18
 * @description：huTool 唯一ID工具-IdUtil
 * @modified By：
 * @version: $version$
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTestsIdUtil {
    /**
     * 分布式系统中，有一些需要使用全局唯一ID的场景，有些时候我们希望能使用一种简单一些的ID，
     * 并且希望ID能够按照时间有序生成。Twitter的Snowflake 算法就是这种生成器。
     **/
    @Test
    public void Test1() {
        //参数1为终端ID
        //参数2为数据中心ID
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        long id = snowflake.nextId();
        System.out.println("====================");
        System.out.println("雪花算法id:" + id);
    }

    /**
     * ObjectId是MongoDB数据库的一种唯一ID生成策略，是UUID version1的变种，
     * 详细介绍可见：服务化框架－分布式Unique ID的生成方法一览。
     * **/
    @Test
    public void Test2(){
        //生成类似：5b9e306a4df4f8c54a39fb0c
        String id = ObjectId.next();
        System.out.println("====================");
        System.out.println("id: " + id);
        //方法2：从Hutool-4.1.14开始提供
        String id2 = IdUtil.objectId();
        System.out.println("====================");
        System.out.println("id2:" + id);
    }

    @Test
    public void Test3(){
        //生成的UUID是带-的字符串，类似于：a5c8a5e8-df2b-4706-bea4-08d0939410e3
        String uuid = IdUtil.randomUUID();
        System.out.println("====================");
        System.out.println("uuid: " + uuid);
        //生成的是不带-的字符串，类似于：b17f24ff026d40949c85a24f4f375d42
        String simpleUUID = IdUtil.simpleUUID();
        System.out.println("====================");
        System.out.println("simpleUUID: " + simpleUUID);
    }
}
