package ru.sbt.currency.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sbt.currency.model.db.CurrencyEntity;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long> {
    Optional<CurrencyEntity> findByDate(Date date);
    List<CurrencyEntity> findByCodeAndDateBetween(String code, Date startDate, Date endDate);
    Long deleteCurrencyEntitiesByCodeAndDateBetween(String code, Date startDate, Date endDate);
}
