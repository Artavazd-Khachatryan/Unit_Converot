package com.test.best.unitconverterpro.section_factory;

import com.test.best.unitconverterpro.R;
import com.test.best.unitconverterpro.section.Area;
import com.test.best.unitconverterpro.section.DigitalStorage;
import com.test.best.unitconverterpro.section.FuelConsumption;
import com.test.best.unitconverterpro.section.Length;
import com.test.best.unitconverterpro.section.Mass;
import com.test.best.unitconverterpro.section.Section;
import com.test.best.unitconverterpro.section.Speed;
import com.test.best.unitconverterpro.section.Temperature;
import com.test.best.unitconverterpro.section.Time;
import com.test.best.unitconverterpro.section.Volume;

import java.util.HashMap;
import java.util.Map;


public class SectionFactory {

    public static Map<String, Double> getSectionMap(String section) {

        Map<String,Double> sectionMap = new HashMap<>();
        switch (section) {
            case Section.TEMPERATURE:
                sectionMap = getTemperatureMap();
                break;
            case Section.LENGTH:
                sectionMap = getLengthMap();
                break;
            case Section.MASS:
                sectionMap = getMassMap();
                break;
            case Section.SPEED:
                sectionMap = getSpeedMap();
                break;
            case Section.VOLUME:
                sectionMap = getVolumeMap();
                break;
            case Section.AREA:
                sectionMap = getAreaMap();
                break;
            case Section.FUEL_CONSUMPTION:
                sectionMap = getFuelConsuptionMap();
                break;
            case Section.TIME:
                sectionMap = getTimeMap();
                break;
            case Section.DIGITAL_STORAGE:
                sectionMap = getDigitalStorageMap();
                break;

        }

        return sectionMap;
    }

    public static Map<String,Double> getTemperatureMap(){

        //Celsius

        Map<String,Double> temperatureList = new HashMap<>();
        temperatureList.put(Temperature.CELSIUS,0d);
        temperatureList.put(Temperature.FAHRENHEIT,32d);
        temperatureList.put(Temperature.KELVIN,273.15d);

        return temperatureList;
    }

    public static Map<String, Double> getLengthMap () {

        //Milimetr

        Map<String, Double> lengthList = new HashMap<>();
        lengthList.put(Length.MILLIMETER, 1d);
        lengthList.put(Length.CENTIMETER, 10d);
        lengthList.put(Length.METER, 1000d);
        lengthList.put(Length.KILOMETER, 1000000d);
        lengthList.put(Length.MILE, 1609344d);
        lengthList.put(Length.YARD, 914.4d);
        lengthList.put(Length.FOOT, 304.8d);
        lengthList.put(Length.INCH, 25.4d);
        lengthList.put(Length.NAUTICAL_MILE, 1851852d);

        return lengthList;
    }

    public static Map<String, Double> getMassMap () {

        //Milligram

        Map<String, Double> massList = new HashMap<>();
        massList.put(Mass.MILLIGRAM, 1d);
        massList.put(Mass.GRAM, 1000d);
        massList.put(Mass.METRIC_TON, 1.0E9);
        massList.put(Mass.KILOGRAM, 1000000d);
        massList.put(Mass.MCG, 0.001);
        massList.put(Mass.LONG_TON, 1.016E9);
        massList.put(Mass.SHORT_TON, 9.072E8);
        massList.put(Mass.STONE, 6350000d);
        massList.put(Mass.POUND, 453592d);
        massList.put(Mass.OUNCE, 28349.5d);

        return massList;
    }

    public static Map<String, Double> getSpeedMap () {

        //Meter/Sec

        Map<String, Double> speedList = new HashMap<>();
        speedList.put(Speed.METERS_SEC, 1d);
        speedList.put(Speed.MILES_HOUR, 0.44704);
        speedList.put(Speed.FEET_SEC, 0.3048);
        speedList.put(Speed.KM_HOUR, 0.277778);
        speedList.put(Speed.KNOT, 0.514444);

        return speedList;
    }

    public static Map<String, Double> getVolumeMap () {

        //Milliliter

        Map<String, Double> volumeList = new HashMap<>();
        volumeList.put(Volume.MILLILITER, 1d);
        volumeList.put(Volume.US_GAL, 3785.41);
        volumeList.put(Volume.US_QUART, 946.353);
        volumeList.put(Volume.US_PINT, 473.176);
        volumeList.put(Volume.US_CUP, 236.588);
        volumeList.put(Volume.US_OZ, 29.5735);
        volumeList.put(Volume.US_TBSP, 14.7868);
        volumeList.put(Volume.US_TSP, 4.92892);
        volumeList.put(Volume.CUBIC_METER, 1000000d);
        volumeList.put(Volume.LITER, 1000d);
        volumeList.put(Volume.IMPERIAL_GAL, 4546.09);
        volumeList.put(Volume.IMPERIAL_QUART, 1136.52);
        volumeList.put(Volume.IMPERIAL_PINT, 568.261);
        volumeList.put(Volume.IMPERIAL_OZ, 28.4131);
        volumeList.put(Volume.IMPERIAL_TBSP, 17.7582);
        volumeList.put(Volume.IMPERIAL_TSP, 5.91939);
        volumeList.put(Volume.CUBIC_FOOT, 28316.8);
        volumeList.put(Volume.CUBIC_INCH, 16.3871);
        return volumeList;
    }

    public static Map<String, Double> getAreaMap () {

        //Square meter

        Map<String, Double> areaList = new HashMap<>();
        areaList.put(Area.SQUARE_METER, 1d);
        areaList.put(Area.SQUARE_KM, 1000000d);
        areaList.put(Area.HECTARE, 10000d);
        areaList.put(Area.SQUARE_MILE, 2590000d);
        areaList.put(Area.ACRE, 4046.86);
        areaList.put(Area.SQUARE_YARD, 0.836127);
        areaList.put(Area.SQUARE_FOOT, 0.092903);
        areaList.put(Area.SQUARE_INCH, 6.4516E-4);

        return areaList;
    }

    public static Map<String, Double> getFuelConsuptionMap () {

        //Km/liter

        Map<String, Double> fuelConsumptionList = new HashMap<>();
        fuelConsumptionList.put(FuelConsumption.KM_LITER, 1d);
        fuelConsumptionList.put(FuelConsumption.MPG_US, 0.425144);
        fuelConsumptionList.put(FuelConsumption.MPG_IMP, 0.354006);
        fuelConsumptionList.put(FuelConsumption.LITER_100KM, 100d);

        return fuelConsumptionList;
    }

    public static Map<String, Double> getTimeMap () {

        //Millisecond

        Map<String, Double> timeList = new HashMap<>();
        timeList.put(Time.MILLISECOND, 1d);
        timeList.put(Time.NANOSECOND, 1.0E-6);
        timeList.put(Time.MICROSECOND, 0.001);
        timeList.put(Time.SECOND, 1000d);
        timeList.put(Time.MINUTE, 60000d);
        timeList.put(Time.HOUR, 3600000d);
        timeList.put(Time.DAY, 8.64E7);
        timeList.put(Time.WEEK, 6.048E8);
        timeList.put(Time.MONTH, 2.63E9);
        timeList.put(Time.YEAR, 3.156E13);
        timeList.put(Time.DECADE, 3.156E14);
        timeList.put(Time.CENTURY, 3.156E15);


        return timeList;
    }

    public static Map<String, Double> getDigitalStorageMap () {

        //Bit

        Map<String, Double> digitalStorageList = new HashMap<>();
        digitalStorageList.put(DigitalStorage.BIT, 1d);
        digitalStorageList.put(DigitalStorage.BYTE, 8d);
        digitalStorageList.put(DigitalStorage.KILOBITS, 1024d);
        digitalStorageList.put(DigitalStorage.KILOBYTE, 8192d);
        digitalStorageList.put(DigitalStorage.MEGABIT, 1048576d);
        digitalStorageList.put(DigitalStorage.MEGABYTE, 8388608d);
        digitalStorageList.put(DigitalStorage.GIGABIT, 1073741824d);
        digitalStorageList.put(DigitalStorage.GIGABYTE, 8589934592d);
        digitalStorageList.put(DigitalStorage.TERABIT, 1099511627776d);
        digitalStorageList.put(DigitalStorage.TERABYTE, 8796093022208d);
        digitalStorageList.put(DigitalStorage.PETABIT, 1125899906842624d);
        digitalStorageList.put(DigitalStorage.Petabyte, 9007199254740992d);

        return digitalStorageList;
    }

    public static Map<String, Integer> getSectionTitleImage(){
        Map<String,Integer> titleImageMap = new HashMap<>();

        titleImageMap.put(Section.TEMPERATURE, R.drawable.temperature);
        titleImageMap.put(Section.LENGTH,R.drawable.length);
        titleImageMap.put(Section.MASS,R.drawable.mass);
        titleImageMap.put(Section.SPEED,R.drawable.speed);
        titleImageMap.put(Section.AREA,R.drawable.area);
        titleImageMap.put(Section.VOLUME,R.drawable.volume);
        titleImageMap.put(Section.TIME,R.drawable.time);
        titleImageMap.put(Section.DIGITAL_STORAGE,R.drawable.digital_storage);

        return titleImageMap;
    }



}
