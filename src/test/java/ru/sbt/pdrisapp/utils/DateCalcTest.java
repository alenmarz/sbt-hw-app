package ru.sbt.pdrisapp.utils;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class DateCalcTest {

    @Test
    public void getDate() {
        DateCalc.getDate();
    }

    @Test
    public void testGetDate() {
        Date date1 = new Date();
        Date date2 = DateCalc.getDate(date1, 1);
        assertTrue(date2.after(date1));
    }
}