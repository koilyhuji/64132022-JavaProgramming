import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;

public class Main {

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("songque.txt");
        fw.write("song que nuoc chay dou bow \n");
        fw.write("de anhw 9 ao i10 khow thuong em");
        fw.flush();
        fw.close();
        URL url = new URL("https://ntu.edu.vn");
        URLConnection connect  = url.openConnection();
        InputStream ip  = connect.getInputStream();
        BufferedReader bufread = new BufferedReader(new InputStreamReader(ip));
        System.out.println(bufread.readLine());
        System.out.println(bufread.readLine());
        System.out.println(bufread.readLine());
        System.out.println(bufread.readLine());
        System.out.println(bufread.readLine());
    }
}