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
}