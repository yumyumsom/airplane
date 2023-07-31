package login;

import db.DBConn;
import schedule.Reservation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LoginMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Join join = new Join();
        Reservation reservation = new Reservation();
        int ch;

        while (true) {
            do {

                System.out.print("1.가입  2.항공편 조회  3.예매하기  4.종료");

                System.out.print("\n-------------------------------------\n▶");

                ch = Integer.parseInt(br.readLine());

            } while (ch < 1 || ch > 5);

            System.out.println();


            switch (ch) {


                case 1:

                    join.insert();

                    System.out.println();
                    break;

                case 2:

                    reservation.showFlightTimetable();
                    System.out.println();
                    break;

                case 3:


                    reservation.reservation();

                    System.out.println();
                    break;

                case 4:
                    DBConn.close();

                    System.exit(0);


            }


        }

    }

}


