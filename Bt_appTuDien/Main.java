import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        HashMap<String,String> words = new HashMap<String, String>();
        words.put("hello", "chao");
        words.put("world", "the gioi");
        words.put("one","mot");
        words.put("two","hai");
        words.put("three","ba");
        words.put("four","bon");
        words.put("five","nam");
        words.put("six","sau");
        words.put("seven","bay");
        words.put("eight","tam");
        System.out.println("nhap tu :");
        Scanner sc = new Scanner(System.in);
        String w = sc.nextLine();
        System.out.println(w);
        String[] tokens = w.split("\\s+");
        String res = "";
        for(int i = 0 ; i< tokens.length; i++){ 
            if(!words.containsKey(tokens[i])){
                res += tokens[i] + " ";
                continue;
            }
            else res += (words.get(tokens[i]) + " ");
        }
        System.out.println("nghia la : "+ res);
        return;
        // if(!words.containsKey(w)){
        //     System.out.println("tu nhap khong co trong tu dien");
        //     return;
        // }
        // System.out.println("nghia la : "+ words.get(w));
    }
}