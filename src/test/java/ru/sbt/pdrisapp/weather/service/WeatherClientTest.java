package ru.sbt.pdrisapp.weather.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sbt.pdrisapp.weather.model.db.WeatherEntity;
import ru.sbt.pdrisapp.weather.repository.WeatherRepository;

import java.text.ParseException;
import java.util.List;

@RunWith(SpringRunner.class)
public class WeatherClientTest extends TestCase {
    @MockBean
    WeatherRepository weatherRepository;

    @Test
    public void testGetWeather() {
        WeatherClient weatherClient = new WeatherClient(new WeatherCache(weatherRepository));
        try {
            List<WeatherEntity> weatherEntities = weatherClient.getWeather(null, null, null);
            assertEquals(1, weatherEntities.size());
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }
}