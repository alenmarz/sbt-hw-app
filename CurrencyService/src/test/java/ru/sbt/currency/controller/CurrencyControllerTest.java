package ru.sbt.currency.controller;

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
public class CurrencyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getCurrency() throws Exception {
        mockMvc.perform(get("/currency"))
                .andExpect(status().isOk());
    }

    @Test
    public void getCurrencyWithParseError() throws Exception {
        mockMvc.perform(get("/currency")
                .param("start_date", "test")
                .param("end_date", "test"))
                .andExpect(status().isOk());
    }
}