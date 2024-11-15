package dangnhap;

import java.io.IOException;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private Label label;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void handleLogin(ActionEvent event){
        if(kiemtrataikhoan()){
            switchscene(event);
        }
        else{
            Alert al =new Alert(AlertType.WARNING);
            al.setTitle("loi dang nhap");
            al.setHeaderText("loi dang nhap");
            al.setContentText("mat khau hoac tai khoan sai");
            al.showAndWait();
        }
    }
    private boolean kiemtrataikhoan(){
        DbTemplate<users> db = new DbTemplate<>("dangnhap");
        List<users> users = db.query(users.class, "dangnhap");
      
        for( var u : users){
            if( u.getUsername().equals(username.getText().toString()) && 
                u.getPassword().equals(password.getText().toString())){
                    return true;
            }
        }
        return false;
    }
    private void switchscene(ActionEvent event){
        Stage stage;
        Scene scene;
        Parent root;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("scene_list.fxml"));
        try {
            root = fxmlLoader.load();
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Danh Sách Sản Phẩm");
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    
    }
}
