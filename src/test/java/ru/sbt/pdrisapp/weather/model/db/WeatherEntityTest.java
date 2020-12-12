package ru.sbt.pdrisapp.weather.model.db;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Date;

public class WeatherEntityTest extends TestCase {

    @Test
    public void testGetDate() {
        Date date = new Date();
        WeatherEntity weatherEntity = new WeatherEntity(date, "Dublin", 12.0);
        assertEquals(weatherEntity.getDate(), date);
    }

    @Test
    public void testSetDate() {
        Date date = new Date();
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setDate(date);
        assertEquals(weatherEntity.getDate(), date);
    }

    @Test
    public void testGetTemp() {
        WeatherEntity weatherEntity = new WeatherEntity(new Date(), "Dublin", 12.0);
        assertEquals(weatherEntity.getTemp(), 12.0);
    }

    @Test
    public void testSetTemp() {
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setTemp(12.0);
        assertEquals(weatherEntity.getTemp(), 12.0);
    }

    @Test
    public void testGetCity() {
        WeatherEntity weatherEntity = new WeatherEntity(new Date(), "Dublin", 12.0);
        assertEquals(weatherEntity.getCity(), "Dublin");
    }

    @Test
    public void testSetCity() {
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setCity("Dublin");
        assertEquals(weatherEntity.getCity(), "Dublin");
    }
}