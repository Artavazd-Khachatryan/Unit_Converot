package com.test.best.unitconverterpro.converters;

public class TimeConverter {

    public static double convertTime(double value, double to, double from) {
        return (value * from) / to;
    }
}
