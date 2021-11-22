package ru.netology;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Data  {


    public static String day(int days) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
        return String.valueOf(Integer.parseInt(LocalDate.now().plusDays(days).format(formatter)));
    }

    public boolean monthCheck(int days) {
        int now = Integer.parseInt(LocalDate.now().format(DateTimeFormatter.ofPattern("MM")));
        int forward = Integer.parseInt(LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("MM")));
        if (forward > now) {
            return true;
        }
        if (now == 12 && forward == 1) {
            return true;
        }
        return false;
    }

}