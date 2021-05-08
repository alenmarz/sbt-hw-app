package ru.sbt.weather.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sbt.weather.model.db.WeatherEntity;
import ru.sbt.weather.repository.WeatherRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
public class WeatherCacheTest extends TestCase {
    @MockBean
    WeatherRepository weatherRepository;

    @Test
    public void testGetCachedWeatherEntities() {
        WeatherCache weatherCache = new WeatherCache(weatherRepository);
        Date date = new Date();
        assertTrue(weatherCache.getCachedWeatherEntities("Dublin", date, date).isEmpty());
    }

    @Test
    public void testSaveWeatherEntities() {
        WeatherEntity weatherEntity = new WeatherEntity();
        List<WeatherEntity> weatherEntities = new ArrayList<>();
        weatherEntities.add(weatherEntity);
        WeatherCache weatherCache = new WeatherCache(weatherRepository);
        weatherCache.saveWeatherEntities(weatherEntities);
    }
}