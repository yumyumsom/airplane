package login;

import db.UserLoginDAO;
import userinfo.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

// 사용자가 입력하는 정보
public class Join {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    UserLoginDAO dao = new UserLoginDAO();

    // 이름 형식 체크 함수
    public boolean checkName(String name) {
        // 이름은 한글과 공백만 허용
        return name.matches("^[ㄱ-ㅎㅏ-ㅣ가-힣\\s]+$");
    }

    // 이메일 형식 체크 함수
    public boolean checkEmail(String email) {
        // 이메일 형식 체크
        return email.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$");
    }

    // 전화번호 형식 체크 함수
    public boolean checkPhoneNumber(String phoneNumber) {
        // 번호는 숫자와 하이픈(-)만 허용
        return phoneNumber.matches("^[\\d-]+$");
    }

    public User insert() {
        boolean name = true;
        boolean id = true;
        boolean tel = true;
        boolean mail = true;

        try {
            User dto = new User();

            do {
                try {
                    System.out.print("이름 : ");
                    String nameInput = br.readLine();
                    if (checkName(nameInput)) {
                        dto.setName(nameInput);
                        name = false;
                    } else {
                        System.out.println("올바른 이름 형식이 아닙니다.");
                    }
                } catch (IOException e) {
                    System.out.println(e.toString());
                }

            } while (name);

            do {
                try {
                    System.out.print("ID: ");
                    String idInput = br.readLine();
                   /* if (!checkUserIdExists(idInput)) {
                        System.out.println("이미 사용 중인 아이디입니다.");
                    } else {*/
                    dto.setId(idInput);
                    id = false;

               /* } catch (IOException e) {
                    System.out.println(e.toString());
                 */
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            } while (id);

            do {
                try {
                    System.out.print("전화번호 : ");
                    String phoneInput = br.readLine();
                    if (checkPhoneNumber(phoneInput)) {
                        dto.setTel(phoneInput);
                        tel = false;
                    } else {
                        System.out.println("올바른 전화번호 형식이 아닙니다.");
                    }
                } catch (IOException e) {
                    System.out.println(e.toString());
                }

            } while (tel);

            do {
                try {
                    System.out.print("E-mail : ");
                    String emailInput = br.readLine();
                    if (checkEmail(emailInput)) {
                        dto.setEmail(emailInput);
                        mail = false;
                    } else {
                        System.out.println("올바른 이메일 형식이 아닙니다.");
                    }
                } catch (IOException e) {
                    System.out.println(e.toString());
                }

            } while (mail);

            int result = dao.insertData(dto);

            if (result != 0) {
                System.out.println();
                System.out.println(dto.getName() + "님 환영합니다.");
                System.out.println();

            } else {
                System.out.println("잘못된 정보가 존재합니다.");
            }
        } catch (Exception e) {
            System.out.println(e.toString());

        }

        return null;
    }

    /*

        // 아이디 존재 여부 확인 함수
        public boolean checkUserIdExists(String id) {
            return dao.checkUserIdExists(id);
        }

    */
    public List<User> select() {
        List<User> list = dao.getList();

        int i = 1;

        for (User dto : list) {
            System.out.println(i);
            System.out.println(dto.toString());
            i++;
        }
        return list;
    }
    //예매정보 출력
    /*public void selectAll() {

        List<User> list = dao.getList();

        int i = 1;

        for (User dto : list) {
            System.out.println("[회원 " + i + "]");
            System.out.println(dto.toString());
            i++;
        }
    }*/


}





