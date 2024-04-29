package ru.gb.lesson2.abrakadabra2;

import java.lang.annotation.*;
import java.util.*;

public class Abrakadabra2 {

    @Retention(RetentionPolicy.RUNTIME)
    private static @interface randomDate {

        long min() default 1704056400l; // 1 января 2024 utc-3

        long max() default 1735592400l;

    }

    public static void main(String[] args) throws NoSuchFieldException {
        Abrakadabra2 processor = new Abrakadabra2();
        TestObject testObject = processor.processAnnotation(new TestObject());
        System.out.println(testObject.getDate());
    }

    private static class TestObject {

        @randomDate
        private Date date;

        public Date getDate() {
            return date;
        }
    }

    TestObject processAnnotation(TestObject testObject) throws NoSuchFieldException {
        randomDate annotation = testObject.getClass().getDeclaredField("date").getAnnotation(randomDate.class);
        long randomTimestamp = getRandomLong(annotation.min(), annotation.max());
        testObject.date = new Date(randomTimestamp);
        return testObject;
    }

    private long getRandomLong(long min, long max) {
        return min + (long) (Math.random() * (max - min));
    }

}
