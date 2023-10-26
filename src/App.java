import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        APIAccess access = new APIAccess();
        while (true) {
            System.out.println();
            System.out.println("****************************************************");
            System.out.print("Enter the URL to use ");
            String url = input.nextLine();
            System.out.println();
            if (url != null && url.length() > 6) {
                System.out.println(access.accessUrl(url));
            } else {
                break;
            }

        }
    }
}
