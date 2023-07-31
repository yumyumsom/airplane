package db;

import schedule.Flight;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightDAO {
    public int insertFlight(Flight flight) {
        int result = 0;

        Connection conn = DBConn.getConnection();
        PreparedStatement pstmt = null;

        try {
            String sql = "INSERT INTO flight (destination, departure_time, duration, arrival_time, remaining_seats, price) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, flight.getDestination());
            pstmt.setString(2, flight.getDepartureTime());
            pstmt.setString(3, flight.getDuration());
            pstmt.setString(4, flight.getArrivalTime());
            pstmt.setInt(5, flight.getRemainingSeats());
            pstmt.setInt(6, flight.getPrice());

            result = pstmt.executeUpdate();

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        Flight flight1 = new Flight("Tokyo", "08:00", "2시간", "10:00", 50, 100000);
        Flight flight2 = new Flight("London", "10:00", "10시간", "20:00", 10, 1000000);
        Flight flight3 = new Flight("Newyork", "04:00", "12시간", "16:00", 9, 2000000);

        // FlightDAO 객체 생성
        FlightDAO flightDAO = new FlightDAO();

        // flight 테이블에 데이터 삽입
        int result1 = flightDAO.insertFlight(flight1);
        int result2 = flightDAO.insertFlight(flight2);
        int result3 = flightDAO.insertFlight(flight3);

        if (result1 > 0 && result2 > 0 && result3 > 0) {
            System.out.println("항공편 정보가 성공적으로 저장되었습니다.");
        } else {
            System.out.println("항공편 정보 저장에 실패하였습니다.");
        }
    }

    public List<Flight> getAllFlights() {
        List<Flight> flights = new ArrayList<>();

        Connection conn = DBConn.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            String sql = "SELECT * FROM flight";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                String destination = rs.getString("destination");
                String departureTime = rs.getString("departure_time");
                String duration = rs.getString("duration");
                String arrivalTime = rs.getString("arrival_time");
                int remainingSeats = rs.getInt("remaining_seats");
                int price = rs.getInt("price");

                Flight flight = new Flight(destination, departureTime, duration, arrivalTime, remainingSeats, price);
                flights.add(flight);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flights;
    }

}