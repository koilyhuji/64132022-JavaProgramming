package vn.architectual_3layer.BLL;

import vn.architectual_3layer.DAL.NhanVienDAL;
import vn.architectual_3layer.Model_DTO.NhanVien;

public class NhanVienBLL {
  NhanVienDAL nhanVienDAL;
  public boolean ThemMoi(NhanVien nv){

    boolean kq = nhanVienDAL.AddNew(nv);
    return kq;
  }
  boolean checkLogin(String tenDN, String matKhau){
    
    return nhanVienDAL.Login(tenDN, matKhau);
  }
}
