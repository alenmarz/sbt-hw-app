package ru.sbt.predict.model;

import org.junit.Test;
import ru.sbt.predict.model.WeatherEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class WeatherListTest {

    @Test
    public void getWeather() {
        WeatherList weatherList = new WeatherList();
        List<WeatherEntity> weatherEntityList = new ArrayList<>();
        weatherList.setWeather(weatherEntityList);
        assertEquals(weatherEntityList, weatherList.getWeather());
    }

}