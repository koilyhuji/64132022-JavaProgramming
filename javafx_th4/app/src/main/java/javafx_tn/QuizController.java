package javafx_tn;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
public class QuizController {
    ArrayList<Questions> qs = new ArrayList<>();
    Questions currQuestions = null;
    float score=0;
    @FXML
    private VBox buttonVboxCH;
    @FXML
    private Button btnAnsA,btnAnsB,btnAnsC,btnAnsD;
    @FXML
    private TextArea questionText;
    @FXML
    private TextField txtScore;
    @FXML
    private MediaView mediaView;  
    private MediaPlayer mediaPlayer;
    public void initialize() {

        
        
        qs.add(new Questions("Chất nào là axit?", "NaOH", "HCl", "NaCl", "KOH", "HCl", ""));
        qs.add(new Questions("Chất nào là bazơ?", "NaOH", "HCl", "NaCl", "KOH", "NaOH", ""));
        qs.add(new Questions("Chất nào là muối?", "NaOH", "HCl", "NaCl", "KOH", "NaCl", ""));
        qs.add(new Questions("Hợp chất nào là khí độc?", "CO2", "O2", "N2", "CO", "CO", ""));
        qs.add(new Questions("Nước có pH là bao nhiêu?", "5", "6", "7", "8", "7", ""));
        qs.add(new Questions("Chất nào là chất điện ly mạnh?", "NaOH", "HCl", "NaCl", "KOH", "HCl", ""));
        qs.add(new Questions("Chất nào có thể hòa tan trong nước?", "NaCl", "Fe", "Cu", "Al", "NaCl", ""));
        qs.add(new Questions("Chất nào không tan trong nước?", "NaCl", "Fe", "K2SO4", "H2O", "Fe", ""));
        qs.add(new Questions("Công thức hóa học của nước?", "H2O", "CO2", "H2SO4", "NaCl", "H2O", ""));
        qs.add(new Questions("Sự chuyển thể từ lỏng sang hơi là gì?", "Đông đặc", "Hóa hơi", "Nóng chảy", "Ngưng tụ", "Hóa hơi", ""));
        qs.add(new Questions("Chất nào là khí?", "Nước", "Khí CO2", "Muối NaCl", "Cát", "Khí CO2", ""));
        qs.add(new Questions("Chất nào là kim loại?", "Cu", "S", "O2", "H2O", "Cu", ""));
        qs.add(new Questions("Công thức hóa học của axit sulfuric?", "HCl", "H2SO4", "HNO3", "H2O", "H2SO4", ""));
        qs.add(new Questions("Chất nào là khí gây ô nhiễm?", "CO2", "O2", "N2", "SO2", "SO2", ""));

        for (int i = 0; i< qs.size(); i++) {
            Button button = new Button();
            String label = "Câu" + i;
            button.setText(label);
            button.setStyle("-fx-background-color: #64B5F6; " +
                            "-fx-text-fill: black; " +
                            "-fx-min-width: 150px; " +
                            "-fx-min-height: 30px; " +
                            "-fx-font-size: 14px; " +
                            "-fx-cursor: hand;");
            button.setOnAction(event -> {
                int quesindex = buttonVboxCH.getChildren().indexOf(button);
                handleButtonQClick(event, quesindex);
                
            });  
            buttonVboxCH.getChildren().add(button);
        }

        String mediaPath = "/javafx_tn/images/lla.png"; 
        playMedia(mediaPath);
       
    }

    private void playMedia(String mediaPath) {
        String resource = getClass().getResource(mediaPath).toExternalForm();  
        File res = new File(resource);
        Media media = new Media(res.toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        
    }
    public void handleButtonQClick(ActionEvent event,int quesindex){

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
        Questions question = qs.get(quesindex);
        currQuestions = question;
        questionText.setText(question.getQuestion());
        
        btnAnsA.setText(question.getA());
        btnAnsB.setText(question.getB());
        btnAnsC.setText(question.getC());
        btnAnsD.setText(question.getD());

            
            
            
            
    }

    public void handleButtonAnsClick(ActionEvent event){
        btnAnsA.setStyle("-fx-background-color: #1565C0;-fx-text-fill: white;-fx-min-width: 370px;-fx-min-height: 40px;-fx-font-size: 16px;-fx-cursor: hand;-fx-border-color: black;  -fx-border-width: 1px;");
        btnAnsB.setStyle(btnAnsA.getStyle().toString());
        btnAnsC.setStyle(btnAnsA.getStyle().toString());
        btnAnsD.setStyle(btnAnsA.getStyle().toString());
        Button clickedButton = (Button) event.getSource();
        
        String answer = clickedButton.getText();
        if(answer.equals(currQuestions.getAnswer())){
            clickedButton.setStyle("-fx-background-color: #4FC978;-fx-text-fill: white;-fx-min-width: 370px;-fx-min-height: 40px;-fx-font-size: 16px;-fx-cursor: hand;-fx-border-color: black;  -fx-border-width: 1px;");
            score++;
        } else {
            score -= 0.2;
            clickedButton.setStyle("-fx-background-color: red;-fx-text-fill: white;-fx-min-width: 370px;-fx-min-height: 40px;-fx-font-size: 16px;-fx-cursor: hand;-fx-border-color: black;  -fx-border-width: 1px;");
        }
        score = (float) (Math.round(score * 100.0) / 100.0);
        txtScore.setText(String.valueOf(score));;
    }
    public void handleButtonExit(ActionEvent e){
        System.exit(0); 
    }
}