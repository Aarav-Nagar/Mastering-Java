import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Day 12: Abstract Classes and Equality
 * Demonstrates abstract classes, overriding Object methods (equals, hashCode, toString).
 * 
 * Vehicle hierarchy:
 * - Vehicle (abstract)
 *   - Car
 *   - Truck
 *   - Motorcycle
 */
public class AbstractEqualityApp {
    
    public static void main(String[] args) {
        System.out.println("=== Abstract Classes and Equality Lab ===\n");
        
        // Test 1: Abstract class with polymorphism
        System.out.println("Test 1: Creating Vehicles via Polymorphism");
        System.out.println("----------------------------------------");
        
        Car car1 = new Car("Toyota", "Camry", 2022, 28000, 4, "Hybrid");
        Car car2 = new Car("Honda", "Civic", 2020, 22000, 4, "Gasoline");
        Truck truck1 = new Truck("Ford", "F-150", 2021, 35000, 3.5, true);
        Motorcycle moto1 = new Motorcycle("Harley", "Street 750", 2023, 7500, 750, "Cruiser");
        
        List<Vehicle> fleet = new ArrayList<>();
        fleet.add(car1);
        fleet.add(car2);
        fleet.add(truck1);
        fleet.add(moto1);
        
        System.out.println("Fleet created with " + fleet.size() + " vehicles");
        System.out.println();
        
        // Test 2: toString() override
        System.out.println("Test 2: toString() Override");
        System.out.println("----------------------------------------");
        for (Vehicle v : fleet) {
            System.out.println(v.toString());
        }
        System.out.println();
        
        // Test 3: Abstract method polymorphism
        System.out.println("Test 3: Depreciation Calculations (Abstract Methods)");
        System.out.println("----------------------------------------");
        for (Vehicle v : fleet) {
            double depreciation = v.calculateDepreciation();
            double currentValue = v.getCurrentValue();
            System.out.printf("%s: Original=$%.2f, Depreciation=$%.2f, Current=$%.2f%n",
                v.getMake() + " " + v.getModel(), v.getPrice(), depreciation, currentValue);
        }
        System.out.println();
        
        // Test 4: equals() override
        System.out.println("Test 4: equals() Override - Object Comparison");
        System.out.println("----------------------------------------");
        
        Car car3 = new Car("Toyota", "Camry", 2022, 30000, 4, "Gasoline");
        System.out.println("car1 equals car2: " + car1.equals(car2)); // Different make/model
        System.out.println("car1 equals car3: " + car1.equals(car3)); // Same make/model/year
        System.out.println("car1 equals truck1: " + car1.equals(truck1)); // Different type
        System.out.println("car1 equals null: " + car1.equals(null)); // Null check
        System.out.println();
        
        // Test 5: hashCode() override
        System.out.println("Test 5: hashCode() Override - Consistency");
        System.out.println("----------------------------------------");
        
        Set<Vehicle> uniqueVehicles = new HashSet<>();
        uniqueVehicles.add(car1);
        uniqueVehicles.add(car2);
        uniqueVehicles.add(car3); // Same as car1, should not be added twice
        uniqueVehicles.add(truck1);
        uniqueVehicles.add(moto1);
        
        System.out.println("Total vehicles added: 5");
        System.out.println("Unique vehicles in HashSet: " + uniqueVehicles.size());
        System.out.println("(car1 and car3 have same make/model/year, treated as equal)");
        System.out.println();
        
        // Test 6: Object method contracts
        System.out.println("Test 6: Object Method Contracts");
        System.out.println("----------------------------------------");
        System.out.println("If obj1.equals(obj2), then obj1.hashCode() == obj2.hashCode(): " +
            (car1.equals(car3) && car1.hashCode() == car3.hashCode() ? "TRUE" : "FALSE"));
        System.out.println("equals() is reflexive (x.equals(x)): " + car1.equals(car1));
        System.out.println("equals() is symmetric (x.equals(y) => y.equals(x)): " +
            (car1.equals(car3) && car3.equals(car1) ? "TRUE" : "FALSE"));
        System.out.println();
        
        // Test 7: Describing vehicles
        System.out.println("Test 7: Describe Method (Uses toString)");
        System.out.println("----------------------------------------");
        car1.describe();
        truck1.describe();
        moto1.describe();
        System.out.println();
        
        // Test 8: Finding vehicles of specific type
        System.out.println("Test 8: Type-Based Filtering");
        System.out.println("----------------------------------------");
        int carCount = 0;
        for (Vehicle v : fleet) {
            if (v instanceof Car) {
                carCount++;
            }
        }
        System.out.println("Number of cars in fleet: " + carCount);
        System.out.println();
        
        System.out.println("=== Abstract Classes and Equality Lab Complete ===");
    }
}
