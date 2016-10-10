package test.by.bsu.dorohovich.ooptask;

import by.bsu.dorohovich.ooptask.enm.FuelType;
import by.bsu.dorohovich.ooptask.enm.Manufacturer;
import by.bsu.dorohovich.ooptask.enm.Material;
import by.bsu.dorohovich.ooptask.create.VehicleFactory;
import by.bsu.dorohovich.ooptask.exception.WrongArgumentException;
import by.bsu.dorohovich.ooptask.taxistation.management.PriceCounter;
import by.bsu.dorohovich.ooptask.vehicle.Vehicle;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by User on 27.09.2016.
 */
public class Tester {
    @Test
    public void countVehiclePriceForAutomobileTest1() throws WrongArgumentException
    {
        VehicleFactory vehicleFactory=new VehicleFactory();
        Vehicle vehicle=vehicleFactory.createCar(1, Manufacturer.AUDI, 2010,2,3, FuelType.DIESEL, 2, 4, true);
        PriceCounter priceCounter=new PriceCounter();
        int actual=priceCounter.countVehiclePrice(vehicle);
        int expected=23340;

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void countVehiclePriceForAutomobileTest2() throws WrongArgumentException
    {
        VehicleFactory vehicleFactory=new VehicleFactory();
        Vehicle vehicle=vehicleFactory.createCar(1, Manufacturer.KIA, 2010,2,3, FuelType.DIESEL, 2, 5, true);
        PriceCounter priceCounter=new PriceCounter();
        int actual=priceCounter.countVehiclePrice(vehicle);
        int expected=7980;

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void countVehiclePriceForTrailerTest1() throws WrongArgumentException
    {
        VehicleFactory vehicleFactory=new VehicleFactory();
        Vehicle vehicle=vehicleFactory.createPassengerTrailer(2,Manufacturer.RENO, 2009, 2, 0, 10, Material.METAL, true, false);
        PriceCounter priceCounter=new PriceCounter();
        int actual=priceCounter.countVehiclePrice(vehicle);
        int expected=3925;

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void countVehiclePriceForTrailerTest2() throws WrongArgumentException
    {
        VehicleFactory vehicleFactory=new VehicleFactory();
        Vehicle vehicle=vehicleFactory.createCargoTrailer(2,Manufacturer.BMW, 2007, 3, 15, 0, Material.METAL, true);
        PriceCounter priceCounter=new PriceCounter();
        int actual=priceCounter.countVehiclePrice(vehicle);
        int expected=12225;

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void countVehiclesListPrice() throws WrongArgumentException
    {
        VehicleFactory vehicleFactory=new VehicleFactory();
        List<Vehicle> vehicles=Arrays.asList(
                vehicleFactory.createCargoTrailer(7,Manufacturer.BMW, 2007, 3, 15, 0, Material.METAL, true),
                vehicleFactory.createCargoTrailer(6,Manufacturer.CITROEN, 2016, 2, 15, 0, Material.METAL, true),
                vehicleFactory.createPassengerTrailer(5,Manufacturer.RENO, 2009, 2, 0, 10, Material.METAL, true, false),
                vehicleFactory.createCar(1, Manufacturer.AUDI, 2010,2,3, FuelType.DIESEL, 2, 4, true),
                vehicleFactory.createBus(3, Manufacturer.AUDI, 2011,2,3, FuelType.DIESEL, 2, 20, true),
                vehicleFactory.createCar(4, Manufacturer.TESLA, 2016,2,3, FuelType.DIESEL, 3, 4, true),
                vehicleFactory.createTruck(10, Manufacturer.VOLKSWAGEN, 2000,2,3, FuelType.DIESEL, 20, 5, true),
                vehicleFactory.createBus(31, Manufacturer.TOYOTA, 2013,2,3, FuelType.DIESEL, 2, 20, true),
                vehicleFactory.createTruck(41, Manufacturer.TESLA, 2016,2,3, FuelType.DIESEL, 30, 4, true)
                );
        PriceCounter priceCounter=new PriceCounter();
        int actual=priceCounter.countVehiclesListPrice(vehicles);
        int expected=240120;

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void fileOutputValidTest()
    {
        File file=new File("output/outp.txt");
        boolean actual=file.exists();
        boolean expected=true;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fileInputValidTest()
    {
        File file=new File("input/vehicles.txt");
        boolean actual=file.exists();
        boolean expected=true;
        Assert.assertEquals(expected, actual);
    }



}
