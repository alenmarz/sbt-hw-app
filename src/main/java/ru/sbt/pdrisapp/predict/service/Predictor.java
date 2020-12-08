package ru.sbt.pdrisapp.predict.service;

import org.apache.commons.math3.stat.regression.SimpleRegression;

public class Predictor {
    private final SimpleRegression simpleRegression;

    public Predictor() {
        this.simpleRegression = new SimpleRegression(true);
    }

    public Predictor train(double[][] samples) {
        simpleRegression.addData(samples);

        return this;
    }

    public double predict(Double value) {
        return simpleRegression.predict(value);
    }
}
