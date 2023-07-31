/*
package schedule;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Sample {


    private String flightNumber;
    private String origin;


    private String destination;
    private String departureTime;


    private String arrivalTime;


// Constructor, getters, setters, and other methods can be added as needed.


    @Override


    public String toString() {


        return "Flight Number: " + flightNumber +
                ", Origin: " + origin +
                ", Destination: " + destination +
                ", Departure Time: " + departureTime +
                ", Arrival Time: " + arrivalTime;
    }


}


// ... Other methods
}

public class FlightReservation {


    private List<Flight> flightList;


    public FlightReservation() {
        flightList =
                flightList =

                        flightList

        flight


        new ArrayList<>();


Populate flightList with sample flights
        flightList.add(
                flightList.add

        new Flight("ABC123", "New York", "Los Angeles", "08:00", "10:30"));
        flightList.add(
                flightList.add


        new Flight("XYZ456", "Chicago", "Miami", "12:45", "15:15"));


// Add more flights as needed
    }


}



    }

// Display available flights


public void showAvailableFlights(){
        System.out.println(
        System


        "=== Available Flights ===");


        for(Flight flight:flightList){
        System.out.println(flight.toString());
        }
        }


        System.out.println(flight.toString());
        }
        }


        System.out.println(flight.toString());
        }
        }


        System.out.println(flight.toString());
        }


// Insert flights into the local MySQL database


public void insertFlightsIntoDatabase(){
        String url="jdbc:mysql://localhost:3306/flight_db"; // Change to match your local MySQL setup


        String username="your_username"; // Change to your local MySQL username

        String password


        String password="your_password"; // Change to your local MySQL password


        try(Connection connection=DriverManager.getConnection(url,username,password)){


        String insertQuery="INSERT INTO flights (flight_number, origin, destination, departure_time, arrival_time) "+


        "VALUES (?, ?, ?, ?, ?)";


        PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);


        for(Flight flight:flightList){
        preparedStatement.setString(
        preparedStatement.setString(


        1,flight.getFlightNumber());
        preparedStatement.setString(
        preparedStatement.setString(
        2,flight.getOrigin());
        preparedStatement.setString(

        3,flight.getDestination());
        preparedStatement.setString(
        preparedStatement.setString

        preparedStatement


        4,flight.getDepartureTime());
        preparedStatement.setString(

        5,flight.getArrivalTime());
        preparedStatement.executeUpdate();
        }

        System.out.println(
        preparedStatement.executeUpdate();
        }

        System

        preparedStatement.executeUpdate();
        }


        preparedStatement.executeUpdate();
        }


        preparedStatement.executeUpdate();
        "Flights inserted into the database successfully!");
        }

        catch(SQLException e){
        System.out.println(
        System.out.println


        "Error inserting flights into the database: "+e);
        }
        }


        }
        }


        }
        }


        }


        }
public static void main(String[]args){

        FlightReservation reservation


        FlightReservation reservation=new FlightReservation();
        reservation.showAvailableFlights();
        reservation.insertFlightsIntoDatabase();
        }
        }

        reservation.showAvailableFlights();
        reservation.insertFlightsIntoDatabase();
        }
        }
        ``

        reservation.showAvailableFlights();
        reservation.insertFlightsIntoDatabase();


        reservation.showAvailableFlights();


        reservation.showAvailableFlights();

        reservation.show
        }
*/
