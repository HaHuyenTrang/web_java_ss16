package ra.ss16.service;

import ra.ss16.model.Trip;
import ra.ss16.repository.TripRepository;
import ra.ss16.repository.TripRepositoryImpl;

import java.util.List;

public class TripServiceImpl implements TripService {
    private TripRepository tripRepository = new TripRepositoryImpl();

    @Override
    public List<Trip> getTrips(String departure, String destination, int page, int size) {
        int offset = (page - 1) * size;
        return tripRepository.searchWithPaging(departure, destination, offset, size);
    }

    @Override
    public int countPages(String departure, String destination, int size) {
        int total = tripRepository.countSearch(departure, destination);
        return (int) Math.ceil((double) total / size);
    }
}
