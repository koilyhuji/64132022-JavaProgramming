package dangnhap;

import java.math.BigDecimal;

public class sanpham {

        private int id;
        private String tenSanPham;
        private BigDecimal giaSanPham;
        private String mota;
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getTenSanPham() {
            return tenSanPham;
        }
        public void setTenSanPham(String tenSanPham) {
            this.tenSanPham = tenSanPham;
        }
        public BigDecimal getGiaSanPham() {
            return giaSanPham;
        }
        public void setGiaSanPham(BigDecimal giaSanPham) {
            this.giaSanPham = giaSanPham;
        }
        public String getMoTa() {
            return mota;
        }
        public void setMoTa(String mota) {
            this.mota = mota;
        }
        public sanpham(int id, String tenSanPham, BigDecimal giaSanPham, String mota) {
            this.id = id;
            this.tenSanPham = tenSanPham;
            this.giaSanPham = giaSanPham;
            this.mota = mota;
        }

}