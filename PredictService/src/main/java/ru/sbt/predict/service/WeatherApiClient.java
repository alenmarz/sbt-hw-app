package ru.sbt.predict.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.sbt.predict.model.WeatherList;
import ru.sbt.utils.UriBuilder;

@Service
public class WeatherApiClient {
    private final String apiUrl = "http://localhost:8088/weather";

    public WeatherList getWeather(String startDate, String endDate) {

        UriBuilder uri = new UriBuilder(apiUrl)
                .queryParam("city", "Moscow")
                .queryParam("start_date", startDate)
                .queryParam("end_date", endDate);

        System.out.println(uri.toUriString());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<WeatherList> responseEntity = restTemplate.getForEntity(
                uri.toUriString(),
                WeatherList.class
        );

        return responseEntity.getBody();
    }
}
