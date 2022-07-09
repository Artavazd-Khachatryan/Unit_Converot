package com.test.best.unitconverterpro.converters;

public class AreaConverter {

    public static double convertArea(double value, double to, double from) {
        double result = (value * from) / to;

        return result;
    }
}
