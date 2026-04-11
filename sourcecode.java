import java.util.*;

public class RestaurantSystem {

    static String[] menuItems = {"Pizza", "Burger", "Pasta", "Sandwich", "Coffee"};
    static int[] prices = {120, 80, 100, 70, 50};
    static int[] orderQty = new int[5];

    static Scanner sc = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("\n----- MENU -----");
        for (int i = 0; i < menuItems.length; i++) {
            System.out.println((i + 1) + ". " + menuItems[i] + " - ₹" + prices[i]);
        }
    }

    public static void takeOrder() {
        char more;

        do {
            showMenu();
            System.out.print("Enter item number: ");
            int choice = sc.nextInt();

            if (choice >= 1 && choice <= 5) {
                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();

                orderQty[choice - 1] += qty;
            } else {
                System.out.println("Invalid choice!");
            }

            System.out.print("Add more items? (y/n): ");
            more = sc.next().charAt(0);

        } while (more == 'y' || more == 'Y');
    }

    public static void generateBill() {
        System.out.println("\n------ BILL ------");

        int total = 0;

        for (int i = 0; i < menuItems.length; i++) {
            if (orderQty[i] > 0) {
                int amount = orderQty[i] * prices[i];
                total += amount;

                System.out.println(menuItems[i] + " x " + orderQty[i] + " = ₹" + amount);
            }
        }

        double tax = total * 0.05;
        double grandTotal = total + tax;

        System.out.println("------------------");
        System.out.println("Total: ₹" + total);
        System.out.println("Tax (5%): ₹" + tax);
        System.out.println("Grand Total: ₹" + grandTotal);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Restaurant System");
        takeOrder();
        generateBill();
    }
}
