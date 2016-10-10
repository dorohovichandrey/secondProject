package by.bsu.dorohovich.ooptask.vehicle;

import by.bsu.dorohovich.ooptask.enm.Manufacturer;
import by.bsu.dorohovich.ooptask.exception.WrongArgumentException;
import by.bsu.dorohovich.ooptask.enm.FuelType;

/**
 * Created by User on 26.09.2016.
 */
public class Bus extends Automobile {

    private boolean hasSecondFloor;

    public Bus(long vehicleId,
               Manufacturer manufacturer,
               int year,
               int tariffDollarByKm,
               int fuelConsumption,
               FuelType fuelType,
               int tonnage,
               int passengerCapacity,
               boolean hasSecondFloor) throws WrongArgumentException {
        super(vehicleId, manufacturer, year, tariffDollarByKm,tonnage, passengerCapacity, fuelConsumption, fuelType);
        setHasSecondFloor(hasSecondFloor);
    }

    public boolean hasSecondFloor() {
        return hasSecondFloor;
    }

    public void setHasSecondFloor(boolean hasSecondFloor) {
        this.hasSecondFloor = hasSecondFloor;
    }

    @Override
    public String toString() {
        return "Bus{" + super.toString()+
                ", hasSecondFloor=" + hasSecondFloor +
                '}';
    }
}
