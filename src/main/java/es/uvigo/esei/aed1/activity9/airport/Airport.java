package es.uvigo.esei.aed1.activity9.airport;

public class Airport {

    private Runway[] runways;

    public Airport(int numRunways) {
        if (numRunways <= 0) {
            throw new IllegalArgumentException("The number of runways must be positive.");
        }

        this.runways = new Runway[numRunways];
        for (int i = 0; i < numRunways; i++) {
            runways[i] = new Runway(i);
        }
    }

    public void assignDestinationRunway(int numRunway, String destination) {
        if (numRunway < 0 || numRunway >= runways.length) {
            throw new IllegalArgumentException("Invalid runway number. No such runway exists.");
        }

        runways[numRunway].assignDestination(destination);
    }

    public void assignFlightRunway(Flight v) {
        if (v == null) {
            throw new IllegalArgumentException("Flight cannot be null.");
        }

        Runway lessBusyRunway = null;

        for (Runway runway : runways) {
            if (runway.isDestination(v.getDestination())) {
                if (lessBusyRunway == null) {
                    lessBusyRunway = runway;
                }

                if (runway.numberFlights() < lessBusyRunway.numberFlights()) {
                    lessBusyRunway = runway;
                }
            }
        }

        if (lessBusyRunway != null) {
            lessBusyRunway.assignFlight(v);
        } else {
            throw new IllegalStateException("No available runway for the flight's destination.");
        }
    }

    public Flight takeoffFlight(int numRunway) {
        return runways[numRunway].removeFlight();
    }

    public int getNumRunways() {
        return runways.length;
    }

    public int getNumAssignedFlights() {
        int totalFlights = 0;

        for (Runway runway : runways) {
            totalFlights += runway.numberFlights();
        }

        return totalFlights;
    }
}
