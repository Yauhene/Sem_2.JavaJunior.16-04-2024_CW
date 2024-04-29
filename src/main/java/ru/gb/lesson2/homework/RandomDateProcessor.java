package ru.gb.lesson2.homework;

import java.lang.reflect.*;
import java.time.*;
import java.util.*;
import java.util.concurrent.*;

public class RandomDateProcessor {
    public static void processAnnotations(Object obj) {
        Class<?> myClass = obj.getClass();
        Field[] fields = myClass.getDeclaredFields();

        for (Field declaredField : fields) {
            if (declaredField.isAnnotationPresent(RandomDate.class)) {
                RandomDate annotation = declaredField.getAnnotation(RandomDate.class);

                long min = annotation.min();
                long max = annotation.max();

                declaredField.setAccessible(true);
                try {
                    if (declaredField.getType() == Date.class) {
                        Date date = new Date(ThreadLocalRandom.current().nextLong(min, max));
                        declaredField.set(obj, date);
                        System.out.println(date);
                    } else if (declaredField.getType() == LocalDateTime.class) {
                        declaredField.set(obj,
                                LocalDateTime.ofEpochSecond(ThreadLocalRandom.current().
                                        nextLong(min, max) / 1000, 0, ZoneOffset.ofHours(-3)));
                        System.out.println(Homework.getRandomLocalDate());
                    } else if (declaredField.getType() == LocalDate.class) {
                        declaredField.set(obj,
                                LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(min, max) / 86400000L));
                    } else if (declaredField.getType() == Instant.class) {
                        declaredField.set(obj, Instant.ofEpochSecond(ThreadLocalRandom.current().
                                nextLong(min, max) / 1000));
                    }
                } catch (IllegalAccessException e) {
                    System.err.println("Операция не удалась: " + e);
                }
            }
        }
    }
}
