import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FileOutputStream fout = null;
        try {
             fout = new FileOutputStream("num.clc");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("khong tim thay file");
        }
        try {

            for(int i = 0; i< 128; i++){
                fout.write(i);
            }
            fout.flush();
            fout.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("done");
    }
}