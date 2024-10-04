package main.java;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("hello");
        String filePath = "b6qja-or3wd.json";
        byte[] byteString = Files.readAllBytes(Paths.get(filePath));
        String jsonstr = new String(byteString);
        JSONArray objData = new JSONArray(jsonstr);
        Scanner sc = new Scanner(System.in);
        System.out.println("tim kiem theo ten, nganh, trinh do: ");
        String query = sc.nextLine();
        for(int i = 0; i< objData.length(); i++){
            JSONObject teacherObj = objData.getJSONObject(i);
            StringBuilder searchString = new StringBuilder();
            searchString.append(teacherObj.get("qualifications"))
                        .append(teacherObj.get("undergrad_lec"))
                        .append(teacherObj.get("fileds"))
                        .append(teacherObj.get("name"))
                        .append(teacherObj.get("postgrad_lec"));
            if(searchString.toString().toLowerCase().contains(" "+query+" ")){
                System.out.println("--------------------");
                printRes(teacherObj);
                System.out.println("--------------------");
            }
        }
    }
    private static void printRes(JSONObject obj){
        System.out.println("ten: " + obj.get("name"));
        System.out.println("hoc vi: " + obj.get("qualifications"));
        System.out.println("nganh giang day (trinh do dai hoc:) " + obj.get("undergrad_lec"));
        System.out.println("chuyen mon: " + obj.get("fileds"));
        System.out.println("nganh giang day (trinh do sau dai hoc:) " + obj.get("postgrad_lec"));

    }
}
