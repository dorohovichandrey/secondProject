package by.bsu.dorohovich.ooptask.vehicle;

import by.bsu.dorohovich.ooptask.exception.AttachDetachException;
import by.bsu.dorohovich.ooptask.vehicle.Attachable;

/**
 * Created by User on 26.09.2016.
 */
public interface Attacher {
    int UPPER_BOUND_TONNAGE_FOR_CAR=3;

    void attach(Attachable attachable) throws AttachDetachException;

    void detach() throws AttachDetachException;

    Attachable getAttachable();
}
