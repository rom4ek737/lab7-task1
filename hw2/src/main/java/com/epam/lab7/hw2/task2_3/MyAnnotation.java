package com.epam.lab7.hw2.task2_3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public  @interface MyAnnotation {
    String info() default "Hello everybody";
}