package by.bsu.dorohovich.ooptask.vehicle;

import by.bsu.dorohovich.ooptask.enm.Manufacturer;
import by.bsu.dorohovich.ooptask.exception.AttachDetachException;
import by.bsu.dorohovich.ooptask.exception.WrongArgumentException;
import by.bsu.dorohovich.ooptask.enm.FuelType;

/**
 * Created by User on 26.09.2016.
 */
public class Truck extends Automobile implements Attacher {

    private Attachable attachable;
    private boolean hasSleepingPlace;

    public Truck(long vehicleId,
                 Manufacturer manufacturer,
                 int year,
                 int tariffDollarByKm,
                 int fuelConsumption,
                 FuelType fuelType,
                 int tonnage,
                 int passengerCapacity,
                 boolean hasSleepingPlace) throws WrongArgumentException {
        super(vehicleId, manufacturer, year, tariffDollarByKm, tonnage, passengerCapacity, fuelConsumption, fuelType);
        this.hasSleepingPlace = hasSleepingPlace;
    }

    @Override
    public void attach(Attachable attachable) throws AttachDetachException {
        if(this.attachable!=null)
        {
            throw new AttachDetachException("something has already attached ");
        }
        this.attachable=attachable;
    }

    @Override
    public void detach() throws AttachDetachException {
        if(attachable==null)
        {
            throw new AttachDetachException("nothing to detach");
        }
        attachable=null;
    }

    @Override
    public Attachable getAttachable() {
        return attachable;
    }

    public void setAttachable(Attachable attachable) {
        this.attachable = attachable;
    }

    public boolean isHasSleepingPlace() {
        return hasSleepingPlace;
    }

    public void setHasSleepingPlace(boolean hasSleepingPlace) {
        this.hasSleepingPlace = hasSleepingPlace;
    }

    @Override
    public String toString() {
        return "Truck{" + super.toString()+
                " attachable=" + attachable +
                ", hasSleepingPlace=" + hasSleepingPlace +
                '}';
    }
}
