package ru.sbt.pdrisapp.currency.service;

import org.junit.Test;
import ru.sbt.pdrisapp.currency.model.cbr.CurrencyList;
import ru.sbt.pdrisapp.currency.model.cbr.Record;
import ru.sbt.pdrisapp.currency.model.db.CurrencyEntity;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CurrencyAdapterTest {

    @Test
    public void getCurrencyEntities() {
        try {
            CurrencyList currencyList = new CurrencyList();
            Record record = new Record();
            record.setDate("12.12.2020");
            record.setValue("60,0");

            List<Record> records = new ArrayList<>();
            records.add(record);

            currencyList.setRecords(records);

            List<CurrencyEntity> currencyEntities = CurrencyAdapter.getCurrencyEntities(currencyList);

            CurrencyEntity currencyEntity = currencyEntities.get(0);
            assert currencyEntity.getValue() == 60.0;

        } catch (ParseException e) {
            fail(e.getMessage());
        }
    }
}