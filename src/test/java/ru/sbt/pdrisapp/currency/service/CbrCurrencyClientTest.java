package ru.sbt.pdrisapp.currency.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sbt.pdrisapp.currency.model.db.CurrencyEntity;
import ru.sbt.pdrisapp.currency.repository.CurrencyRepository;

import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class CbrCurrencyClientTest {
    @MockBean
    CurrencyRepository currencyRepository;

    @Test
    public void getCurrency() {
        CbrCurrencyClient cbrCurrencyClient = new CbrCurrencyClient(new CurrencyCache(currencyRepository));
        try {
            String date = "2020-12-12";
            List<CurrencyEntity> currencyEntityList = cbrCurrencyClient.getCurrency(null, date, date);
            assertEquals(1, currencyEntityList.size());
        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }
}