package by.bsu.dorohovich.ooptask.vehicle;

import by.bsu.dorohovich.ooptask.enm.Manufacturer;
import by.bsu.dorohovich.ooptask.exception.WrongArgumentException;
import by.bsu.dorohovich.ooptask.enm.Material;

/**
 * Created by User on 26.09.2016.
 */
public class PassengerTrailer extends Trailer {

    private boolean hasKitchen;
    private boolean hasShower;
    public PassengerTrailer(long vehicleId,
                            Manufacturer manufacturer,
                            int year,
                            int tariffDollarByKm,
                            int tonnage,
                            int passengerCapacity,
                            Material material,
                            boolean hasKitchen,
                            boolean hasShower) throws WrongArgumentException {
        super(vehicleId, manufacturer, year, tariffDollarByKm, tonnage, passengerCapacity,  material);
        setHasKitchen(hasKitchen);
        setHasShower(hasShower);
    }

    public boolean hasKitchen() {
        return hasKitchen;
    }

    public void setHasKitchen(boolean hasKitchen) {
        this.hasKitchen = hasKitchen;
    }

    public boolean hasShower() {
        return hasShower;
    }

    public void setHasShower(boolean hasShower) {
        this.hasShower = hasShower;
    }

    @Override
    public String toString() {
        return "PassengerTrailer{"+super.toString() +
                ", hasKitchen=" + hasKitchen +
                ", hasShower=" + hasShower +
                '}';
    }
}
