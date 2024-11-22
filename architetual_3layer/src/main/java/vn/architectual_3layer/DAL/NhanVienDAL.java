package vn.architectual_3layer.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.architectual_3layer.Model_DTO.NhanVien;
import vn.architectual_3layer.Utils.DBConnection;

public class NhanVienDAL {
  public boolean AddNew(NhanVien nv){

        if(validateUser(nv)){
          return false;
        }
        String unhashedPass = nv.getPassword();
        String hashedPass = encodePassMD5(unhashedPass);
        try (Connection conn = DBConnection.getConnection()) {
          String sql = "INSERT INTO users VALUES username = ? AND password = ?";
          try (PreparedStatement ps = conn.prepareStatement(sql)) {
              ps.setString(1, nv.getUsername());
              ps.setString(2, hashedPass);

              ResultSet rs = ps.executeQuery();
              return rs.next();
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
        return true;
  }

  public boolean Delete(int id){
    return true;
  }

  public boolean validateUser(NhanVien nv) {

        String unhashedPass = nv.getPassword();
        String hashedPass = encodePassMD5(unhashedPass);
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, nv.getUsername());
                ps.setString(2, hashedPass);

                ResultSet rs = ps.executeQuery();
                return rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
  }
  public String encodePassMD5(String password){
    return password;
  }
}
