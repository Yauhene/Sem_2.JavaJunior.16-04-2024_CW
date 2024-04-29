package ru.gb.lesson2.abrakadabra;

import java.time.*;
import java.util.*;

public class Main {
    @RandomDate(min = "2022-01-01", max = "2022-12-31")
    private Date randomDateField;

    @RandomDate
    private LocalDateTime randomLocalDateTimeField;

    public static void main(String[] args) {
        Main main = new Main();
        RandomDateProcessor.processAnnotations(main);
        // After processing annotations, the fields will be populated with random dates
    }

}
