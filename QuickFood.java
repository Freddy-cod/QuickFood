import java.util.*;

public class QuickFood {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Capture customer details
        System.out.print("Enter order number: ");
        int orderNumber = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter customer name: ");
        String custName = scanner.nextLine();

        System.out.print("Enter customer contact number: ");
        String custContact = scanner.nextLine();

        System.out.print("Enter customer address: ");
        String custAddress = scanner.nextLine();

        System.out.print("Enter customer location (city): ");
        String custLocation = scanner.nextLine();

        System.out.print("Enter customer email: ");
        String custEmail = scanner.nextLine();

        Customer customer = new Customer(orderNumber, custName, custContact, custAddress, custLocation, custEmail);

        // Capture restaurant details
        System.out.print("Enter restaurant name: ");
        String restName = scanner.nextLine();

        System.out.print("Enter restaurant location: ");
        String restLocation = scanner.nextLine();

        System.out.print("Enter restaurant contact number: ");
        String restContact = scanner.nextLine();

        Restaurant restaurant = new Restaurant(restName, restLocation, restContact);

        // Capture meals
        List<Meal> meals = new ArrayList<>();
        System.out.print("Enter number of different meals: ");
        int numMeals = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numMeals; i++) {
            System.out.print("Enter meal name: ");
            String mealName = scanner.nextLine();
            System.out.print("Enter meal price: ");
            double mealPrice = Double.parseDouble(scanner.nextLine());
            System.out.print("Enter meal quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            meals.add(new Meal(mealName, mealPrice, quantity));
        }

        System.out.print("Enter special instructions (or leave blank): ");
        String specialInstructions = scanner.nextLine();

        // Load drivers
        List<Driver> drivers = DriverService.loadDrivers("drivers.txt");

        // Find best driver
        Driver bestDriver = DriverService.findBestDriver(drivers, restaurant.getLocation());

        // Generate invoice
        InvoiceGenerator.generateInvoice(customer, restaurant, meals, specialInstructions, bestDriver);

        scanner.close();
    }
}
