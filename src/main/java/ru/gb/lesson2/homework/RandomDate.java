package ru.gb.lesson2.homework;

import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RandomDate {
    long min() default 1704056400L;
    long max() default 1735592400L;
}
