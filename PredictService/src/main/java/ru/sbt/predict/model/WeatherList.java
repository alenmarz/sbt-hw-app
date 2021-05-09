package ru.sbt.predict.model;

import ru.sbt.predict.model.WeatherEntity;

import java.util.List;

public class WeatherList {
    private List<WeatherEntity> weather;

    public List<WeatherEntity> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherEntity> weather) {
        this.weather = weather;
    }
}
