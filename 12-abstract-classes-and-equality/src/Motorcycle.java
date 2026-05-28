/**
 * Motorcycle class extending Vehicle.
 */
public class Motorcycle extends Vehicle {
    private int engineCC;
    private String style; // sport, cruiser, touring
    
    public Motorcycle(String make, String model, int year, double price, int engineCC, String style) {
        super(make, model, year, price);
        this.engineCC = engineCC;
        this.style = style;
    }
    
    @Override
    public double calculateDepreciation() {
        // Motorcycles lose 20% per year
        int ageYears = 2024 - year;
        return price * 0.20 * ageYears;
    }
    
    @Override
    public String getVehicleType() {
        return "Motorcycle";
    }
    
    public int getEngineCC() {
        return engineCC;
    }
    
    public String getStyle() {
        return style;
    }
}
