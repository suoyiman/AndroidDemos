package com.chris.demodagger2;

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

    public String getName() {
        return name;
    }
}
