package ru.sbt.pdrisapp.weather.service;
import junit.framework.TestCase;
import ru.sbt.pdrisapp.weather.model.db.WeatherEntity;
import ru.sbt.pdrisapp.weather.model.wheatherapi.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherAdapterTest extends TestCase {

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
        assertEquals(weatherEntities.size(), 1);

        WeatherEntity weatherEntity = weatherEntities.get(0);
        assertEquals(weatherEntity.getCity(), "Dublin");
        assertEquals(weatherEntity.getTemp(), 12.0);
        assertEquals(weatherEntity.getDate(), date);
    }
}