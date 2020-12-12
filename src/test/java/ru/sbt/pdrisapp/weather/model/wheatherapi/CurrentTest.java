package ru.sbt.pdrisapp.weather.model.wheatherapi;

import junit.framework.TestCase;
import org.junit.Test;

public class CurrentTest extends TestCase {

    @Test
    public void testGetTemp_c() {
        Current current = new Current(12.0);
        assertEquals(current.getTemp_c(), 12.0);
    }

    @Test
    public void testSetTemp_c() {
        Current current = new Current();
        current.setTemp_c(12.0);
        assertEquals(current.getTemp_c(), 12.0);
    }
}