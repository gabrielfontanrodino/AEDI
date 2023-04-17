
package es.uvigo.esei.aed1.activity9.airport;

import es.uvigo.esei.aed1.activity9.implementation.DinamicHashTable;
import es.uvigo.esei.aed1.tads.queue.LinkedQueue;
import es.uvigo.esei.aed1.tads.queue.Queue;

public class Runway {
    private int numRunway;
    private DinamicHashTable<String> destinationsPartners;
    private Queue<Flight> flightsOnStandby;
    
    public Runway(int numRunway){
  
    }
    
    public void assignDestination(String destination){

        
    }
    
    public void assignFlight(Flight v){

    }
    
    public Flight removeFlight(){
        
        return null;
    }
    
    public int getNumRunway(){
        return 0;
    }
    
    public boolean isDestination(String destination){
        return false;
    }
    
    public int numberFlight(){
        return 0;
    }      
}
