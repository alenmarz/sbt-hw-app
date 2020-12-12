package ru.sbt.pdrisapp.weather.model.wheatherapi;

import junit.framework.TestCase;
import org.junit.Test;

public class LocationTest extends TestCase {

    @Test
    public void testGetName() {
        Location location = new Location("Dublin");
        assertEquals(location.getName(), "Dublin");
    }

    @Test
    public void testSetName() {
        Location location = new Location();
        location.setName("Dublin");
        assertEquals(location.getName(), "Dublin");
    }
}