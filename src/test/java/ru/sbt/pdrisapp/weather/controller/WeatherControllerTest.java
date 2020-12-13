package ru.sbt.pdrisapp.weather.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class WeatherControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getWeather() throws Exception {
        mockMvc.perform(get("/weather"))
                .andExpect(status().isOk());
    }

    @Test
    public void getWeatherWithParseError() throws Exception {
        mockMvc.perform(get("/weather")
                .param("start_date", "test")
                .param("end_date", "test"))
                .andExpect(status().isOk());
    }
}