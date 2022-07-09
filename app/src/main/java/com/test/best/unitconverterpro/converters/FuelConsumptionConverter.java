package com.test.best.unitconverterpro.converters;

public class FuelConsumptionConverter {

    public static double convertFuelConsumption(double value, double to, double from) {
        return (value * from) / to;
    }
}
