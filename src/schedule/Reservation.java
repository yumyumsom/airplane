package schedule;

import db.UserLoginDAO;
import login.Join;
import userinfo.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private static List<Flight> flights;
    private Join join;
    private User currentUser;
    private String destination;


    private String departureTime;
    private int price;

    public Reservation() {
        this.join = new Join();
        this.flights = new ArrayList<>();
        flights.add(new Flight("Tokyo", "08:00", "2시간", "10:00", 50, 100000));
        flights.add(new Flight("London", "10:00", "10시간", "20:00", 10, 1000000));
        flights.add(new Flight("Newyork", "04:00", "12시간", "16:00", 9, 2000000));
    }

    public void showFlightTimetable() {
        System.out.println(this.toString());
    }

    public void reservation() throws IOException {

//        currentUser = join.select();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        showFlightTimetable();
//        UserLoginDAO dao = new UserLoginDAO();

        System.out.print("예매하실 항공편의 번호를 입력하세요: ");
        int selectedFlightNumber = Integer.parseInt(br.readLine());

        if (selectedFlightNumber >= 1 && selectedFlightNumber <= flights.size()) {
            Flight selectedFlight = flights.get(selectedFlightNumber - 1);
            int remainingSeats = selectedFlight.getRemainingSeats();
            // 예매 가능한 경우
            if (remainingSeats > 0) {

                destination = selectedFlight.getDestination();
                departureTime = selectedFlight.getDepartureTime();
                price = selectedFlight.getPrice();
                System.out.println();

                System.out.println("예매가 완료되었습니다.");


                System.out.println("항공편 예매 정보: ");
                System.out.println("선택한 항공편: " + destination);
                System.out.println("출발 시간: " + departureTime);
                System.out.println("가격: " + price + "원");


                System.out.println();
                // 잔여 좌석 수 감소
                selectedFlight.setRemainingSeats(remainingSeats - 1);
            } else {
                System.out.println("해당 항공편은 모든 좌석이 예매되었습니다.");
            }
        } else {
            System.out.println("유효하지 않은 항공편 번호입니다.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("항공편\n");
        sb.append("--------------------------------------------------------------------------------------------\n");
        sb.append(String.format("| %-2s | %-10s | %-10s | %-10s | %-10s | %-6s | %-7s |\n",
                "번호", "    목적지", "  출발시간", "  소요 시간", "  도착 시간", " 잔여 좌석", "  가격"));
        sb.append("--------------------------------------------------------------------------------------------\n");

        int flightNumber = 1;
        for (Flight flight : flights) {
            sb.append(String.format("| %-2d  | %-10s   | %-10s   | %-10s  | %-10s    |        %-3d| %-7d  |\n",
                    flightNumber, flight.getDestination(), flight.getDepartureTime(), flight.getDuration(),
                    flight.getArrivalTime(), flight.getRemainingSeats(), flight.getPrice()));

            flightNumber++;
        }

        sb.append("+------------------------------------------------------------------------------------------+\n");

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        Reservation reservation = new Reservation();
        reservation.reservation();

    }

}

