package by.bsu.dorohovich.ooptask.taxistation.management;

import by.bsu.dorohovich.ooptask.vehicle.Automobile;

import java.util.List;

/**
 * Created by User on 09.10.2016.
 */
public class Sorter {
    public List<Automobile> getSortedAutomobilesListByFuelConsumption(List<Automobile> automobiles)
    {
        automobiles.sort((a,b)->Integer.valueOf(a.getFuelConsumption()).compareTo(b.getFuelConsumption()));
        return automobiles;
    }
}
