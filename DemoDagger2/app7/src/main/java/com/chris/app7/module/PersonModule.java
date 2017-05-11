package com.chris.app7.module;

import com.chris.app7.Person;
import com.chris.app7.scope.PersonScope;

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
