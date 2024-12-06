package javafx_tn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.Node;
public class QuizController {


    @FXML
    private VBox buttonVboxCH;
    @FXML
    private Button btnAnsA,btnAnsB,btnAnsC,btnAnsD;
    public void initialize() {
       
    }

    public void handleButtonQClick(ActionEvent event){

        for (Node node : buttonVboxCH.getChildren()) {
            if (node instanceof Button) {
                Button button = (Button) node;
                button.setStyle("-fx-background-color: #64B5F6; " +  
                                "-fx-text-fill: black; " +
                                "-fx-min-width: 150px; " +
                                "-fx-min-height: 30px; " +
                                "-fx-font-size: 14px; " +
                                "-fx-cursor: hand;");
            }
        }

        Button clickedButton = (Button) event.getSource();
        clickedButton.setStyle("-fx-background-color: #FF9800; -fx-text-fill: black; -fx-min-width: 150px; -fx-min-height: 30px; -fx-font-size: 14px; -fx-cursor: hand;");
    }

    public void handleButtonAnsClick(ActionEvent event){
        btnAnsA.setStyle("-fx-background-color: #1565C0;-fx-text-fill: white;-fx-min-width: 370px;-fx-min-height: 40px;-fx-font-size: 16px;-fx-cursor: hand;-fx-border-color: black;  -fx-border-width: 1px;");
        btnAnsB.setStyle(btnAnsA.getStyle().toString());
        btnAnsC.setStyle(btnAnsA.getStyle().toString());
        btnAnsD.setStyle(btnAnsA.getStyle().toString());
        Button clickedButton = (Button) event.getSource();
        clickedButton.setStyle("-fx-background-color: #4FC978;-fx-text-fill: white;-fx-min-width: 370px;-fx-min-height: 40px;-fx-font-size: 16px;-fx-cursor: hand;-fx-border-color: black;  -fx-border-width: 1px;");
    }
}