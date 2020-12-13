package ru.sbt.pdrisapp.weather.service;
import junit.framework.TestCase;
import org.junit.Test;
import ru.sbt.pdrisapp.weather.model.db.WeatherEntity;
import ru.sbt.pdrisapp.weather.model.wheatherapi.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherAdapterTest extends TestCase {

    @Test
    public void testGetWeatherEntities() {
        Location location = new Location("Dublin");
        Date date = new Date();
        ForecastDay forecastDay = new ForecastDay(date, new ForecastDay.Day(12.0));
        List<ForecastDay> forecastDays = new ArrayList<>();
        forecastDays.add(forecastDay);
        Forecast forecast = new Forecast(forecastDays);
        Current current = new Current();
        Weather weather = new Weather(location, current, forecast);

        List<WeatherEntity> weatherEntities = WeatherAdapter.getWeatherEntities(weather);
        assertEquals(1, weatherEntities.size());

        WeatherEntity weatherEntity = weatherEntities.get(0);
        assertEquals("Dublin", weatherEntity.getCity());
        assertEquals(12.0, weatherEntity.getTemp());
        assertEquals(date, weatherEntity.getDate());
    }
}