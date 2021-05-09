package ru.sbt.currency.model.cbr;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class Record {
    @JacksonXmlProperty(localName = "Date")
    private String date;
    @JacksonXmlProperty(localName = "Id")
    private String id;
    @JacksonXmlProperty(localName = "Nominal")
    private String nominal;
    @JacksonXmlProperty(localName = "Value")
    private double value;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }

    public double getValue() {
        return value;
    }

    public void setValue(String value) throws ParseException {
        NumberFormat format = NumberFormat.getInstance(Locale.FRANCE);
        Number number = format.parse(value);
        this.value = number.doubleValue();
    }

}
