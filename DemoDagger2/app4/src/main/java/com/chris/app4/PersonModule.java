package com.chris.app4;

import dagger.Module;
import dagger.Provides;

/**
 * Email: suoyiman@163.coom
 */
@Module
public class PersonModule {
    @PersonScope
    @Provides
    public Person providePerson(String name){
        return new Person(name);
    }
    @Provides
    public String provideName(){
        return "suoyiman";
    }
}
