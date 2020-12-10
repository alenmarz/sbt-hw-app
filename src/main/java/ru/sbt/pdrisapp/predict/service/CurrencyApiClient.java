package ru.sbt.pdrisapp.predict.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.sbt.pdrisapp.predict.model.CurrencyList;
import ru.sbt.pdrisapp.utils.UriBuilder;

@Service
public class CurrencyApiClient {
    private static final String ApiUrl = "http://localhost:8080/currency";

    public static CurrencyList getCurrency(String startDate, String endDate) {
        UriBuilder uri = new UriBuilder(ApiUrl)
                .queryParam("start_date", startDate)
                .queryParam("end_date", endDate);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CurrencyList> responseEntity = restTemplate.getForEntity(
                uri.toUriString(),
                CurrencyList.class
        );

        return responseEntity.getBody();
    }
}
