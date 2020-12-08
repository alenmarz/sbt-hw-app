package ru.sbt.pdrisapp.weather.service;

import ru.sbt.pdrisapp.weather.model.db.WeatherEntity;
import ru.sbt.pdrisapp.weather.model.wheatherapi.ForecastDay;
import ru.sbt.pdrisapp.weather.model.wheatherapi.Weather;

import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter {
    public static List<WeatherEntity> getWeatherEntities(Weather weather) {
        List<WeatherEntity> weatherEntities = new ArrayList<>();

        String city = weather.getLocation().getName();
        List<ForecastDay> forecastDays = weather.getForecast().getForecastDayList();

        forecastDays.forEach(forecastDay -> {
            weatherEntities.add(
                    new WeatherEntity(
                        forecastDay.getDate(),
                        city,
                        forecastDay.getDay().getAvgtemp_c()
                    )
            );
        });

        return weatherEntities;
    }
}
