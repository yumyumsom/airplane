package userinfo;

public class User {
    private String name;
    private String id;
    private String tel;
    private String email;

    public User(String name, String id, String tel, String email) {
        setName(name);
        setId(id);
        setTel(tel);
        setEmail(email);
    }

    public User() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || !(o instanceof User)) {
            return false;
        }
        User temp = (User)o;

        return id.equals(temp.getId());
    }



    @Override
    public String toString() {
        String type = "이름 : " + name + "\n";
                /*+ "ID : " + id + "\n"
                + "휴대 전화 : " + tel + "\n"
                + "이메일 : " + email;*/
        return type;
    }

}
