package com.qi.bean;

/**
 * @author ：qixianchuan
 * @date ：Created in 2019-05-27 10:30
 * @description：${description}
 * @modified By：
 * @version: $version$
 */
public class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
