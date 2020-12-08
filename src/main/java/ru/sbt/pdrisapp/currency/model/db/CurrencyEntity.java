package ru.sbt.pdrisapp.currency.model.db;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class CurrencyEntity {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private @Id @GeneratedValue Long id;
    private String code;
    private double value;
    private Date date;

    public CurrencyEntity() {}

    public CurrencyEntity(double value, Date date) {
        this.value = value;
        this.date = date;
        this.code = "R01235";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
