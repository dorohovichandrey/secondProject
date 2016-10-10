package by.bsu.dorohovich.ooptask.vehicle;

import by.bsu.dorohovich.ooptask.enm.Manufacturer;
import by.bsu.dorohovich.ooptask.exception.WrongArgumentException;
import by.bsu.dorohovich.ooptask.enm.Material;

/**
 * Created by User on 26.09.2016.
 */
public abstract class Trailer extends Vehicle implements Attachable {

    private Material material;

    public Trailer(long vehicleId,
                   Manufacturer manufacturer,
                   int year,
                   int tariffDollarByKm,
                   int tonnage,
                   int passengerCapacity,
                   Material material) throws WrongArgumentException {
        super(vehicleId, manufacturer, year, tariffDollarByKm, tonnage, passengerCapacity);
        setMaterial(material);
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return super.toString()+", material=" + material;
    }

    @Override
    public int getWeight() {
        return getPassengerCapacity()/Attachable.NUMBER_OF_PASSENGERS_EQUALS_TON+getTonnage();
    }
}
