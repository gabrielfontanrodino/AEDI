
package es.uvigo.esei.aed1.activity9.airport;

import java.util.Calendar;


public class Flight {
    private final String aircraft;
    private final String origin;
    private final String destination;
    private final Calendar departureTime;
    
    public Flight(String aircraft, String origin, String destination){
        this.aircraft=aircraft;
        this.origin=origin;
        this.destination=destination;
        this.departureTime=Calendar.getInstance();
    }
    
    public String getDestination(){
        return destination;
    }
    
    @Override
    public String toString(){
        return "Flight "+aircraft+" ----- "+origin+" - "+destination + " - " + departureTime.getTime().toString();
    }     
}
