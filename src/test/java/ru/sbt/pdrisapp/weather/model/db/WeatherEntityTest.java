package ru.sbt.pdrisapp.weather.model.db;

import junit.framework.TestCase;

import java.util.Date;

public class WeatherEntityTest extends TestCase {

    public void testGetDate() {
        Date date = new Date();
        WeatherEntity weatherEntity = new WeatherEntity(date, "Dublin", 12.0);
        assertEquals(weatherEntity.getDate(), date);
    }

    public void testSetDate() {
        Date date = new Date();
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setDate(date);
        assertEquals(weatherEntity.getDate(), date);
    }

    public void testGetTemp() {
        WeatherEntity weatherEntity = new WeatherEntity(new Date(), "Dublin", 12.0);
        assertEquals(weatherEntity.getTemp(), 12.0);
    }

    public void testSetTemp() {
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setTemp(12.0);
        assertEquals(weatherEntity.getTemp(), 12.0);
    }

    public void testGetCity() {
        WeatherEntity weatherEntity = new WeatherEntity(new Date(), "Dublin", 12.0);
        assertEquals(weatherEntity.getCity(), "Dublin");
    }

    public void testSetCity() {
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setCity("Dublin");
        assertEquals(weatherEntity.getCity(), "Dublin");
    }
}