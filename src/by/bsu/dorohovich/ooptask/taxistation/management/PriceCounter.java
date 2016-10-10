package by.bsu.dorohovich.ooptask.taxistation.management;

import by.bsu.dorohovich.ooptask.enm.VehicleArgumentBound;
import by.bsu.dorohovich.ooptask.vehicle.Automobile;
import by.bsu.dorohovich.ooptask.vehicle.Vehicle;

import java.util.List;

/**
 * Created by User on 05.10.2016.
 */
public class PriceCounter {
    private static final int PRICE_FOR_SEAT = 100;
    private static final int PRICE_FOR_CARGO_TON = 120;
    private static final int PRICE_FOR_PRODUCTION_YEAR = 325;
    private static final int AUTOMOBILE_FORMULA_CONST = 2;
    private static final int TRAILER_FORMULA_CONST = 1;

    public int countVehiclePrice(Vehicle vehicle)
    {
        int yearDistance = VehicleArgumentBound.MAX_YEAR.getValue() - VehicleArgumentBound.MIN_YEAR.getValue();
        int yearCoef = yearDistance-(VehicleArgumentBound.MAX_YEAR.getValue() - vehicle.getYear());
        int price = yearCoef * PRICE_FOR_PRODUCTION_YEAR + vehicle.getPassengerCapacity() * PRICE_FOR_SEAT +
                + vehicle.getTonnage() * PRICE_FOR_CARGO_TON;
        price *= vehicle.getManufacturer().getPriceCoefficient();
        int coef = vehicle instanceof Automobile ? AUTOMOBILE_FORMULA_CONST : TRAILER_FORMULA_CONST;
        price *= coef;
        return price;
    }

    public int countVehiclesListPrice(List<Vehicle> vehicles)
    {
        int totalPrice=0;
        for (Vehicle vehicle : vehicles)
        {
            totalPrice+=countVehiclePrice(vehicle);
        }
        return totalPrice;
    }
}
