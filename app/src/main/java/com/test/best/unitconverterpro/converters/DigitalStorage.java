package com.test.best.unitconverterpro.converters;

public class DigitalStorage {

    public static double convertDigitalStorage(double value, double to, double from) {
        double result = (value * from) / to;

        return result;
    }
}
