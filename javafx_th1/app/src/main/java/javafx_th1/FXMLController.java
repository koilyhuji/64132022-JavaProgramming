package javafx_th1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FXMLController {

    @FXML
    private TextField inputA;

    @FXML
    private TextField inputB;

    @FXML
    private RadioButton addButton;

    @FXML
    private RadioButton subtractButton;

    @FXML
    private RadioButton multiplyButton;

    @FXML
    private RadioButton divideButton;

    @FXML
    private TextField resultField;


    public void initialize() {
       ToggleGroup group = new ToggleGroup();
        addButton.setToggleGroup(group);
        subtractButton.setToggleGroup(group);
        multiplyButton.setToggleGroup(group);
        divideButton.setToggleGroup(group);
        
    }
     @FXML
    private void handleCalculate(ActionEvent event) {
        
        try {
            double a = Double.parseDouble(inputA.getText());
            double b = Double.parseDouble(inputB.getText());

            String operation = "";
            if (addButton.isSelected()) {
                operation = "+";
            } else if (subtractButton.isSelected()) {
                operation = "-";
            } else if (multiplyButton.isSelected()) {
                operation = "*";
            } else if (divideButton.isSelected()) {
                operation = "/";
            }

            double result = 0;
            switch (operation) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b != 0) {
                        result = a / b;
                    } else {

                        return;
                    }
                    break;
                default:

                    return;
            }

          
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
    }
}