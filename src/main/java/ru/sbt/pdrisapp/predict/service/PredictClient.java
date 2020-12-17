package ru.sbt.pdrisapp.predict.service;

import org.springframework.stereotype.Service;
import ru.sbt.pdrisapp.predict.model.CurrencyList;
import ru.sbt.pdrisapp.predict.model.Sample;
import ru.sbt.pdrisapp.predict.model.WeatherList;
import ru.sbt.pdrisapp.utils.DateCalc;
import ru.sbt.pdrisapp.weather.model.db.WeatherEntity;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PredictClient {
    private static final int DAYS_NUMBER = 7;
    private final SimpleDateFormat defaultFormatter = new SimpleDateFormat("yyyy-MM-dd");
    private final Predictor predictor = new Predictor();

    public double getPrediction() {
        Map<Date, Sample> samplesMap = new HashMap<>();

        Date today = DateCalc.getDate();
        Date tomorrow = DateCalc.getDate(today, 1);
        Date startDate = DateCalc.getDate(today, -1 * DAYS_NUMBER);

        CurrencyApiClient currencyApiClient = new CurrencyApiClient();
        CurrencyList currencyList = currencyApiClient.getCurrency(
                defaultFormatter.format(startDate),
                defaultFormatter.format(today)
        );

        currencyList.getCurrency().forEach(currencyEntity -> {
            Sample sample = new Sample();
            sample.setCurrency(currencyEntity.getValue());
            samplesMap.put(currencyEntity.getDate(), sample);
        });

        WeatherApiClient weatherApiClient = new WeatherApiClient();
        WeatherList weatherList = weatherApiClient.getWeather(
                defaultFormatter.format(startDate),
                defaultFormatter.format(tomorrow)
        );

        double tomorrowTemp = 0;
        for (WeatherEntity weatherEntity: weatherList.getWeather()) {
            Date date = weatherEntity.getDate();
            double temp = weatherEntity.getTemp();

            Sample sample = samplesMap.get(date);
            if (sample != null) {
                sample.setTemp(temp);
            }

            if (date.equals(tomorrow)) {
                tomorrowTemp = temp;
            }
        }

        List<Sample> samplesList = new ArrayList<>(samplesMap.values());
        double[][] samplesArray = new double[samplesList.size()][2];
        int i = 0;
        for (Sample element: samplesList) {
            samplesArray[i][0] = element.getTemp();
            samplesArray[i][1] = element.getCurrency();
            i++;
        }

        return predictor.train(samplesArray).predict(tomorrowTemp);
    }
}
