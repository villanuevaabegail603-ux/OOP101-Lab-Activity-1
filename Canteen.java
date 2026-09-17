
import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] menuItems = {
            "Burger",
            "Pizza",
            "Pasta",
            "Sandwich",
            "Milk Tea"
        };

        double[] itemPrices = {
            50.00,
            75.00,
            65.00,
            40.00,
            55.00
        };

        int totalQuantity = 0;
        double totalBeforeDiscount = 0.0;

        // Ask if the customer is a student
        System.out.print("Are you a student? (Y/N): ");
        char studentStatus = scanner.next().toUpperCase().charAt(0);
        boolean isStudent = (studentStatus == 'Y');

        while (true) {

            // Display Menu
            System.out.println("\n===== MENU =====");

            for (int i = 0; i < menuItems.length; i++) {
                System.out.printf("%d. %s - PHP %.2f%n",
                        (i + 1), menuItems[i], itemPrices[i]);
            }

            // Get order details
            System.out.print("Enter item number: ");
            int itemNum = scanner.nextInt();

            System.out.print("Enter quantity (1-10): ");
            int quantity = scanner.nextInt();

            // Validate order
            if (itemNum < 1 || itemNum > 5 ||
                quantity < 1 || quantity > 10) {

                System.out.println(
                    "Invalid order! Please enter a valid item and quantity."
                );

                System.out.print("Do you want to order again? (Y/N): ");
                char tryAgain = scanner.next().toUpperCase().charAt(0);

                if (tryAgain == 'Y') {
                    continue;
                } else {
                    break;
                }
            }

            // Calculate order subtotal
            double unitPrice = itemPrices[itemNum - 1];
            double subtotal = unitPrice * quantity;

            totalQuantity += quantity;
            totalBeforeDiscount += subtotal;

            System.out.println("Order added successfully!");
            System.out.println("Item: " + menuItems[itemNum - 1]);
            System.out.println("Quantity: " + quantity);
            System.out.printf("Subtotal: PHP %.2f%n", subtotal);

            // Ask if customer wants to order again
            System.out.print("Do you want to order again? (Y/N): ");
            char again = scanner.next().toUpperCase().charAt(0);

            if (again != 'Y') {
                break;
            }
        }

        // Calculate discount based on total purchase
        double discountRate = 0.0;

        if (isStudent && totalBeforeDiscount >= 500.00) {
            discountRate = 0.15;
        } else if (isStudent) {
            discountRate = 0.10;
        } else if (totalBeforeDiscount >= 500.00) {
            discountRate = 0.05;
        }

        double totalDiscount = totalBeforeDiscount * discountRate;
        double finalAmount = totalBeforeDiscount - totalDiscount;

        // Display final summary
        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total quantity: " + totalQuantity);
        System.out.printf(
            "Total amount before deduction: PHP %.2f%n",
            totalBeforeDiscount
        );
        System.out.printf(
            "Total deduction: PHP %.2f%n",
            totalDiscount
        );
        System.out.printf(
            "Final amount to pay: PHP %.2f%n",
            finalAmount
        );

        System.out.println("Thank you for ordering!");

        scanner.close();
    }
}
