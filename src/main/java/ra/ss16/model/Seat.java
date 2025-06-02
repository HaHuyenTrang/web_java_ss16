package ra.ss16.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameSeat;
    private double price;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;

    // Getters and setters
}
