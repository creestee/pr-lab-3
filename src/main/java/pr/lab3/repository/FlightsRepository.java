package pr.lab3.repository;

import org.springframework.stereotype.Repository;
import pr.lab3.domain.Flight;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Repository
public class FlightsRepository {

    private int currentId = 1;
    private final Map<Integer, Flight> flights = new HashMap<>();

    public List<Flight> getFlights() {
        return new LinkedList<>(flights.values());
    }

    public Flight getFlight(int id) {
        return flights.get(id);
    }

    public Flight addFlight(Flight flight) {
        int newId = getNewId();
        Flight newFlight = new Flight(newId, flight.getDestination());
        flights.put(newId, newFlight);
        return newFlight;
    }

    public Flight createOrUpdateFlight(Flight flight) {
        flights.put(flight.getId(), flight);
        return flight;
    }

    public void removeFlight(int id) {
        flights.remove(id);
    }

    private synchronized int getNewId() {
        int newId = currentId++;
        while (flights.containsKey(newId)) {
            newId = currentId++;
        }
        return newId;
    }

}
