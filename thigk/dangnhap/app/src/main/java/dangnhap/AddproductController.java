package dangnhap;

import java.math.BigDecimal;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddproductController {
    @FXML
    private Button cancelbtn,addbtn;
    @FXML
    private TextField tensp,dongia,mota;
    @FXML
    DbTemplate<sanpham> SanPhamDB = new DbTemplate<>("demobanhang");
    private void onCancel() {
        // Close the window
        ((Stage) cancelbtn.getScene().getWindow()).close();
    }
    @FXML
    private void onInsert(){
        List<sanpham> list = SanPhamDB.query(sanpham.class,"demosanpham");
        String name = tensp.getText();
        int id = list.size();
        BigDecimal gia = BigDecimal.valueOf(Double.parseDouble(dongia.getText()));
        String motah = mota.getText();
        SanPhamDB.save(new sanpham(id, name, gia, motah));

        
    }
}
