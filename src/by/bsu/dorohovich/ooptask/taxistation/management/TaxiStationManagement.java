package by.bsu.dorohovich.ooptask.taxistation.management;

import by.bsu.dorohovich.ooptask.taxistation.TaxiStation;
import by.bsu.dorohovich.ooptask.vehicle.Automobile;
import by.bsu.dorohovich.ooptask.vehicle.Vehicle;

import java.util.List;

/**
 * Created by User on 09.10.2016.
 */
public class TaxiStationManagement {
    PriceCounter priceCounter=new PriceCounter();
    Sorter sorter=new Sorter();
    Searcher searcher=new Searcher();


    public int countVehiclesListPrice(TaxiStation taxiStation) {
        List<Vehicle> vehicles=taxiStation.getVehicles();
        return priceCounter.countVehiclesListPrice(vehicles);
    }

    public List<Automobile> getSortedAutomobilesListByFuelConsumption(TaxiStation taxiStation) {
        List<Automobile> automobiles=taxiStation.getAutomobiles();
        return sorter.getSortedAutomobilesListByFuelConsumption(automobiles);
    }

    public List<Automobile> searchAutoByTonnageAndPassengerCapacity(TaxiStation taxiStation, int minTonnage, int maxTonnage, int minPasCap, int maxPasCap) {
        return searcher.searchAutoByTonnageAndPassengerCapacity(taxiStation, minTonnage, maxTonnage, minPasCap, maxPasCap);
    }

    public List<Automobile> searchAutoPlusTrailerByTonnageAndPassengerCapacity(TaxiStation taxiStation, int minTonnage, int maxTonnage, int minPasCap, int maxPasCap) {
        return searcher.searchAutoPlusTrailerByTonnageAndPassengerCapacity(taxiStation, minTonnage, maxTonnage, minPasCap, maxPasCap);
    }
}
