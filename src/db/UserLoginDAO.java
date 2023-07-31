package db;

import userinfo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UserLoginDAO {
    //예매자 정보값을 DB에 넣기 위한 클래스
    public int insertData(User user) {
        int result = 0;

        Connection conn = DBConn.getConnection();
        PreparedStatement pstmt = null;
        String sql;

        try {
            sql = "insert into USERLOGIN (name,id,tel,email) values(?,?,?,?)";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getId());
            pstmt.setString(3, user.getTel());
            pstmt.setString(4, user.getEmail());

            result = pstmt.executeUpdate();
            conn.close();

            pstmt.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return result;

    }

    //조회
    public List<User> getList() {
        List<User> list = new ArrayList<User>();
        Connection conn = DBConn.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql;

        try {
            sql = "select name, id, tel, email from USERLOGIN";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setName(rs.getString("name"));
                user.setId(rs.getString("id"));
                user.setTel(rs.getString("tel"));
                user.setEmail(rs.getString("email"));

                list.add(user);
            }
            rs.close();
            pstmt.close();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return list;
    }

/*    public boolean checkUserIdExists(String id) {
        UserLoginDAO dao = new UserLoginDAO();
        boolean exists = dao.checkUserIdExists(id);
        return exists;
    }*/
}


