package ru.gb.lesson2;

import ru.gb.lesson2.rand.RandomInteger;
import ru.gb.lesson2.rand.RandomIntegerProcessor;

import java.lang.annotation.*;

@MyAnno
public class Annotations {

  public static void main(String[] args) {

    // Считывание аннотаций
//    Class<Annotations> annotationsClass = Annotations.class;
//    Annotation[] annotation = annotationsClass.getAnnotations();

    // Проверка наличия аннотации
//    annotationsClass.isAnnotationPresent();

    MyClass myClass = new MyClass();
    RandomIntegerProcessor.processRandomInteger(myClass);

    System.out.println(myClass.integer);
  }

  public static class MyClass {
    @RandomInteger(min = 2, max = 150)
    private int integer;

  }
}
