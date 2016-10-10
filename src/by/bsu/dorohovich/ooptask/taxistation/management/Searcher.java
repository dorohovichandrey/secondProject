package by.bsu.dorohovich.ooptask.taxistation.management;

import by.bsu.dorohovich.ooptask.exception.AttachDetachException;
import by.bsu.dorohovich.ooptask.vehicle.Attacher;
import by.bsu.dorohovich.ooptask.taxistation.TaxiStation;
import by.bsu.dorohovich.ooptask.vehicle.Automobile;
import by.bsu.dorohovich.ooptask.vehicle.Trailer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by User on 09.10.2016.
 */
public class Searcher {

    private static final Logger LOG= LogManager.getLogger();

    public List<Automobile> searchAutoByTonnageAndPassengerCapacity(TaxiStation taxiStation, int minTonnage, int maxTonnage, int minPasCap, int maxPasCap)
    {
        List<Automobile> automobiles=new ArrayList<Automobile>(taxiStation.getAutomobiles());
        Stream<Automobile> stream=automobiles.stream().filter(a -> a.getTonnage()>=minTonnage && a.getTonnage()<=maxTonnage && a.getPassengerCapacity()>=minPasCap && a.getTonnage()<=maxPasCap);
        automobiles=stream.collect(Collectors.toList());
        return automobiles;
    }

    public List<Automobile> searchAutoPlusTrailerByTonnageAndPassengerCapacity(TaxiStation taxiStation, int minTonnage, int maxTonnage, int minPasCap, int maxPasCap) {
        List<Automobile> automobiles = new ArrayList<Automobile>(taxiStation.getAutomobiles());
        List<Trailer> trailers = new ArrayList<Trailer>(taxiStation.getTrailers());
        automobiles.removeIf((a) -> !(a instanceof Attacher));

        List<Automobile> result = new ArrayList<Automobile>();

        for (Automobile auto : automobiles) {
            Stream<Trailer> trailerStream = trailers.stream().filter(t -> auto.getTonnage() + t.getTonnage() >= minTonnage &&
                    auto.getTonnage() + t.getTonnage() <= maxTonnage &&
                    auto.getPassengerCapacity() + t.getPassengerCapacity() >= minPasCap &&
                    auto.getPassengerCapacity() + t.getPassengerCapacity() <= maxPasCap);

            Iterator<Trailer> iter = trailerStream.iterator();
            if (iter.hasNext()) {
                try {

                    ((Attacher) auto).attach(iter.next());
                    result.add(auto);

                } catch (AttachDetachException e) {
                    LOG.error(e);
                }
            }


        }
        return result;
    }



}
