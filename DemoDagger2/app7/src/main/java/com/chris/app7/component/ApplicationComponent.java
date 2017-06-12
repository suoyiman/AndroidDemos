package com.chris.app7.component;


import com.chris.app7.module.ApplicationModule;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Email: suoyiman@163.coom
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Gson getGson();// 暴露Gson对象接口
    AComponent plus();//添加声明
}
