package es.uvigo.esei.aed1.activity9.airport;

import es.uvigo.esei.aed1.activity9.implementation.DynamicHashTable;
import es.uvigo.esei.aed1.tads.queue.LinkedQueue;
import es.uvigo.esei.aed1.tads.queue.Queue;

public class Runway {
    private int numRunway;
    private DynamicHashTable<String> destinationsPartners;
    private Queue<Flight> flightsOnStandby;

    public Runway(int numRunway) {
        this.numRunway = numRunway;
        this.destinationsPartners = new DynamicHashTable<>();
        this.flightsOnStandby = new LinkedQueue<>();
    }

    public void assignDestination(String destination) {
        destinationsPartners.add(destination);
    }

    public void assignFlight(Flight v) {
        flightsOnStandby.add(v);
    }

    public Flight removeFlight() {
        if (!flightsOnStandby.isEmpty()) {
            return flightsOnStandby.remove();
        }
        return null;
    }

    public int getNumRunway() {
        return this.numRunway;
    }

    public boolean isDestination(String destination) {
        return destinationsPartners.search(destination);
    }

    public int numberFlights() {
        return flightsOnStandby.size();
    }
}
