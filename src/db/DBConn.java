package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConn {
    public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String id = "본인ID";
        String pw = "본인PWD";
        try {
            conn = DriverManager.getConnection(url, id, pw);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB연결 실패"+e.getMessage());
        }
        return conn;
    }
    

    public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
        try {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
            if (rs != null) rs.close();
            System.out.println("DB종료");
        } catch (Exception e) {
            System.out.println("DB종료가 실패하였습니다."+e.getMessage());
        }
    }

    public static void main(String[] args) {
        getConnection();
    }

    public static void close() {
        System.out.println("시스템 종료");
    }

}