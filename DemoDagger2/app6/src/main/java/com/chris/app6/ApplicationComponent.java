package com.chris.app6;

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
    AComponent plus(AModule module);//添加声明
}
