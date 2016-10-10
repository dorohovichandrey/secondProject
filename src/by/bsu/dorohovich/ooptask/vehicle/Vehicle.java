package by.bsu.dorohovich.ooptask.vehicle;

import by.bsu.dorohovich.ooptask.enm.Manufacturer;
import by.bsu.dorohovich.ooptask.enm.VehicleArgumentBound;
import by.bsu.dorohovich.ooptask.exception.WrongArgumentException;

/**
 * Created by User on 26.09.2016.
 */
public abstract class Vehicle {
    private long vehicleId;
    private Manufacturer manufacturer;
    private int year;
    private int tariffDollarByKm;
    private int tonnage;
    private int passengerCapacity;



    public Vehicle(long vehicleId,
                   Manufacturer manufacturer,
                   int year,
                   int tariffDollarByKm,
                   int tonnage,
                   int passengerCapacity) throws WrongArgumentException {
        setVehicleId(vehicleId);
        setManufacturer(manufacturer);
        setYear(year);
        setTariffDollarByKm(tariffDollarByKm);
        setTonnage(tonnage);
        setPassengerCapacity(passengerCapacity);
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;

    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) throws WrongArgumentException {
        if(year< VehicleArgumentBound.MIN_YEAR.getValue() || year>VehicleArgumentBound.MAX_YEAR.getValue())
        {
            throw new WrongArgumentException("year="+year);
        }
        this.year = year;
    }

    public int getTariffDollarByKm() {
        return tariffDollarByKm;
    }

    public void setTariffDollarByKm(int tariffDollarByKm) throws WrongArgumentException {
        if(tariffDollarByKm<VehicleArgumentBound.MIN_TARIFF.getValue())
        {
            throw new WrongArgumentException("tarrifDollarByKm="+tariffDollarByKm);
        }
        this.tariffDollarByKm = tariffDollarByKm;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) throws WrongArgumentException {
        if(passengerCapacity<0)
        {
            throw new WrongArgumentException("passangerCapacity="+passengerCapacity);
        }
        this.passengerCapacity = passengerCapacity;
    }

    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) throws WrongArgumentException {
        if(tonnage<0)
        {
            throw new WrongArgumentException("tonnage="+tonnage);
        }
        this.tonnage = tonnage;
    }

    @Override
    public String toString() {
        return
                "vehicleId=" + vehicleId +
                ", manufacturer=" + manufacturer +
                ", year=" + year +
                ", tariffDollarByKm=" + tariffDollarByKm +
                ", tonnage=" + tonnage +
                ", passengerCapacity=" + passengerCapacity;
    }


}
