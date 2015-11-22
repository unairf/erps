package com.rodriguez.unai.ejerciciofinde;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Aircraft aircraft1 = new Aircraft("1111A",10000);
        Aircraft aircraft2 = new Aircraft("BBBB2", 20000);
        Pilot pilot1 = new Pilot("Unai",1);
        Pilot pilot2 = new Pilot("Hinata",2);
        pilot1.setAircraft(aircraft1);
        pilot2.setAircraft(aircraft2);
        AircraftDAO aircraftDAO = new AircraftDAO();
        aircraftDAO.insert(aircraft1);
        aircraftDAO.insert(aircraft2);
        aircraftDAO.selectAll();
        System.out.println("ToString: " + aircraftDAO.selectAll());
        List<Aircraft> aircrafts = new ArrayList<Aircraft>();
        for(Aircraft aircraft: aircrafts) {
        System.out.println(aircraft.toString());
        }
    }
}
