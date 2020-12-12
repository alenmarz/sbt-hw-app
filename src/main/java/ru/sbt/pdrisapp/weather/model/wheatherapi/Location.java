package ru.sbt.pdrisapp.weather.model.wheatherapi;

public class Location {
    private String name;

    public Location() {}

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
