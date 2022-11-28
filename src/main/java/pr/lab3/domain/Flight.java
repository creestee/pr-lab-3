package pr.lab3.domain;

import lombok.*;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Flight {

    private Integer id;
    private String destination;

    public Flight(String destination) {
        this.destination = destination;
    }

}
