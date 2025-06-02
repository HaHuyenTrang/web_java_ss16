package ra.ss16.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Biển số xe không được để trống")
    private String licensePlate;

    @Enumerated(EnumType.STRING)
    private BusType busType;

    @Min(1)
    private int rowSeat;

    @Min(1)
    private int colSeat;

    private int totalSeat;

    private String image;

    // Getters and setters
}

