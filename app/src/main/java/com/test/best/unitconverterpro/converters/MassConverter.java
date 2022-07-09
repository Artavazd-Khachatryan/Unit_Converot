package com.test.best.unitconverterpro.converters;

public class MassConverter {

    public static double convertMass(double value, double to, double from) {
        return (value * from) / to;
    }
}
