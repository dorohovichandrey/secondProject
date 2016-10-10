package by.bsu.dorohovich.ooptask.create;

import by.bsu.dorohovich.ooptask.enm.Manufacturer;
import by.bsu.dorohovich.ooptask.exception.WrongArgumentException;
import by.bsu.dorohovich.ooptask.vehicle.Bus;
import by.bsu.dorohovich.ooptask.vehicle.Car;
import by.bsu.dorohovich.ooptask.enm.FuelType;
import by.bsu.dorohovich.ooptask.enm.Material;
import by.bsu.dorohovich.ooptask.enm.VehicleArgumentBound;
import by.bsu.dorohovich.ooptask.vehicle.CargoTrailer;
import by.bsu.dorohovich.ooptask.vehicle.PassengerTrailer;
import by.bsu.dorohovich.ooptask.vehicle.Truck;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by User on 27.09.2016.
 */
public class VehicleFactory {

    public VehicleFactory() {}


    public Car createCar(long vehicleId,
                         Manufacturer manufacturer,
                         int year,
                         int tariffDollarByKm,
                         int fuelConsumption,
                         FuelType fuelType,
                         int tonnage,
                         int passengerCapacity,
                         boolean hasBabySeat) throws WrongArgumentException {

        return new Car(vehicleId,
        manufacturer,
        year,
        tariffDollarByKm,
        tonnage,
        passengerCapacity,
        fuelConsumption,
        fuelType,
        hasBabySeat);

    }

    public Bus createBus(long vehicleId,
                         Manufacturer manufacturer,
                         int year,
                         int tariffDollarByKm,
                         int fuelConsumption,
                         FuelType fuelType,
                         int tonnage,
                         int passengerCapacity,
                         boolean hasSecondFloor) throws WrongArgumentException{
        return new Bus(vehicleId,
                manufacturer,
                year,
                tariffDollarByKm,
                fuelConsumption,
                fuelType,
                tonnage,
                passengerCapacity,
                hasSecondFloor);

    }

    public Truck createTruck(long vehicleId,
                             Manufacturer manufacturer,
                             int year,
                             int tariffDollarByKm,
                             int fuelConsumption,
                             FuelType fuelType,
                             int tonnage,
                             int passengerCapacity,
                             boolean hasSleepingPlace) throws WrongArgumentException{

        return new Truck(vehicleId,
                manufacturer,
                year,
                tariffDollarByKm,
                fuelConsumption,
                fuelType,
                tonnage,
                passengerCapacity,
                hasSleepingPlace);

    }

    public CargoTrailer createCargoTrailer(long vehicleId,
                                           Manufacturer manufacturer,
                                           int year,
                                           int tariffDollarByKm,
                                           int tonnage,
                                           int passengerCapacity,
                                           Material material,
                                           boolean hasLifter) throws WrongArgumentException {
        if(tonnage==0)
        {
            throw new WrongArgumentException("cargo trailers tonnage should be greater than 0, tonnage="+tonnage);
        }

        if(passengerCapacity!=0)
        {
            throw new WrongArgumentException("cargo trailers can't transfer passengers, passengerCapacity="+passengerCapacity);
        }
        return new CargoTrailer(vehicleId,
                                manufacturer,
                                year,
                                tariffDollarByKm,
                                tonnage,
                                passengerCapacity,
                                material,
                                hasLifter);
    }

    public PassengerTrailer createPassengerTrailer(long vehicleId,
                                                   Manufacturer manufacturer,
                                                   int year,
                                                   int tariffDollarByKm,
                                                   int tonnage,
                                                   int passengerCapacity,
                                                   Material material,
                                                   boolean hasKitchen,
                                                   boolean hasShower) throws WrongArgumentException {
        if(tonnage> VehicleArgumentBound.MAX_TONNAGE_FOR_PASSENGER_TRAILERS.getValue())
        {
            throw new WrongArgumentException("passenger trailers tonnage shoud be lower than 3, tonnage="+tonnage);
        }

        if(passengerCapacity==0)
        {
            throw new WrongArgumentException("passenger trailers passengerCapacity should be greater than 0, passengerCapacity="+passengerCapacity);
        }
        return new PassengerTrailer(vehicleId,
                manufacturer,
                year,
                tariffDollarByKm,
                tonnage,
                passengerCapacity,
                material,
                hasKitchen,
                hasShower);
    }






}
