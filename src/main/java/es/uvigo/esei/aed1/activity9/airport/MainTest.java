package es.uvigo.esei.aed1.activity9.airport;

public class MainTest {

    public static void main(String[] args) {
        Airport Barajas = new Airport(2);

        Flight v1 = new Flight("Boing876", "Madrid", "Paris");
        Flight v2 = new Flight("Boing747", "Vigo", "Barcelona");
        Flight v3 = new Flight("Boing765", "Santiago", "Barcelona");
        Flight v4 = new Flight("Boing747", "Vigo", "Barcelona");
        Flight v5 = new Flight("Boing765", "Santiago", "Barcelona");
        Flight v6 = new Flight("Boing876", "Madrid", "Paris");

        Barajas.assignDestinationRunway(0, "Barcelona");
        //Barajas.assignDestinationRunway(1, "Barcelona");
        Barajas.assignDestinationRunway(0, "Paris");
        Barajas.assignDestinationRunway(1, "Paris");

        Barajas.assignFlightRunway(v1);
        Barajas.assignFlightRunway(v2);
        Barajas.assignFlightRunway(v3);
        Barajas.assignFlightRunway(v4);
        Barajas.assignFlightRunway(v5);
        Barajas.assignFlightRunway(v6);

        System.out.println("Flight departures alternating runways");

        int numFlights = Barajas.getNumAssignedFlights();
        while (numFlights > 0) {
            for (int i = 0; i < Barajas.getNumRunways(); i++) {
                Flight v = Barajas.takeoffFlight(i);
                if (v != null) {
                    System.out.println("Pista " + i + " : " + v);
                    numFlights--;
                }
            }
        }
    }
}
