package by.bsu.dorohovich.ooptask.enm;

/**
 * Created by User on 05.10.2016.
 */
public enum  VehicleArgumentBound {

    MIN_YEAR(2000), MAX_YEAR(2016), MAX_TONNAGE_FOR_PASSENGER_TRAILERS(2), MIN_TARIFF(2);


    int value;

    VehicleArgumentBound(int value) {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
