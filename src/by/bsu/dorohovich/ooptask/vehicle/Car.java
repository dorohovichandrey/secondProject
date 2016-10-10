package by.bsu.dorohovich.ooptask.vehicle;

import by.bsu.dorohovich.ooptask.exception.AttachDetachException;
import by.bsu.dorohovich.ooptask.exception.WrongArgumentException;
import by.bsu.dorohovich.ooptask.enm.FuelType;
import by.bsu.dorohovich.ooptask.enm.Manufacturer;

/**
 * Created by User on 26.09.2016.
 */
public class Car extends Automobile implements Attacher{

    private Attachable attachable;
    private boolean hasBabySeat;


    public Car(long vehicleId,
               Manufacturer manufacturer,
               int year,
               int tariffDollarByKm,
               int tonnage,
               int passengerCapacity,
               int fuelConsumption,
               FuelType fuelType,
               boolean hasBabySeat) throws WrongArgumentException {
        super(vehicleId, manufacturer, year, tariffDollarByKm, tonnage, passengerCapacity, fuelConsumption, fuelType);
        setHasBabySeat(hasBabySeat);
    }


    public boolean hasBabySeat() {
        return hasBabySeat;
    }


    public void setHasBabySeat(boolean hasBabySeat) {
        this.hasBabySeat = hasBabySeat;
    }

    public Attachable getAttachable() {
        return attachable;
    }

    @Override
    public void attach(Attachable attachable) throws AttachDetachException {
        if(this.attachable!=null)
        {
            throw new AttachDetachException("something has already attached ");
        }
        else if(Attacher.UPPER_BOUND_TONNAGE_FOR_CAR < attachable.getWeight())
        {
            throw new AttachDetachException("too heavy trailer for car");
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
    public String toString() {
        return "Car{" +super.toString()+
                ", attachable=" + attachable +
                ", hasBabySeat=" + hasBabySeat +
                '}';
    }
}
