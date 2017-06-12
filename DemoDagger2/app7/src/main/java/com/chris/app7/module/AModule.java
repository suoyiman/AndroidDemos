package com.chris.app7.module;

import com.chris.app7.qualifier.PersonQualifier;
import com.chris.app7.scope.AScope;
import com.chris.app7.Person;

import dagger.Module;
import dagger.Provides;

/**
 * Email: suoyiman@163.coom
 */
@Module
public class AModule {
    @PersonQualifier("a")
    @AScope
    @Provides
    public Person getPerson(){
        return new Person("AModule");
    }

    @PersonQualifier("b")
    @AScope
    @Provides
    public Person getPersonb(){
        return new Person("personb");
    }
}
