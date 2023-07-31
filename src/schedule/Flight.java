package schedule;

public class Flight {
    private String destination;
    private String departureTime;
    private String duration;
    private String arrivalTime;
    private int remainingSeats;
    private int price;

    // 생성자
    public Flight(String destination, String departureTime, String duration, String arrivalTime, int remainingSeats, int price) {
        this.destination = destination;
        this.departureTime = departureTime;
        this.duration = duration;
        this.arrivalTime = arrivalTime;
        this.remainingSeats = remainingSeats;
        this.price = price;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getDuration() {
        return duration;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }

    public int getPrice() {
        return price;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    // 항공편 정보를 출력하는 메서드
    public void showFlightInfo() {
        System.out.println("도착지: " + destination);
        System.out.println("출발 시간: " + departureTime);
        System.out.println("이동 시간: " + duration);
        System.out.println("도착 시간: " + arrivalTime);
        System.out.println("잔여 좌석: " + remainingSeats);
        System.out.println("가격: " + price);
    }
}
