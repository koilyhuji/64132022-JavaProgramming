import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class Doc {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("songque.txt");
        BufferedReader bufread = new BufferedReader(fr);
        String buff = bufread.readLine();
        for(int i = 0; i< 10; i++){
            System.out.println(buff);
        }
    }
}
