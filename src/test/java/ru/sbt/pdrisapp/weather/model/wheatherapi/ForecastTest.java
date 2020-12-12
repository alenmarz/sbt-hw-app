package ru.sbt.pdrisapp.weather.model.wheatherapi;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ForecastTest extends TestCase {

    public void testGetForecastDayList() {
        Forecast forecast = new Forecast();
        assertNull(forecast.getForecastDayList());
    }

    public void testSetForecastDayList() {
        ForecastDay forecastDay = new ForecastDay(new Date(), new ForecastDay.Day(12.0));
        List<ForecastDay> forecastDays = new ArrayList<>();
        forecastDays.add(forecastDay);
        Forecast forecast = new Forecast();
        forecast.setForecastDayList(forecastDays);
        assertEquals(forecast.getForecastDayList(), forecastDays);
    }
}