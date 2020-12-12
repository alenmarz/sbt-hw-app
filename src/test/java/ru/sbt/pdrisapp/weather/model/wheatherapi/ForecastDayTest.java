package ru.sbt.pdrisapp.weather.model.wheatherapi;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Date;

public class ForecastDayTest extends TestCase {

    @Test
    public void testGetDay() {
        ForecastDay forecastDay = new ForecastDay();
        assertNull(forecastDay.getDay());
    }

    @Test
    public void testSetDay() {
        ForecastDay forecastDay = new ForecastDay();
        ForecastDay.Day day = new ForecastDay.Day();
        forecastDay.setDay(day);
        assertEquals(forecastDay.getDay(), day);
    }

    @Test
    public void testGetDate() {
        Date date = new Date();
        ForecastDay forecastDay = new ForecastDay(date, null);
        assertEquals(forecastDay.getDate(), date);
    }

    @Test
    public void testSetDate() {
        Date date = new Date();
        ForecastDay forecastDay = new ForecastDay();
        forecastDay.setDate(date);
        assertEquals(forecastDay.getDate(), date);
    }
}