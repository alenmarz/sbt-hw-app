package ru.sbt.predict.model;

import ru.sbt.predict.model.CurrencyEntity;

import java.util.List;

public class CurrencyList {
    private List<CurrencyEntity> currency;

    public List<CurrencyEntity> getCurrency() {
        return currency;
    }

    public void setCurrency(List<CurrencyEntity> currency) {
        this.currency = currency;
    }
}
