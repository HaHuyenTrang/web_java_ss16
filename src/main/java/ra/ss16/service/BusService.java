package ra.ss16.service;

import ra.ss16.model.Bus;

import java.util.List;

public interface BusService {
    List<Bus> findAll();
    Bus findById(Long id);
    Bus save(Bus bus);
    void delete(Long id);
}
