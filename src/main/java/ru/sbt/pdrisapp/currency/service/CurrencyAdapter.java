package ru.sbt.pdrisapp.currency.service;

import ru.sbt.pdrisapp.currency.model.cbr.CurrencyList;
import ru.sbt.pdrisapp.currency.model.cbr.Record;
import ru.sbt.pdrisapp.currency.model.db.CurrencyEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CurrencyAdapter {
    public static List<CurrencyEntity> getCurrencyEntities(CurrencyList currencyList)
        throws ParseException {
        List<CurrencyEntity> currencyEntities = new ArrayList<>();

        List<Record> records = currencyList.getRecords();
        for (Record record: records) {
            Date date = new SimpleDateFormat("dd.MM.yyyy").parse(record.getDate());
            currencyEntities.add(new CurrencyEntity(record.getValue(), date));
        }

        return currencyEntities;
    }
}
