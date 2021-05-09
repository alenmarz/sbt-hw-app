package ru.sbt.utils;

import java.util.Calendar;
import java.util.Date;

public class DateCalc {
    private DateCalc() {}

    public static Date getDate(Date baseDate, int diff) {
        Calendar c = Calendar.getInstance();
        c.setTime(baseDate);
        c.add(Calendar.DATE, diff);
        return c.getTime();
    }

    public static Date getDate() {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c.getTime();
    }
}
