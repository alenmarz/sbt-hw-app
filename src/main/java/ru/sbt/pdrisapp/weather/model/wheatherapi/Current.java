package ru.sbt.pdrisapp.weather.model.wheatherapi;

public class Current {
    private Double temp_c;

    public Current() {}

    public Current(Double temp_c) {
        this.temp_c = temp_c;
    }

    public Double getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(Double temp_c) {
        this.temp_c = temp_c;
    }

}
