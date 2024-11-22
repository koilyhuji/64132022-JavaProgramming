package vn.architectual_3layer.Model_DTO;

public class NhanVien {
    int id;
    private String username;
    private String password;

    public NhanVien(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
