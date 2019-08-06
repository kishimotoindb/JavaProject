package com.example.tools;

import java.util.Calendar;

/**
 * Created by BigFaceBear on 2019.07.04
 * <p>
 * 获取某一日期对应的时间戳
 */
public class DateTimeMillis {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2019);
        c.set(Calendar.MONTH, 8);
        c.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println("time millis: " + c.getTimeInMillis());
    }
}
