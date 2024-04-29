package ru.gb.lesson2.abrakadabra;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RandomDate {
    String min() default "";
    String max() default "";
}


