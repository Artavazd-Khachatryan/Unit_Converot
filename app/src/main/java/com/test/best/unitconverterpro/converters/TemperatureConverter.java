package com.test.best.unitconverterpro.converters;


import com.test.best.unitconverterpro.section.Temperature;

public class TemperatureConverter {

    public static double convertTemperature(double value, String to, String from) {
        double celsius = convertToCelsius(value, from);

        switch (to) {
            case Temperature.FAHRENHEIT:
                return celsiusToFahrenheit(celsius);
            case Temperature.KELVIN:
                return celsiusToKelvin(celsius);
            case Temperature.CELSIUS:
                return celsius;
        }

        return 0;

    }

    public static double convertToCelsius(double value, String type) {
        double celsius = value;
        switch (type) {
            case Temperature.CELSIUS:
                return celsius;
            case Temperature.FAHRENHEIT:
                return fahrenheitToCelsius(value);
            case Temperature.KELVIN:
                return kelvinToCelsius(value);
        }

        return celsius;

    }

    public static double kelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }
}
