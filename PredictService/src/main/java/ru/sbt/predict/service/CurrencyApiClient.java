package ru.sbt.predict.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.ApplicationContext;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.sbt.predict.model.CurrencyList;
import ru.sbt.utils.UriBuilder;

import javax.annotation.Resource;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Service
public class CurrencyApiClient {
    private final String apiUrl = "http://localhost:8089/currency";

    public CurrencyList getCurrency(String startDate, String endDate) {
        
        UriBuilder uri = new UriBuilder(apiUrl)
                .queryParam("start_date", startDate)
                .queryParam("end_date", endDate);

        System.out.println(uri.toUriString());

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<CurrencyList> responseEntity = restTemplate.getForEntity(
                uri.toUriString(),
                CurrencyList.class
        );

        return responseEntity.getBody();
    }
}
