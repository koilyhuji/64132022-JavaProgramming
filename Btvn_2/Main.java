import java.util.ArrayList;
import java.util.Scanner;
	
public class Main {
	private ArrayList<News> newsList = new ArrayList<>();
	
	public static void main(String[] args) {
		 ManageNews manager = new ManageNews();
		 manager.run();
	}
	
	public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Insert news");
            System.out.println("2. View list news");
            System.out.println("3. Average rate");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    insertNews(scanner);
                    break;
                case 2:
                    viewNews();
                    break;
                case 3:
                    averageRate(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);
    }
	
	private void insertNews(Scanner scanner) {
        News news = new News();
        System.out.print("Enter title: ");
        news.setTitle(scanner.nextLine());
        System.out.print("Enter publish date: ");
        news.setPublishDate(scanner.nextLine());
        System.out.print("Enter author: ");
        news.setAuthor(scanner.nextLine());
        System.out.print("Enter content: ");
        news.setContent(scanner.nextLine());

        System.out.println("Enter 3 ratings (1-5): ");
        for (int i = 0; i < 3; i++) {
            int rate;
            do {
                System.out.print("Rate " + (i + 1) + ": ");
                rate = scanner.nextInt();
            } while (rate < 1 || rate > 5);
            news.addRate(rate);
        }
        news.Calculate();
        newsList.add(news);
    }

    
    private void viewNews() {
        for (News news : newsList) {
            news.Display();
            System.out.println();
        }
    }

   
    private void averageRate(Scanner scanner) {
        for (News news : newsList) {
            news.Calculate();
            System.out.println("News Title: " + news.getTitle() + " - Average Rate: " + news.getAverageRate());
        }
    }
}
