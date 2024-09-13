import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        float heightInMeters, weight;
        float bmi;
        Scanner scan = new Scanner(System.in);
        System.out.print("Nhap chieu cao (m): ");
        heightInMeters = scan.nextFloat();
        System.out.print("Nhap can nang: ");
        weight = scan.nextFloat();
        bmi = weight / (heightInMeters * heightInMeters);
        System.out.println("BMI: "+ String.format("%.2f", bmi));
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
}
