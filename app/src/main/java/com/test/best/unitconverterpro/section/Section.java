package com.test.best.unitconverterpro.section;

public class Section {

    public static final String TEMPERATURE = "Temperature";
    public static final String LENGTH = "Length";
    public static final String MASS = "Mass";
    public static final String SPEED = "Speed";
    public static final String VOLUME = "Volume";
    public static final String AREA = "Area";
    public static final String FUEL_CONSUMPTION = "Fuel Consumption";
    public static final String TIME = "Time";
    public static final String DIGITAL_STORAGE = "Digital Storage";

    private final String title;
    private final int image;

    public Section(String title, int image) {
        this.title = title;
        this.image = image;

    }

    public String getTitle() {
        return title;
    }

    public int getImage() {
        return image;
    }
}
