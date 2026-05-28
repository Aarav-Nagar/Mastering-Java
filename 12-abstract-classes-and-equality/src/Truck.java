/**
 * Truck class extending Vehicle.
 */
public class Truck extends Vehicle {
    private double cargoCapacity; // in tons
    private boolean hasTrailer;
    
    public Truck(String make, String model, int year, double price, double cargoCapacity, boolean hasTrailer) {
        super(make, model, year, price);
        this.cargoCapacity = cargoCapacity;
        this.hasTrailer = hasTrailer;
    }
    
    @Override
    public double calculateDepreciation() {
        // Trucks lose 12% per year
        int ageYears = 2024 - year;
        return price * 0.12 * ageYears;
    }
    
    @Override
    public String getVehicleType() {
        return "Truck";
    }
    
    public double getCargoCapacity() {
        return cargoCapacity;
    }
    
    public boolean hasTrailer() {
        return hasTrailer;
    }
}
