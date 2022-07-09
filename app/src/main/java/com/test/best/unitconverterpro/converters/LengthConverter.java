package com.test.best.unitconverterpro.converters;

public class LengthConverter {

    public static double convertLength(double value, double to, double from) {
        return (value * from) / to;
    }
}
