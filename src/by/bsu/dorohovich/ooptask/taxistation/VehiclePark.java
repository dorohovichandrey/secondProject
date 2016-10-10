package by.bsu.dorohovich.ooptask.taxistation;

import by.bsu.dorohovich.ooptask.exception.IdException;
import by.bsu.dorohovich.ooptask.vehicle.Automobile;
import by.bsu.dorohovich.ooptask.vehicle.Trailer;
import by.bsu.dorohovich.ooptask.vehicle.Vehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by User on 09.10.2016.
 */
public class VehiclePark {
    private static final Logger LOG= LogManager.getLogger();
    List<Vehicle> vehicles=new ArrayList<Vehicle>();
    HashSet<Long> vehicleIdJournal=new HashSet<Long>();

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public HashSet<Long> getVehicleIdJournal() {
        return vehicleIdJournal;
    }

    public void setVehicleIdJournal(HashSet<Long> vehicleIdJournal) {
        this.vehicleIdJournal = vehicleIdJournal;
    }

    public List<Automobile> getAutomobiles()
    {
        List<? extends Vehicle> vehiclesCopy=new ArrayList<Vehicle>(vehicles);
        vehiclesCopy.removeIf(vehicle -> vehicle instanceof Trailer);
        return (List<Automobile>)vehiclesCopy;
    }

    public List<Trailer> getTrailers()
    {
        List<? extends Vehicle> vehiclesCopy=new ArrayList<Vehicle>(vehicles);
        vehiclesCopy.removeIf(vehicle -> vehicle instanceof Automobile);
        return (List<Trailer>)vehiclesCopy;
    }


    private void checkId(long id) throws IdException {
        if(vehicleIdJournal.contains(id))
        {
            throw new IdException("id="+id+" is already used");
        }
    }

    public void addVehicles(List<Vehicle> vehicles)
    {
        for(Vehicle veh : vehicles)
        {
            addVehicle(veh);
        }
    }

    public void addVehicle(Vehicle vehicle)
    {
        try
        {
            checkId(vehicle.getVehicleId());
            vehicleIdJournal.add(vehicle.getVehicleId());
            vehicles.add(vehicle);
        }
        catch (IdException e)
        {
            LOG.error(e);
            LOG.warn("Vehicle is not added  to taxistation");
        }
    }

}
