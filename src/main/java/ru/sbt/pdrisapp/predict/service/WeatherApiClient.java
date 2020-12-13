package ru.sbt.pdrisapp.predict.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.sbt.pdrisapp.predict.model.WeatherList;
import ru.sbt.pdrisapp.utils.UriBuilder;

@Service
public class WeatherApiClient {
    private WeatherApiClient() {}

    private static final String API_URL = "http://localhost:8080/weather";

    public static WeatherList getWeather(String startDate, String endDate) {
        UriBuilder uri = new UriBuilder(API_URL)
                .queryParam("city", "Moscow")
                .queryParam("start_date", startDate)
                .queryParam("end_date", endDate);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<WeatherList> responseEntity = restTemplate.getForEntity(
                uri.toUriString(),
                WeatherList.class
        );

        return responseEntity.getBody();
    }
}
