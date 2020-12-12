package ru.sbt.pdrisapp.currency.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sbt.pdrisapp.currency.model.db.CurrencyEntity;
import ru.sbt.pdrisapp.currency.repository.CurrencyRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class CurrencyCacheTest {
    @MockBean
    CurrencyRepository currencyRepository;

    @Test
    public void getCachedCurrencyEntities() {
        CurrencyCache currencyCache = new CurrencyCache(currencyRepository);
        Date date = new Date();
        assertNull(currencyCache.getCachedCurrencyEntities("code", date, date));
    }

    @Test
    public void saveCurrencyEntities() {
        CurrencyEntity currencyEntity = new CurrencyEntity();
        List<CurrencyEntity> currencyEntityList = new ArrayList<>();
        currencyEntityList.add(currencyEntity);
        CurrencyCache currencyCache = new CurrencyCache(currencyRepository);
        currencyCache.saveCurrencyEntities(currencyEntityList);
    }
}