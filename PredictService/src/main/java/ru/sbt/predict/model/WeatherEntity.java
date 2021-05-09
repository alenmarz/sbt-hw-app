package ru.sbt.predict.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class WeatherEntity {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private @Id @GeneratedValue Long id;
    private Date date;
    private String city;
    private Double temp;

    public WeatherEntity() {}

    public WeatherEntity(Date date, String city, Double temp) {
        this.date = date;
        this.city = city;
        this.temp = temp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
