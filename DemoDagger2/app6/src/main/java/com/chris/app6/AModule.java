package com.chris.app6;

import dagger.Module;
import dagger.Provides;

/**
 * Email: suoyiman@163.coom
 */
@Module
public class AModule {
    @AScope
    @Provides
    public Person getPerson(){
        return new Person("AModule");
    }
}
