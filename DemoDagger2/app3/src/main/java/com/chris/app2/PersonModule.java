package com.chris.app2;

import dagger.Module;
import dagger.Provides;

/**
 * Email: suoyiman@163.coom
 */
@Module
public class PersonModule {
    @Provides
    public Person providePerson(String name){
        return new Person(name);
    }
//    @Provides
//    public String provideName(){
//        return "suoyiman";
//    }
    @Provides
    public String provideName1(){
        return "suoyiman1";
    }
}
