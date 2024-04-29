package ru.gb.lesson2.homework;



import java.text.*;
import java.time.*;
import java.util.*;

public class Homework {

  /**
   *  1. Создать аннотацию RandomDate со следующими возможностями:
   *  1.1 Если параметры не заданы, то в поле должна вставляться рандомная дата в диапазоне min, max.
   *  1.2 Аннотация должна работать с полем типа java.util.Date.
   *  1.3 Должна генерить дату в диапазоне [min, max)
   *  1.4 ** Научиться работать с полями LocalDateTime, LocalDate, Instant, ... (классы java.time.*)
   *
   *  Реализовать класс RandomDateProcessor по аналогии с RandomIntegerProcessor, который обрабатывает аннотацию.
   */

  public static void main(String[] args) throws IllegalAccessException {
      MyClass myClass = new MyClass();
      RandomDateProcessor.processAnnotations(myClass);
  }

    public static class MyClass {
        @RandomDate(min = 1704056400L, max = 1735592400L)
        long date;
    }

    @RandomDate(min = 1704056400L, max = 1735592400L)
    private Date randomDateField;

    @RandomDate
    private LocalDateTime randomLocalDateTime;

    @RandomDate()
    private Instant randomInstant;

    public String getRandomInstant() {
        Date instantFormat = Date.from(randomInstant.atZone(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat dateFormat = new SimpleDateFormat(("dd-MM-yyyy"));
        return dateFormat.format(instantFormat);
    }

    @RandomDate
    private static LocalDate randomLocalDate;
    public static String getRandomLocalDate() {
        Date dateFormat = Date.from(randomLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return simpleDateFormat.format(dateFormat);
    }




}
