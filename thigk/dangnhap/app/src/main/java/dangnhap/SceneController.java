package dangnhap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class SceneController implements Initializable {

  @FXML
  private TextField tf_tenSanPham;

  @FXML
  private TextField tf_giaSanPham;

  @FXML
  private TextArea tf_mota;

  @FXML
  private TableView<sanpham> table;

  @FXML
  private TableColumn<sanpham, Integer> id;

  @FXML
  private TableColumn<sanpham, String> tenSanPham;

  @FXML
  private TableColumn<sanpham, BigDecimal> giaSanPham;

  @FXML
  private TableColumn<sanpham, String> mota;

  DbTemplate<sanpham> SanPhamDB = new DbTemplate<>("demobanhang");
  @FXML
  void onInsert(ActionEvent event) {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("add_product.fxml"));
    Parent root;
    try {
      root = loader.load();
    } catch (IOException e) {
      root = null;
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    Stage stage = new Stage();
    stage.setTitle("Thêm sản phẩm");
    stage.setScene(new Scene(root));
    stage.show();
    // Alert alert = new Alert(AlertType.INFORMATION);
    //     alert.setTitle("Notification");
    //     alert.setHeaderText(null);
    //     alert.setContentText("Đã thêm");

    //     alert.showAndWait();
  }

  ObservableList<sanpham> initialData(){
    List<sanpham> list = SanPhamDB.query(sanpham.class,"demobanhang");
    return FXCollections.observableArrayList(list);
  }

  @FXML
  void onQuery(ActionEvent event) {
    Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Notification");
        alert.setHeaderText(null);
        alert.setContentText("Đã cập nhật");

        alert.showAndWait();
  }


  @Override
  public void initialize(URL url, ResourceBundle resourceBundle) {
    id.setCellValueFactory(new PropertyValueFactory<sanpham, Integer>("id"));
    tenSanPham.setCellValueFactory(new PropertyValueFactory<sanpham, String>("tenSanPham"));
    giaSanPham.setCellValueFactory(new PropertyValueFactory<sanpham, BigDecimal>("giaSanPham"));
    mota.setCellValueFactory(new PropertyValueFactory<sanpham, String>("mota"));
    table.setItems(initialData());
  }
} 

