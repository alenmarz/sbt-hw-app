package ru.sbt.weather.service;

import org.springframework.stereotype.Service;
import ru.sbt.weather.model.db.WeatherEntity;
import ru.sbt.weather.repository.WeatherRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherCache {
    private final WeatherRepository weatherRepository;

    WeatherCache(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    List<WeatherEntity> getCachedWeatherEntities(String city, Date startDate, Date endDate) {
        List<WeatherEntity> weatherEntitiesBetween =
                weatherRepository.findByCityAndDateBetween(city, startDate, endDate);
        long diff = endDate.getTime() - startDate.getTime();

        if (weatherEntitiesBetween.size() == TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1) {
            return weatherEntitiesBetween;
        }

        weatherRepository.deleteWeatherEntitiesByCityAndDateBetween(city, startDate, endDate);

        return new ArrayList<>();
    }

    void saveWeatherEntities(List<WeatherEntity> weatherEntities) {
        weatherRepository.saveAll(weatherEntities);
    }
}
