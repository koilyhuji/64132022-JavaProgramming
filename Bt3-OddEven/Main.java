import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter an interger: ");
        n = scan.nextInt();
        if(n%2 != 0){
            System.out.println(n+ " is odd");
        }
        else{
            System.out.println(n+ " is even");
        }
        System.out.println("bye");
    }
}
