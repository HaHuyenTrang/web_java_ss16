package ra.ss16.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.ss16.model.Bus;

public interface BusRepository extends JpaRepository<Bus, Long> { }