package ru.sbt.pdrisapp.currency.model.db;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class CurrencyEntityTest {

    @Test
    public void getCode() {
        CurrencyEntity currencyEntity = new CurrencyEntity(60.0, new Date());
        assertEquals(currencyEntity.getCode(), "R01235");
    }

    @Test
    public void setCode() {
        CurrencyEntity currencyEntity = new CurrencyEntity();
        currencyEntity.setCode("code");
        assertEquals(currencyEntity.getCode(), "code");
    }

    @Test
    public void getValue() {
        CurrencyEntity currencyEntity = new CurrencyEntity(60.0, new Date());
        assert currencyEntity.getValue() == 60.0;
    }

    @Test
    public void setValue() {
        CurrencyEntity currencyEntity = new CurrencyEntity();
        currencyEntity.setValue(60.0);
        assert currencyEntity.getValue() == 60.0;
    }

    @Test
    public void getDate() {
        Date date = new Date();
        CurrencyEntity currencyEntity = new CurrencyEntity(60.0, date);
        assertEquals(currencyEntity.getDate(), date);
    }

    @Test
    public void setDate() {
        Date date = new Date();
        CurrencyEntity currencyEntity = new CurrencyEntity();
        currencyEntity.setDate(date);
        assertEquals(currencyEntity.getDate(), date);
    }
}