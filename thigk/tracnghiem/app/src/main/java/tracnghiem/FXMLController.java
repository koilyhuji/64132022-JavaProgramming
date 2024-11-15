package tracnghiem;

import java.text.DecimalFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

public class FXMLController {

    
    @FXML
    private Button button1,button2,button3,button4, generateButton;
   
    @FXML
    private TextField firstNumberField,secondNumberField,operatorField;
    int valuea, valueb;
    int pheptoan;
    float generatedkq = 0;
    boolean isStarted = false;
    int score = 0;
    final int ANS_COUNT_DOWN = 5;
    int countdown = ANS_COUNT_DOWN;
    @FXML Label scoreLabel, timerLabel;
    private Timeline timing;

    public void initialize() {
        if(!isStarted){
            button1.setText("");
            button2.setText("");
            button3.setText("");
            button4.setText("");
            generateButton.setText("Start");
            isStarted = true;
        }
        
       
    }
    public void generateRandquiz(){
        Random random = new Random();
        valuea =  random.nextInt(10) + 1;
        valueb = random.nextInt(10) +1;
        pheptoan = random.nextInt(4)+1;
        
        switch (pheptoan) {
            case 1:
                generatedkq = valuea + valueb;
                break;
            case 2:
                generatedkq = valuea - valueb;
                break;
            case 3:
                generatedkq = valuea * valueb;
                break;
            case 4:
                generatedkq = valuea / valueb;
                break;
            
            default:
                break;
        }
        Float[] values = {(float)random.nextInt(100), (float)random.nextInt(50), (float)random.nextInt(50), generatedkq}; 

        List<Float> valueList = Arrays.asList(values);
        Collections.shuffle(valueList);
        
        mapketquatoView(valueList, valuea,valueb, pheptoan);      
    }
    public void mapketquatoView(List<Float> ketquas,int valuea,int valueb,int pheptoan){
        button1.setText(String.valueOf(new DecimalFormat("#").format(ketquas.get(0))));
        button2.setText(String.valueOf(new DecimalFormat("#").format(ketquas.get(1))));
        button3.setText(String.valueOf(new DecimalFormat("#").format(ketquas.get(2))));
        button4.setText(String.valueOf(new DecimalFormat("#").format(ketquas.get(3))));
        firstNumberField.setText(String.valueOf(new DecimalFormat("#").format(valuea)));
        secondNumberField.setText(String.valueOf(new DecimalFormat("#").format(valueb)));
        switch (pheptoan) {
            case 1:
                operatorField.setText("+");
                break;
            case 2:
                operatorField.setText("-");
                break;
            case 3:
                operatorField.setText("*");
                break;
            case 4:
                operatorField.setText("/");
                break;
            
            default:
                break;
        }
        
    }
    @FXML
    public void handleGenBtn(){
        generateRandquiz();
        UpdateUI();
        startTimer();
    }
    private void resetbtnStyle() {
        button1.setDisable(false);
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        // Reset style for all defined buttons
        button1.setStyle("-fx-background-color: white; -fx-background-radius: 15;-fx-text-fill: black; -fx-font-size: 20;");
        button2.setStyle("-fx-background-color: white; -fx-background-radius: 15;-fx-text-fill: black; -fx-font-size: 20;");
        button3.setStyle("-fx-background-color: white; -fx-background-radius: 15;-fx-text-fill: black; -fx-font-size: 20;");
        button4.setStyle("-fx-background-color: white; -fx-background-radius: 15;-fx-text-fill: black; -fx-font-size: 20;");
    }
    private void disableButtons() {
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);
        timerLabel.setText("Hết giờ");
        button1.setText("booo");
        button2.setText("booo");
        button3.setText("booo");
        button4.setText("booo");
    }
    @FXML 
    public void handleAns(ActionEvent event){
        Button btnclicked = (Button) event.getSource();
        String ansValue = btnclicked.getText();
        if(Float.parseFloat(ansValue) == generatedkq){
            btnclicked.setStyle("-fx-background-color: green; -fx-background-radius: 15;-fx-text-fill: black; -fx-font-size: 20;");
            score +=1;   
            
        }
        else {
            btnclicked.setStyle("-fx-background-color: red; -fx-background-radius: 15; -fx-text-fill: black; -fx-font-size: 20;"); 
            
        }
        timing.stop();      
        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(e -> handleGenBtn());
        pause.play();
        
    }
    private void startTimer() {
        countdown = ANS_COUNT_DOWN;
        timerLabel.setText(String.valueOf(countdown)); 
        
        
        timing = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            countdown--;
            timerLabel.setText(String.valueOf(countdown)); // Update timing label
            
            if (countdown <= 0) {
                timing.stop();
                disableButtons();
            }
        }));
        timing.setCycleCount(countdown); // Count down for the specified seconds
        timing.play();

    }
    public void UpdateUI(){
        if(isStarted) generateButton.setText("Generate quiz");
        resetbtnStyle();
        scoreLabel.setText(String.valueOf(score));
        
    }
}