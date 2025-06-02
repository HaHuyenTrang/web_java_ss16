package ra.ss16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.ss16.model.Seat;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByBusId(Long busId);
}
