package com.test.best.unitconverterpro.converters;

public class VolumeConverter {

    public static double convertVolume(double value, double to, double from) {
        return (value * from) / to;
    }
}
