package api3rd;

import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;



public class FXMLController {

    @FXML
    TextArea txtAreainfo;
    @FXML
    TextField txtrecipe;
    @FXML
    ImageView imageView;
    String  BASE_API_URL = "https://www.themealdb.com/api/json/v1/1/search.php?s=";
    public void initialize() {
        
       
         
        // Create the Buttons
        Button playButton = new Button("Play");
        Button stopButton = new Button("Stop");
        
    }
    public void ThongTin(){

        String searchQurey = txtrecipe.getText();
        System.out.println(BASE_API_URL+searchQurey);
        StringBuilder content = new StringBuilder();
        try{
            String endcodedquery = URLEncoder.encode(searchQurey, "UTF-8");
            URL url = new URL(BASE_API_URL+endcodedquery);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;

            while ((inputLine = br.readLine()) != null) {
                content.append(inputLine);
            };
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        JSONObject mealsobj = new JSONObject(content.toString());
        JSONArray meals =  (JSONArray) mealsobj.get("meals");
        JSONObject meal =  (JSONObject)meals.get(0);
        String mealName =(String)meal.get("strMeal");
        String mealInstruction =(String)meal.get("strInstructions");
        String mealSource =(String)meal.get("strSource");
        String mealimg = (String)meal.get("strMealThumb");
  
        txtAreainfo.setText("Name: " + mealName +
                        "\n"+
                        "\ninstruction: " + mealInstruction +
                        "\n"+
                        "\nsource: " + mealSource 
                    );
        txtAreainfo.setWrapText(true);
        Image recipImage = new Image(mealimg);
        imageView.setImage(recipImage);
    };
}