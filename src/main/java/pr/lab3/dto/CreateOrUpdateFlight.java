package pr.lab3.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateOrUpdateFlight {

    @JsonProperty
    private String destination;

    @JsonCreator
    public CreateOrUpdateFlight(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

}
