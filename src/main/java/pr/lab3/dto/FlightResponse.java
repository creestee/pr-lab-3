package pr.lab3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class FlightResponse {

    private int id;
    private String destination;

}
