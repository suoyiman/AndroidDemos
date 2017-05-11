package com.chris.app5;

import javax.inject.Inject;

/**
 * Email: suoyiman@163.coom
 */

public class Person {
    private String name;
    // 用Inject标记构造函数,表示用它来注入到目标对象中去
    @Inject
    public Person() {
        this.name = "chris";
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
