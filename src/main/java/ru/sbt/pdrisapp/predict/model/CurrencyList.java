package ru.sbt.pdrisapp.predict.model;

import ru.sbt.pdrisapp.currency.model.db.CurrencyEntity;

import java.util.List;

public class CurrencyList {
    private List<CurrencyEntity> currency;

    public CurrencyList() {}

    public List<CurrencyEntity> getCurrency() {
        return currency;
    }

    public void setCurrency(List<CurrencyEntity> currency) {
        this.currency = currency;
    }
}
