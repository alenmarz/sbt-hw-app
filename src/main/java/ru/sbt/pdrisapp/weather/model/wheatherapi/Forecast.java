package ru.sbt.pdrisapp.weather.model.wheatherapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Forecast {
    @JsonProperty("forecastday")
    private List<ForecastDay> forecastDayList;

    public Forecast() {}

    public Forecast(List<ForecastDay> forecastDayList) {
        this.forecastDayList = forecastDayList;
    }

    public List<ForecastDay> getForecastDayList() {
        return forecastDayList;
    }

    public void setForecastDayList(List<ForecastDay> forecastDayList) {
        this.forecastDayList = forecastDayList;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "forecastDayList=" + forecastDayList +
                '}';
    }
}
