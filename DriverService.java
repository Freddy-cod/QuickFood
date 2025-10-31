import java.io.*;
import java.util.*;

public class DriverService {

    public static List<Driver> loadDrivers(String fileName) {
        List<Driver> drivers = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    String location = parts[1].trim();
                    int load = Integer.parseInt(parts[2].trim());
                    drivers.add(new Driver(name, location, load));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading drivers.txt: " + e.getMessage());
        }
        return drivers;
    }

    public static Driver findBestDriver(List<Driver> drivers, String restaurantLocation) {
        Driver selected = null;
        int minLoad = Integer.MAX_VALUE;
        for (Driver d : drivers) {
            if (d.getLocation().equalsIgnoreCase(restaurantLocation) && d.getLoad() < minLoad) {
                selected = d;
                minLoad = d.getLoad();
            }
        }
        return selected;
    }
}
