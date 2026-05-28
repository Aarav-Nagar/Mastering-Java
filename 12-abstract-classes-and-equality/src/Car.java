/**
 * Car class extending Vehicle.
 */
public class Car extends Vehicle {
    private int numDoors;
    private String fuelType;
    
    public Car(String make, String model, int year, double price, int numDoors, String fuelType) {
        super(make, model, year, price);
        this.numDoors = numDoors;
        this.fuelType = fuelType;
    }
    
    @Override
    public double calculateDepreciation() {
        // Cars lose 15% per year
        int ageYears = 2024 - year;
        return price * 0.15 * ageYears;
    }
    
    @Override
    public String getVehicleType() {
        return "Car";
    }
    
    public int getNumDoors() {
        return numDoors;
    }
    
    public String getFuelType() {
        return fuelType;
    }
}
