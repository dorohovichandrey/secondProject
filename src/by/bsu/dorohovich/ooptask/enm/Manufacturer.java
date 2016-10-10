package by.bsu.dorohovich.ooptask.enm;

/**
 * Created by User on 26.09.2016.
 */
public enum Manufacturer {
    AUDI(3), BMW(3), MERCEDES(3), OPEL(2), VOLKSWAGEN(2), RENO(1), KIA(1), CITROEN(1), TESLA(4), TOYOTA(2);

    int priceCoefficient;


    Manufacturer(int priceCoefficient) {
        this.priceCoefficient=priceCoefficient;
    }

    public int getPriceCoefficient() {
        return priceCoefficient;
    }
}
