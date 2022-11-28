package pr.lab3.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pr.lab3.dto.CreateOrUpdateFlight;
import pr.lab3.dto.FlightResponse;
import pr.lab3.service.FlightsService;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightsController {

    private final FlightsService service;

    public FlightsController(FlightsService service) {
        this.service = service;
    }

    @GetMapping
    public List<FlightResponse> getFlights() {
        return service.getFlights();
    }

    @GetMapping("/{id}")
    public FlightResponse getFlight(@PathVariable int id) {
        return service.getFlight(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FlightResponse addFlight(@RequestBody CreateOrUpdateFlight flight) {
        return service.addFlight(flight);
    }

    @PutMapping("/{id}")
    public FlightResponse updateFlight(@PathVariable int id, @RequestBody CreateOrUpdateFlight flight) {
        return service.updateFlight(id, flight);
    }

    @DeleteMapping("/{id}")
    public void removeFlight(@PathVariable int id) {
        service.removeFlight(id);
    }

}
