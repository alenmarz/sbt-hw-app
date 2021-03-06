package ru.sbt.currency.service;

import org.springframework.stereotype.Service;
import ru.sbt.currency.model.db.CurrencyEntity;
import ru.sbt.currency.repository.CurrencyRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class CurrencyCache {
    private final CurrencyRepository currencyRepository;

    CurrencyCache(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    List<CurrencyEntity> getCachedCurrencyEntities(String code, Date startDate, Date endDate) {
        List<CurrencyEntity> currencyEntitiesBetween =
                currencyRepository.findByCodeAndDateBetween(code, startDate, endDate);

        long diff = endDate.getTime() - startDate.getTime();

        if (currencyEntitiesBetween.size() == TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1) {
            return currencyEntitiesBetween;
        }

        currencyRepository.deleteCurrencyEntitiesByCodeAndDateBetween(code, startDate, endDate);

        return new ArrayList<>();
    }

    void saveCurrencyEntities(List<CurrencyEntity> currencyEntities) {
        currencyRepository.saveAll(currencyEntities);
    }
}
