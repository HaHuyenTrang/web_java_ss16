package ra.ss16.repository;



import ra.ss16.connection.ConnectionDB;
import ra.ss16.model.Trip;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TripRepositoryImpl implements TripRepository {

    @Override
    public List<Trip> findAll() {
        List<Trip> trips = new ArrayList<>();
        Connection conn = ConnectionDB.openConnection();
        String sql = "SELECT * FROM trip";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                trips.add(mapTrip(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
        return trips;
    }

    @Override
    public List<Trip> search(String departure, String destination) {
        List<Trip> trips = new ArrayList<>();
        Connection conn = ConnectionDB.openConnection();
        String sql = "SELECT * FROM trip WHERE departure LIKE ? AND destination LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + departure + "%");
            ps.setString(2, "%" + destination + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                trips.add(mapTrip(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
        return trips;
    }

    @Override
    public List<Trip> searchWithPaging(String departure, String destination, int offset, int limit) {
        List<Trip> trips = new ArrayList<>();
        Connection conn = ConnectionDB.openConnection();
        String sql = "SELECT * FROM trip WHERE departure LIKE ? AND destination LIKE ? LIMIT ? OFFSET ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + departure + "%");
            ps.setString(2, "%" + destination + "%");
            ps.setInt(3, limit);
            ps.setInt(4, offset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                trips.add(mapTrip(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
        return trips;
    }

    @Override
    public int countSearch(String departure, String destination) {
        int count = 0;
        Connection conn = ConnectionDB.openConnection();
        String sql = "SELECT COUNT(*) FROM trip WHERE departure LIKE ? AND destination LIKE ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + departure + "%");
            ps.setString(2, "%" + destination + "%");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn);
        }
        return count;
    }

    private Trip mapTrip(ResultSet rs) throws SQLException {
        Trip trip = new Trip();
        trip.setId(rs.getLong("id"));
        trip.setDeparture(rs.getString("departure"));
        trip.setDestination(rs.getString("destination"));
        trip.setTime(rs.getString("time"));
        return trip;
    }
}

