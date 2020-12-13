package ru.sbt.pdrisapp.currency.service;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.sbt.pdrisapp.currency.model.cbr.CurrencyList;
import ru.sbt.pdrisapp.currency.model.db.CurrencyEntity;
import ru.sbt.pdrisapp.utils.UriBuilder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class CbrCurrencyClient {
    private static final String API_URL = "http://www.cbr.ru/scripts/XML_dynamic.asp";
    private static final String DEFAULT_CURRENCY_CODE = "R01235";
    private final SimpleDateFormat defaultFormatter = new SimpleDateFormat("yyyy-MM-dd");
    private final SimpleDateFormat cbrFormatter = new SimpleDateFormat("dd.MM.yyyy");

    private final CurrencyCache currencyCache;

    CbrCurrencyClient(CurrencyCache currencyCache) {
        this.currencyCache = currencyCache;
    }

    public List<CurrencyEntity> getCurrency(String code, String startDateString, String endDateString)
        throws ParseException {

        if (startDateString == null || endDateString == null) {
            startDateString = endDateString = defaultFormatter.format(new Date());
        }

        if (code == null || code.isEmpty()) {
            code = DEFAULT_CURRENCY_CODE;
        }

        Date startDate = defaultFormatter.parse(startDateString);
        Date endDate = defaultFormatter.parse(endDateString);

        List<CurrencyEntity> currencyEntities = currencyCache.getCachedCurrencyEntities(code, startDate, endDate);
        if (!currencyEntities.isEmpty()) {
            return currencyEntities;
        }

        UriBuilder uri = new UriBuilder(API_URL)
                .queryParam("VAL_NM_RQ", code)
                .queryParam("date_req1", cbrFormatter.format(startDate))
                .queryParam("date_req2", cbrFormatter.format(endDate));

        RestTemplate restTemplate = new RestTemplate();

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        MappingJackson2XmlHttpMessageConverter converter = new MappingJackson2XmlHttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_XML));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);

        ResponseEntity<CurrencyList> responseEntity = restTemplate.getForEntity(
                uri.toUriString(),
                CurrencyList.class
        );

        currencyEntities = CurrencyAdapter.getCurrencyEntities(responseEntity.getBody());
        currencyCache.saveCurrencyEntities(currencyEntities);

        return currencyEntities;
    }
}
