package ru.sbt.pdrisapp.predict.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class SampleTest {

    @Test
    public void getTemp() {
        Sample sample = new Sample();
        sample.setTemp(12.0);
        assert sample.getTemp() == 12.0;
    }

    @Test
    public void getCurrency() {
        Sample sample = new Sample();
        sample.setCurrency(60.0);
        assert sample.getCurrency() == 60.0;
    }
}