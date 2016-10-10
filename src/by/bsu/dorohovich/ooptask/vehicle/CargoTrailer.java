package by.bsu.dorohovich.ooptask.vehicle;

import by.bsu.dorohovich.ooptask.enm.Manufacturer;
import by.bsu.dorohovich.ooptask.exception.WrongArgumentException;
import by.bsu.dorohovich.ooptask.enm.Material;

/**
 * Created by User on 26.09.2016.
 */
public class CargoTrailer extends Trailer {

    private boolean hasLifter;
    public CargoTrailer(long vehicleId,
                        Manufacturer manufacturer,
                        int year,
                        int tariffDollarByKm,
                        int tonnage,
                        int passengerCapacity,
                        Material material,
                        boolean hasLifter) throws WrongArgumentException {
        super(vehicleId, manufacturer, year, tariffDollarByKm, tonnage, passengerCapacity, material);
        setHasLifter(hasLifter);

    }

    public boolean hasLifter() {
        return hasLifter;
    }

    public void setHasLifter(boolean hasLifter) {
        this.hasLifter = hasLifter;
    }

    @Override
    public String toString() {
        return "CargoTrailer{"+super.toString() + ", hasLifter=" + hasLifter + '}';
    }
}
