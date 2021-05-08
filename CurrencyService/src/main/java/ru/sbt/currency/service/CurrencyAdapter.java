package ru.sbt.currency.service;

import ru.sbt.currency.model.cbr.CurrencyList;
import ru.sbt.currency.model.cbr.Record;
import ru.sbt.currency.model.db.CurrencyEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

public class CurrencyAdapter {
    private CurrencyAdapter() {}

    public static List<CurrencyEntity> getCurrencyEntities(CurrencyList currencyList)
        throws ParseException {
        List<CurrencyEntity> currencyEntities = new ArrayList<>();

        List<Record> records = currencyList.getRecords();
        if (records == null || records.isEmpty()) return currencyEntities;

        for (Record record: records) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
            sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
            Date date = sdf.parse(record.getDate());
            currencyEntities.add(new CurrencyEntity(record.getValue(), date));
        }

        return currencyEntities;
    }
}
