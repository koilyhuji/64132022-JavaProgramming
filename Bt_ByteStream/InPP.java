import java.io.FileInputStream;
import java.io.IOException;

public class InPP {
    public static void main(String[] args) throws IOException {
        FileInputStream fint = new FileInputStream("num.clc");
        int byteRead;
        while (true) {
            byteRead = fint.read();
            if(byteRead == -1) break;
            System.out.println(byteRead);
        }
        System.out.println("done");
    }
}
