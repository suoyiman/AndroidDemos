package com.chris.app7.qualifier;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Email: suoyiman@163.coom
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonQualifier {
    String value() default "";
}
