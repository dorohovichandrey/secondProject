package by.bsu.dorohovich.ooptask.vehicle;

import by.bsu.dorohovich.ooptask.enm.Manufacturer;
import by.bsu.dorohovich.ooptask.exception.WrongArgumentException;
import by.bsu.dorohovich.ooptask.enm.FuelType;

/**
 * Created by User on 26.09.2016.
 */
public abstract class Automobile extends Vehicle {

    private int fuelConsumption;
    private FuelType fuelType;

    public Automobile(long vehicleId,
                      Manufacturer manufacturer,
                      int year,
                      int tariffDollarByKm,
                      int tonnage,
                      int passengerCapacity,
                      int fuelConsumption,
                      FuelType fuelType)   throws WrongArgumentException {
        super(vehicleId, manufacturer, year, tariffDollarByKm, tonnage, passengerCapacity);
        setFuelConsumption(fuelConsumption);
        setFuelType(fuelType);
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) throws WrongArgumentException {
        if(fuelConsumption<0)
        {
            throw new WrongArgumentException("fuelConsumtion="+fuelConsumption);
        }
        this.fuelConsumption = fuelConsumption;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public void setFuelType(FuelType fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", fuelConsumption=" + fuelConsumption +
                ", fuelType="+fuelType;
    }
}
