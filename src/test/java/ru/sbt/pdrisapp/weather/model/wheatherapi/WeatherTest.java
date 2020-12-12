package ru.sbt.pdrisapp.weather.model.wheatherapi;

import junit.framework.TestCase;

public class WeatherTest extends TestCase {

    public void testGetCurrent() {
        Current current = new Current();
        Weather weather = new Weather(null, current, null);
        assertEquals(weather.getCurrent(), current);
    }

    public void testSetCurrent() {
        Current current = new Current();
        Weather weather = new Weather();
        weather.setCurrent(current);
        assertEquals(weather.getCurrent(), current);
    }

    public void testGetForecast() {
        Forecast forecast = new Forecast();
        Weather weather = new Weather(null, null, forecast);
        assertEquals(weather.getForecast(), forecast);
    }

    public void testSetForecast() {
        Forecast forecast = new Forecast();
        Weather weather = new Weather();
        weather.setForecast(forecast);
        assertEquals(weather.getForecast(), forecast);
    }

    public void testGetLocation() {
        Location location = new Location();
        Weather weather = new Weather(location, null, null);
        assertEquals(weather.getLocation(), location);
    }

    public void testSetLocation() {
        Location location = new Location();
        Weather weather = new Weather();
        weather.setLocation(location);
        assertEquals(weather.getLocation(), location);
    }
}