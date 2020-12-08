package ru.sbt.pdrisapp.weather.model.wheatherapi;

import java.util.Date;

public class ForecastDay {
    private Date date;
    private Day day;

    public ForecastDay() {}

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static class Day {
        private Double avgtemp_c;

        public Day() {}

        public Double getAvgtemp_c() {
            return avgtemp_c;
        }

        public void setAvgtemp_c(Double avgtemp_c) {
            this.avgtemp_c = avgtemp_c;
        }

        @Override
        public String toString() {
            return "Day{" +
                    "avgtemp_c=" + avgtemp_c +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ForecastDay{" +
                "date=" + date +
                ", day=" + day +
                '}';
    }
}
