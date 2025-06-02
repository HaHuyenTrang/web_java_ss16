package ra.ss16.service;

import ra.ss16.model.Trip;

import java.util.List;

public interface TripService {
    List<Trip> getTrips(String departure, String destination, int page, int size);
    int countPages(String departure, String destination, int size);
}
