package ru.gb.lesson2;

import ru.gb.lesson2.rand.RandomInteger;
import ru.gb.lesson2.rand.RandomIntegerProcessor;

@MyAnno
public class Annotations {

  public static void main(String[] args) {
    MyClass myClass = new MyClass();
    RandomIntegerProcessor.processRandomInteger(myClass);

    System.out.println(myClass.integer);
  }

  private static class MyClass {

    @RandomInteger(min = 2, max = 150)
    private int integer;

  }

  public static class Person {

  }

}
