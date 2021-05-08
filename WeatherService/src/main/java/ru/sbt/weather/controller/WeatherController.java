package ru.sbt.weather.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.sbt.weather.model.db.WeatherEntity;
import ru.sbt.weather.service.WeatherClient;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.util.List;

@Controller
public class WeatherController {
    private final WeatherClient weatherClient;

    WeatherController(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @GetMapping("/weather")
    @Transactional
    public String getWeather(Model model,
                             @RequestParam(value = "start_date", required = false) String startDate,
                             @RequestParam(value = "end_date", required = false) String endDate,
                             @RequestParam(value = "city", required = false) String city) {
        try {
            List<WeatherEntity> weatherEntities = weatherClient.getWeather(city, startDate, endDate);
            model.addAttribute("weather", weatherEntities);
        } catch (ParseException e) {
            model.addAttribute("error", e.getMessage());
        }
        return "jsonTemplate";
    }
}
