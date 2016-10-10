package by.bsu.dorohovich.ooptask.taxistation;

import by.bsu.dorohovich.ooptask.vehicle.Automobile;
import by.bsu.dorohovich.ooptask.vehicle.Trailer;
import by.bsu.dorohovich.ooptask.vehicle.Vehicle;

import java.util.List;

/**
 * Created by User on 27.09.2016.
 */
public class TaxiStation {

    Long taxiStationId;
    VehiclePark vehiclePark=new VehiclePark();


    public TaxiStation(Long taxiStationId) {
        this.taxiStationId = taxiStationId;
    }

    public VehiclePark getVehiclePark() {
        return vehiclePark;
    }

    public void setVehiclePark(VehiclePark vehiclePark) {
        this.vehiclePark = vehiclePark;
    }

    public List<Vehicle> getVehicles() {
        return vehiclePark.getVehicles();
    }

    public List<Automobile> getAutomobiles() {
        return vehiclePark.getAutomobiles();
    }

    public List<Trailer> getTrailers() {
        return vehiclePark.getTrailers();
    }

    public void addVehicles(List<Vehicle> vehicles) {
        vehiclePark.addVehicles(vehicles);
    }

    public void addVehicle(Vehicle vehicle) {
        vehiclePark.addVehicle(vehicle);
    }
}
