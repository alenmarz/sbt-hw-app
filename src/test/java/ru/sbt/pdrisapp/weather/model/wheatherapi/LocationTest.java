package ru.sbt.pdrisapp.weather.model.wheatherapi;

import junit.framework.TestCase;

public class LocationTest extends TestCase {

    public void testGetName() {
        Location location = new Location("Dublin");
        assertEquals(location.getName(), "Dublin");
    }

    public void testSetName() {
        Location location = new Location();
        location.setName("Dublin");
        assertEquals(location.getName(), "Dublin");
    }
}