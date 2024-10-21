package sinhvienfx;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    
    @FXML
    TextField txtMaSV,txtName,txtDob;
    @FXML
    TextArea textArea;

    public void initialize() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        
    }
    public void Add(){
        String MaSV=txtMaSV.getText();
        String hoten=txtName.getText();
        String DoB=txtDob.getText();

        JSONObject jsonStudent =new JSONObject();
        jsonStudent.put("Mã SV",MaSV);
        jsonStudent.put("Họ tên SV",hoten);
        jsonStudent.put("Năm sinh",DoB);

        JSONArray jsonArrayStudent = new JSONArray();
        //

        jsonArrayStudent.put(jsonStudent);

        textArea.setText(jsonArrayStudent.toString()+"\n");
    }

    public void Reload(ActionEvent event){

    }

    public void Save(ActionEvent event){
        System.out.println("fucking save pressed");
    }
}