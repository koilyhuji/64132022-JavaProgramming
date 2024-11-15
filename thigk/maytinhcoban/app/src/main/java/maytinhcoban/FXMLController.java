package maytinhcoban;

import org.checkerframework.checker.calledmethods.qual.EnsuresCalledMethodsIf.List;

import com.google.common.io.Files;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FXMLController {
       @FXML
    private TextField inputA;
    @FXML
    private TextField inputB;
    @FXML
    private TextArea inputKQ;

    private static final String FILE_PATH = "log.txt";
    private static final int MAX_LINES = 10;
    
    public static ArrayList<String> lines = new ArrayList<>();
    public static ArrayList<String> newlist = new ArrayList<>();
    public void initialize() {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        
        
    }
    public static void writeLine(String line) {
        

        try {
            FileReader fr = new FileReader(FILE_PATH);
            BufferedReader bufread = new BufferedReader(fr);
            lines.add(bufread.readLine());
            

        } catch (IOException e) {
            e.printStackTrace();
        }

        lines.add(line);
        if (lines.size() > MAX_LINES) {
            newlist = new ArrayList<>();
            for(int i = MAX_LINES -1; i>= 0; i--){
                newlist.add(lines.get(i));
            }
            
        }
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(line + System.lineSeparator());
        } catch (IOException e) {
            throw new RuntimeException("Error writing to file", e);
        }

        try{
            
            FileWriter w = new FileWriter(FILE_PATH);
            BufferedWriter writer = new BufferedWriter(w);
            for (String l : lines) {
                writer.write(l);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void handleAddition() {
        double num1 = Double.parseDouble(inputA.getText());
        double num2 = Double.parseDouble(inputB.getText());
        inputKQ.setText(String.valueOf(num1 + num2));
        StringBuilder str = new StringBuilder();
        //"" + num1 + "+" + num2 + "=" + String.valueOf(num1 + num2)
        str.append(num1);
        str.append("+");
        str.append(num2);
        str.append("=");
        str.append(String.valueOf(num1 + num2));
        String res = str.toString();
        writeLine(res);
    }

    @FXML
    private void handleSubtraction() {
        double num1 = Double.parseDouble(inputA.getText());
        double num2 = Double.parseDouble(inputB.getText());
        inputKQ.setText(String.valueOf(num1 - num2));
        String str = new String("" + num1 + "-" + num2 + "=" + String.valueOf(num1 - num2));
        //writeLine(str);
    }

    @FXML
    private void handleMultiplication() {
        double num1 = Double.parseDouble(inputA.getText());
        double num2 = Double.parseDouble(inputB.getText());
        inputKQ.setText(String.valueOf(num1 * num2));
        String str = new String("" + num1 + "*" + num2 + "=" + String.valueOf(num1 * num2));
        //writeLine(str);
    }

    @FXML
    private void handleDivision() {
        double num1 = Double.parseDouble(inputA.getText());
        double num2 = Double.parseDouble(inputB.getText());
        if (num2 != 0) {
            inputKQ.setText(String.valueOf(num1 / num2));
        } else {
            inputKQ.setText("Error");
        }
        String str = new String("" + num1 + "/" + num2 + "=" + String.valueOf(num1 / num2));
        ////writeLine(str);
    }
    @FXML
    private void handleMod() {
        double num1 = Double.parseDouble(inputA.getText());
        double num2 = Double.parseDouble(inputB.getText());
        if (num2 != 0) {
            inputKQ.setText(String.valueOf(num1 % num2));
        } else {
            inputKQ.setText("Error");
        }
        String str = new String("" + num1 + "mod" + num2 + "=" + String.valueOf(num1 % num2));
        //writeLine(str);
    }

    

    
}