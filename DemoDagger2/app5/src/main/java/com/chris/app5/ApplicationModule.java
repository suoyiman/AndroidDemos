package com.chris.app5;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Email: suoyiman@163.coom
 */
@Module
public class ApplicationModule {
    @Singleton
    @Provides
    public Gson provideGson(){
        return new Gson();
    }
}
