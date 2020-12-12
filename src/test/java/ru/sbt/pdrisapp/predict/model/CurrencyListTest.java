package ru.sbt.pdrisapp.predict.model;

import org.junit.Test;
import ru.sbt.pdrisapp.currency.model.db.CurrencyEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CurrencyListTest {

    @Test
    public void getCurrency() {
        List<CurrencyEntity> currencyEntities = new ArrayList<>();
        CurrencyList currencyList = new CurrencyList();
        currencyList.setCurrency(currencyEntities);
        assertEquals(currencyList.getCurrency(), currencyEntities);
    }
}