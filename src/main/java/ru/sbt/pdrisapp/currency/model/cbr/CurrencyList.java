package ru.sbt.pdrisapp.currency.model.cbr;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class CurrencyList {
    @JacksonXmlProperty(localName = "Record")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Record> records;
    @JacksonXmlProperty(localName = "ID")
    private String ID;
    @JacksonXmlProperty(localName = "DateRange1")
    private String dateRange1;
    @JacksonXmlProperty(localName = "DateRange2")
    private String dateRange2;
    private String name;

    public CurrencyList() {
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDateRange1() {
        return dateRange1;
    }

    public void setDateRange1(String dateRange1) {
        this.dateRange1 = dateRange1;
    }

    public String getDateRange2() {
        return dateRange2;
    }

    public void setDateRange2(String dateRange2) {
        this.dateRange2 = dateRange2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
