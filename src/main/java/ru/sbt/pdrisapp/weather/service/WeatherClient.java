package ru.sbt.pdrisapp.weather.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.sbt.pdrisapp.utils.UriBuilder;
import ru.sbt.pdrisapp.weather.model.db.WeatherEntity;
import ru.sbt.pdrisapp.weather.model.wheatherapi.Weather;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class WeatherClient {
    private static final String API_URL = "http://api.weatherapi.com/v1/history.json";
    private static final String API_KEY = "4fb94601eaa2453f890205113200412";
    private static final String DEFAULT_CITY = "Moscow";
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    private final WeatherCache weatherCache;

    WeatherClient(WeatherCache weatherCache) {
        this.weatherCache = weatherCache;
    }

    public List<WeatherEntity> getWeather(String city, String startDateString, String endDateString)
        throws ParseException {

        if (startDateString == null || endDateString == null) {
            startDateString = endDateString = formatter.format(new Date());
        }

        if (city == null || city.isEmpty()) {
            city = DEFAULT_CITY;
        }

        Date startDate = formatter.parse(startDateString);
        Date endDate = formatter.parse(endDateString);

        List<WeatherEntity> weatherEntities = weatherCache.getCachedWeatherEntities(city, startDate, endDate);
        if (!weatherEntities.isEmpty()) {
            return weatherEntities;
        }

        UriBuilder uri = new UriBuilder(API_URL)
                .queryParam("key", API_KEY)
                .queryParam("q", city)
                .queryParam("dt", startDateString)
                .queryParam("end_dt", endDateString);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Weather> responseEntity = restTemplate.getForEntity(
                uri.toUriString(),
                Weather.class
        );

        weatherEntities = WeatherAdapter.getWeatherEntities(responseEntity.getBody());
        weatherCache.saveWeatherEntities(weatherEntities);

        return weatherEntities;
    }
}
