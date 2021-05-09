package ru.sbt.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbt.weather.model.db.WeatherEntity;

import java.util.Date;
import java.util.List;

public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
    List<WeatherEntity> findByCityAndDateBetween(String city, Date startDate, Date endDate);
    Long deleteWeatherEntitiesByCityAndDateBetween(String city, Date startDate, Date endDate);
}
