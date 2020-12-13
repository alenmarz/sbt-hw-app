package ru.sbt.pdrisapp.weather.model.wheatherapi;

import junit.framework.TestCase;
import org.junit.Test;

public class WeatherTest extends TestCase {

    @Test
    public void testGetCurrent() {
        Current current = new Current();
        Weather weather = new Weather(null, current, null);
        assertEquals(current, weather.getCurrent());
    }

    @Test
    public void testSetCurrent() {
        Current current = new Current();
        Weather weather = new Weather();
        weather.setCurrent(current);
        assertEquals(current, weather.getCurrent());
    }

    @Test
    public void testGetForecast() {
        Forecast forecast = new Forecast();
        Weather weather = new Weather(null, null, forecast);
        assertEquals(forecast, weather.getForecast());
    }

    @Test
    public void testSetForecast() {
        Forecast forecast = new Forecast();
        Weather weather = new Weather();
        weather.setForecast(forecast);
        assertEquals(forecast, weather.getForecast());
    }

    @Test
    public void testGetLocation() {
        Location location = new Location();
        Weather weather = new Weather(location, null, null);
        assertEquals(location, weather.getLocation());
    }

    @Test
    public void testSetLocation() {
        Location location = new Location();
        Weather weather = new Weather();
        weather.setLocation(location);
        assertEquals(location, weather.getLocation());
    }
}