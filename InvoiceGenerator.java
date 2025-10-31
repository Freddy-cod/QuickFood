import java.io.*;
import java.util.List;

public class InvoiceGenerator {

    public static void generateInvoice(Customer customer, Restaurant restaurant,
            List<Meal> meals, String specialInstructions,
            Driver driver) {
        String fileName = "invoice.txt";

        try (PrintWriter pw = new PrintWriter(new File(fileName))) {
            pw.println("Order number " + customer.getOrderNumber());
            pw.println("Customer: " + customer.getName());
            pw.println("Email: " + customer.getEmail());
            pw.println("Phone number: " + customer.getContactNumber());
            pw.println("Location: " + customer.getLocation());
            pw.println("You have ordered the following from " + restaurant.getName()
                    + " in " + restaurant.getLocation() + ":");

            double total = 0;
            for (Meal meal : meals) {
                pw.printf("%d x %s (R%.2f)%n", meal.getQuantity(), meal.getName(), meal.getPrice());
                total += meal.getTotal();
            }

            if (specialInstructions != null && !specialInstructions.isEmpty()) {
                pw.println("Special instructions: " + specialInstructions);
            }

            pw.printf("Total: R%.2f%n", total);

            if (driver != null) {
                pw.println(driver.getName()
                        + " is nearest to the restaurant and so he will be delivering your order to you at:");
                pw.println(customer.getAddress());
                pw.println(customer.getLocation());
            } else {
                pw.println("Sorry, no driver available in the restaurant's area.");
            }

            pw.println("If you need to contact the restaurant, their number is " + restaurant.getContactNumber() + ".");

            System.out.println("Invoice generated in " + fileName);
        } catch (IOException e) {
            System.out.println("Error writing invoice: " + e.getMessage());
        }
    }
}
