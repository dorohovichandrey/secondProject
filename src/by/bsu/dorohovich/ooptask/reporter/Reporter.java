package by.bsu.dorohovich.ooptask.reporter;

import by.bsu.dorohovich.ooptask.vehicle.Vehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by User on 04.10.2016.
 */
public class Reporter {
    private static final Logger LOG= LogManager.getLogger();
    PrintStream printStream;
    private static final String DELIMITER="----------------------";

    public Reporter(String fileName){
        try
        {
            printStream = new PrintStream(fileName);
        }
        catch (FileNotFoundException e)
        {
            LOG.fatal(e);
            throw new RuntimeException("fileName="+fileName, e);
        }

    }

    public void showVehicles(List<? extends Vehicle> vehicles, String header)
    {
        makeHead(header);
        for(Vehicle veh : vehicles)
        {
            printStream.println(veh);
        }
    }


    public void show(Object object, String header)
    {
        makeHead(header);
        printStream.println(object);
    }
    
    private void makeHead(String header)
    {
        printStream.println(DELIMITER+header+DELIMITER);
    }

}
