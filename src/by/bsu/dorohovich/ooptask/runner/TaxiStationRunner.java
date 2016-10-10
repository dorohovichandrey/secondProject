package by.bsu.dorohovich.ooptask.runner;

import by.bsu.dorohovich.ooptask.create.VehiclesFromFileCreator;
import by.bsu.dorohovich.ooptask.reporter.Reporter;
import by.bsu.dorohovich.ooptask.taxistation.TaxiStation;
import by.bsu.dorohovich.ooptask.taxistation.management.TaxiStationManagement;
import by.bsu.dorohovich.ooptask.vehicle.Vehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.List;

/**
 * Created by User on 04.10.2016.
 */
public class TaxiStationRunner {

    private static final String INPUT_FILE="input//vehicles.txt";
    private static final String OUTPUT_FILE="output//outp.txt";
    private static final long TAXI_STATION_ID=1L;

    public static void main(String[] args) {
        TaxiStation taxiStation=new TaxiStation(TAXI_STATION_ID);
        Reporter reporter = new Reporter(OUTPUT_FILE);
        TaxiStationManagement taxiStationManagement=new TaxiStationManagement();
        VehiclesFromFileCreator vehiclesCreator=new VehiclesFromFileCreator();


        List<Vehicle> vehicles=vehiclesCreator.createVehiclesList(new File(INPUT_FILE));
        taxiStation.addVehicles(vehicles);

        reporter.showVehicles(taxiStation.getAutomobiles(), "Automobiles");
        reporter.showVehicles(taxiStation.getTrailers(), "Trailers");
        reporter.show(taxiStationManagement.countVehiclesListPrice(taxiStation), "Vehicles price");
        reporter.showVehicles(taxiStationManagement.getSortedAutomobilesListByFuelConsumption(taxiStation), "Automobiles sorted by fuel consumption");
        int minTon=3;
        int maxTon=8;
        int minPasCap=4;
        int maxPasCap=8;
        reporter.showVehicles(
                taxiStationManagement.searchAutoByTonnageAndPassengerCapacity(taxiStation, minTon,maxTon, minPasCap, maxPasCap),
                "Search (automobile) by tonnage={"+minTon+","+maxTon+"} passengerCapacity={"+minPasCap+","+maxPasCap+"}"
        );
        reporter.showVehicles(
                taxiStationManagement.searchAutoPlusTrailerByTonnageAndPassengerCapacity(taxiStation, minTon,maxTon, minPasCap, maxPasCap),
                "Alternative search (automobile plus trailer) by tonnage={"+minTon+","+maxTon+"} passengerCapacity={"+minPasCap+","+maxPasCap+"}"
        );

    }
}
