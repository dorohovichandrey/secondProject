package by.bsu.dorohovich.ooptask.create;

import by.bsu.dorohovich.ooptask.enm.Manufacturer;
import by.bsu.dorohovich.ooptask.exception.WrongArgumentException;
import by.bsu.dorohovich.ooptask.enm.FuelType;
import by.bsu.dorohovich.ooptask.enm.Material;
import by.bsu.dorohovich.ooptask.enm.VehicleType;
import by.bsu.dorohovich.ooptask.exception.NotSuchEnumerationException;
import by.bsu.dorohovich.ooptask.vehicle.Vehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by User on 03.10.2016.
 */
public class VehiclesFromFileCreator {
    private static final Logger LOG= LogManager.getLogger();
    private Scanner scanner;
    private VehicleFactory vehicleFactory=new VehicleFactory();
    private List<Vehicle> vehicles=new ArrayList<Vehicle>();


    public List<Vehicle> createVehiclesList(File inpFile)
    {
        try {
            scanner = new Scanner(inpFile);


            Vehicle vehicle;
            while (scanner.hasNext()) {

                vehicle = createVehicleFromFile();
                if (vehicle != null) {
                    vehicles.add(vehicle);
                } else {
                    LOG.warn("Vehicle is not created");
                }
            }
            scanner.close();
        }
        catch (IOException e)
        {
            LOG.fatal(e);
            throw new RuntimeException("inpFile="+inpFile, e);
        }
        return vehicles;
    }

    private Vehicle createVehicleFromFile()
    {
        Vehicle vehicle=null;

        VehicleType vehType=VehicleType.valueOf(scanner.next());
        Long id=scanner.nextLong();
        Manufacturer manufacturer=Manufacturer.valueOf(scanner.next());
        int year=scanner.nextInt();
        int tariff=scanner.nextInt();
        int ton=scanner.nextInt();
        int pasCap=scanner.nextInt();

        try {
            switch (vehType) {
                case CAR:
                    vehicle=vehicleFactory.createCar(id,
                            manufacturer,
                            year,
                            tariff,
                            scanner.nextInt(),
                            FuelType.valueOf(scanner.next()),
                            ton,
                            pasCap,
                            scanner.nextBoolean()
                    );
                    break;
                case BUS:
                    vehicle=vehicleFactory.createBus(id,
                            manufacturer,
                            year,
                            tariff,
                            scanner.nextInt(),
                            FuelType.valueOf(scanner.next()),
                            ton,
                            pasCap,
                            scanner.nextBoolean()
                    );
                    break;
                case TRUCK:
                    vehicle=vehicleFactory.createTruck(id,
                            manufacturer,
                            year,
                            tariff,
                            scanner.nextInt(),
                            FuelType.valueOf(scanner.next()),
                            ton,
                            pasCap,
                            scanner.nextBoolean()
                            );
                    break;
                case CARGO_TRAILER:
                    vehicle=vehicleFactory.createCargoTrailer(id,
                            manufacturer,
                            year,
                            tariff,
                            ton,
                            pasCap,
                            Material.valueOf(scanner.next()),
                            scanner.nextBoolean()
                    );
                    break;
                case PASSENGER_TRAILER:
                    vehicle=vehicleFactory.createPassengerTrailer(id,
                            manufacturer,
                            year,
                            tariff,
                            ton,
                            pasCap,
                            Material.valueOf(scanner.next()),
                            scanner.nextBoolean(),
                            scanner.nextBoolean()
                    );
                    break;
                default: throw new NotSuchEnumerationException();
            }
        }
        catch (WrongArgumentException e)
        {
            LOG.error(e);
        }
        catch (NotSuchEnumerationException e)
        {
            LOG.error(e);
        }


        return vehicle;

    }

}
