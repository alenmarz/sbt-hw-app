package ru.sbt.pdrisapp.weather.model.wheatherapi;

import junit.framework.TestCase;

public class CurrentTest extends TestCase {

    public void testGetTemp_c() {
        Current current = new Current(12.0);
        assertEquals(current.getTemp_c(), 12.0);
    }

    public void testSetTemp_c() {
        Current current = new Current();
        current.setTemp_c(12.0);
        assertEquals(current.getTemp_c(), 12.0);
    }
}