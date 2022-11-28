package pr.lab3.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import pr.lab3.domain.Flight;
import pr.lab3.dto.CreateOrUpdateFlight;
import pr.lab3.dto.FlightResponse;
import pr.lab3.repository.FlightsRepository;

import java.util.LinkedList;
import java.util.List;

@Service
public class FlightsService {

    private static final Logger logger = LoggerFactory.getLogger(FlightsService.class);
    private final FlightsRepository repository;

    public FlightsService(FlightsRepository repository) {
        this.repository = repository;
    }

    public List<FlightResponse> getFlights() {
        List<Flight> flights = repository.getFlights();
        List<FlightResponse> mappedFlights = new LinkedList<>();
        for (Flight flight : flights) {
            mappedFlights.add(map(flight));
        }
        return mappedFlights;
    }

    public FlightResponse getFlight(int id) {
        Flight flight = repository.getFlight(id);
        if (flight == null) {
            logger.warn("Flight with id {} does not exist", id);
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
        }
        return map(flight);
    }

    public FlightResponse addFlight(CreateOrUpdateFlight createFlight) {
        Flight flight = new Flight(createFlight.getDestination());
        Flight createdFlight = repository.addFlight(flight);
        return map(createdFlight);
    }

    public FlightResponse updateFlight(int id, CreateOrUpdateFlight createOrUpdateFlight) {
        Flight flight = new Flight(id, createOrUpdateFlight.getDestination());
        Flight updatedFlight = repository.createOrUpdateFlight(flight);
        return map(updatedFlight);
    }

    public void removeFlight(int id) {
        repository.removeFlight(id);
    }

    private FlightResponse map(Flight flight) {
        return new FlightResponse(flight.getId(), flight.getDestination());
    }

}
