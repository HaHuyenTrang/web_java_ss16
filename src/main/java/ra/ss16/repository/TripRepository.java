package ra.ss16.repository;

import ra.ss16.model.Trip;

import java.util.List;

public interface TripRepository {
    List<Trip> findAll();

    List<Trip> search(String departure, String destination);

    List<Trip> searchWithPaging(String departure, String destination, int offset, int limit);

    int countSearch(String departure, String destination);
}
