package com.example.strings;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by cuihaichen on 17-5-18.
 */

public class StringFormat {
    public static void main(String[] args) {
        String format = String.format("%s$1+%d", "1", 0);
        System.out.println(format);


    }
}
