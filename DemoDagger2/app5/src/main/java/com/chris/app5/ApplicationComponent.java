package com.chris.app5;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Email: suoyiman@163.coom
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Gson getGson();// 暴露Gson对象接口,依赖方式只能获取到暴露出的对象
}
