import java.util.Scanner;

public class LoadBalancer {
    
    static void printLoad(int servers, int processes) {
        int each = processes / servers;
        int extra = processes % servers;
        int total;

        for (int i = 0; i < servers; i++) {
            if (extra-- > 0) {
                total = each + 1;
            } else {
                total = each;
            }
            System.out.println("Server " + (char)('A' + i) + " has " + total + " Processes");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of servers and Processes: ");
        int servers = sc.nextInt();
        int processes = sc.nextInt();

        while (true) {
            printLoad(servers, processes);
            System.out.println("1. Add Servers\n2. Remove Servers\n3. Add Processes\n4. Remove Processes\n5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("How many more servers? ");
                    servers += sc.nextInt();
                    break;
                case 2:
                    System.out.print("How many servers to remove? ");
                    servers -= sc.nextInt();
                    break;
                case 3:
                    System.out.print("How many more Processes? ");
                    processes += sc.nextInt();
                    break;
                case 4:
                    System.out.print("How many Processes to remove? ");
                    processes -= sc.nextInt();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
