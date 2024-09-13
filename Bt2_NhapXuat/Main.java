import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Khai bao bien can thiet
        int a,b,sum;
        //chuan bi nhap du lieu
        Scanner BanPhim = new Scanner(System.in);//System.in dai dien cho thiet bi nhap chuan
        System.out.println("CHUONG TRINH TINH TONG 2 SO NGUYEN");
        System.out.print("Nhap a = ");
        // doi nguoi dung nhap du lieu va luu avo bien a
        a = BanPhim.nextInt();
        System.out.print("Nhap b = ");
        b = BanPhim.nextInt();
        sum = a + b;
        System.out.println("---------");
        System.out.println("tong: " + sum);
    }

}
