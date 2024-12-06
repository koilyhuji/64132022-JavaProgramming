package bmi;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BmiCalculatorController {

 
    
    @FXML
    private TextField heightField;
    @FXML
    private TextField weightField;
    @FXML
    private CheckBox asianCheckBox;
    @FXML
    private Label bmiResultLabel;
    @FXML
    private Label categoryLabel;

    @FXML
    private void calculateBmi() {
        try {
        
            double height = Double.parseDouble(heightField.getText());
            double weight = Double.parseDouble(weightField.getText());

        
            height = height / 100;

            double bmi = weight / (height * height);
            bmiResultLabel.setText(String.format("BMI: %.2f", bmi));

            if (asianCheckBox.isSelected()) {
            
                if (bmi < 18.5) {
                    categoryLabel.setText("Nhận xét: Gầy");
                } else if (bmi >= 18.5 && bmi < 23) {
                    categoryLabel.setText("Nhận xét: Bình thường");
                } else if (bmi >= 23 && bmi < 27.5) {
                    categoryLabel.setText("Nhận xét: Thừa cân");
                } else {
                    categoryLabel.setText("Nhận xét: Béo phì");
                }
            } else {
                // BMI categories for non-Asians (WHO)
                if (bmi < 18.5) {
                    categoryLabel.setText("Nhận xét: Gầy");
                } else if (bmi >= 18.5 && bmi < 24.9) {
                    categoryLabel.setText("Nhận xét: Bình thường");
                } else if (bmi >= 25 && bmi < 29.9) {
                    categoryLabel.setText("Nhận xét: Thừa cân");
                } else {
                    categoryLabel.setText("Nhận xét: Béo phì");
                }
            }
        } catch (NumberFormatException e) {
            categoryLabel.setText("");
        }
    }
}