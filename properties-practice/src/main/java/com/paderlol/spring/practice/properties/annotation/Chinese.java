package com.paderlol.spring.practice.properties.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.AliasFor;

@Target({ ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Profile("chinese")
public @interface Chinese {
    /**
     * The set of profiles for which the annotated component should be registered.
     */
    @AliasFor(annotation = Profile.class)
    String[] value() default "";
}
