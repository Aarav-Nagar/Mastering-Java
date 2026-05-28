/**
 * Abstract base class for vehicles.
 * Demonstrates abstract methods, concrete methods, and Object methods.
 */
public abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected double price;
    
    /**
     * Constructor for Vehicle.
     */
    public Vehicle(String make, String model, int year, double price) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.price = price;
    }
    
    /**
     * Abstract method: subclasses must implement.
     */
    public abstract double calculateDepreciation();
    
    /**
     * Abstract method: subclasses must implement.
     */
    public abstract String getVehicleType();
    
    /**
     * Concrete method: all vehicles can describe themselves.
     */
    public void describe() {
        System.out.println(toString());
    }
    
    /**
     * Concrete method: current value after depreciation.
     */
    public double getCurrentValue() {
        return price - calculateDepreciation();
    }
    
    /**
     * Override equals() for meaningful comparison.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Vehicle other = (Vehicle) obj;
        return this.make.equals(other.make) &&
               this.model.equals(other.model) &&
               this.year == other.year;
    }
    
    /**
     * Override hashCode() consistent with equals().
     */
    @Override
    public int hashCode() {
        return (make + model + year).hashCode();
    }
    
    /**
     * Override toString() for clear representation.
     */
    @Override
    public String toString() {
        return String.format("%s{make='%s', model='%s', year=%d, price=$%.2f, type=%s}", 
            getClass().getSimpleName(), make, model, year, price, getVehicleType());
    }
    
    // Getters
    public String getMake() {
        return make;
    }
    
    public String getModel() {
        return model;
    }
    
    public int getYear() {
        return year;
    }
    
    public double getPrice() {
        return price;
    }
}
