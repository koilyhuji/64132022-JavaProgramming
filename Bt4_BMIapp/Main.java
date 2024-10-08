import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        float heightInMeters = 0, weight = 0;
        float bmi;
        String race = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("CHUONG TRINH TINH BMI");
        System.out.println("---------------------");
        System.out.print("Ban co phai la nguoi chau a? (y/n): ");
        race = scan.nextLine();
        while ( !race.equals("y") && !race.equals("n")){
            System.out.println("vui long chon y/n");
            System.out.print("Ban co phai la nguoi chau a? (y/n): ");
            race = scan.nextLine();
        }
        while(true){
            try {
                System.out.print("Nhap chieu cao (m): ");
                heightInMeters = scan.nextFloat();
                System.out.print("Nhap can nang: ");
                weight = scan.nextFloat();
                if(!(heightInMeters > 1 && heightInMeters <2.5) || !(weight > 1 && weight <500) ){
                    System.out.println("chieu cao hoac can nang khong hop le");
                }
                else break;
            } catch (Exception e) {
                System.out.println("Loi: Du lieu nhap vao khong hop le. Vui long nhap so thuc.");
                throw new Error(e);
            }
        }
        
        bmi = weight / (heightInMeters * heightInMeters);
        System.out.println("BMI: "+ String.format("%.2f", bmi));
        if(race.equals("n")){
            if (bmi < 18.5) {
                System.out.println("Underweight");
            } else if (bmi >= 18.5 && bmi < 25) {
                System.out.println("Normal weight");
            } else if (bmi >= 25 && bmi < 30) {
                System.out.println("Overweight");
            } else {
                System.out.println("Obese");
            }
        }
        else if (race.equals("y")){
            if (bmi < 18.5) {
                System.out.println("Underweight");
            } else if (bmi >= 18.5 && bmi < 22.9) {
                System.out.println("Normal weight");
            } else if (bmi >= 23 && bmi < 24.9) {
                System.out.println("Overweight");
            } else {
                System.out.println("Obese");
            }
        }

    }
}
