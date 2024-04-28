package ru.gb.lesson2.homework;

import ru.gb.lesson2.rand.*;

import java.lang.reflect.*;
import java.util.*;
import java.util.concurrent.*;

public class RandomDateProcessor {
    public static void processRandomDate(Object obj) {
        for (Field declaredField : obj.getClass().getDeclaredFields()) {
            RandomDate annotation = declaredField.getAnnotation(RandomDate.class);

            System.out.println("annotation " + annotation);

            if (annotation != null) {
//      if (declaredField.isAnnotationPresent(RandomInteger.class)) {
                long min = annotation.min();
                long max = annotation.max();

                declaredField.setAccessible(true);

                boolean assignableFrom = Date.class.isAssignableFrom(declaredField.getType());
//                boolean assignableFrom = declaredField.getType().isAssignableFrom(Date.class);
                System.out.println("assignableFrom: " + assignableFrom);

                try {
                    declaredField.set(obj, ThreadLocalRandom.current().nextLong(min, max));
                } catch (IllegalAccessException e) {
                    System.err.println("Не удалось подставить рандомное значение: " + e);
                }
            }
        }
    }
    /*
    @RandomDate
    public Date date;
    @RandomDate
    public LocalDate localDate;
    @RandomDate
    public LocalDateTime localDateTime;
     */
}
