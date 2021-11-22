package ru.netology;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Date {

    public static LocalDate localDate() {

        LocalDate date = LocalDate.now();
        date = date.plusDays(3);
        return date;
    }

}
