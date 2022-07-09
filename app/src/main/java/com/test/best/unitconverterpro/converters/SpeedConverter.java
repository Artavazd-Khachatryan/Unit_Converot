package com.test.best.unitconverterpro.converters;

public class SpeedConverter {

    public static double convertSpeed(double value, double to, double from) {
        return (value * from) / to;
    }
}
