public class Temperature {
    private double celsius;

    public Temperature(double celsius) {
        this.celsius = celsius;
    }

    public static Temperature fromFahrenheit(double fahrenheit) {
        return new Temperature((fahrenheit - 32.0) * 5.0 / 9.0);
    }

    public double getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return celsius * 9.0 / 5.0 + 32.0;
    }

    public void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    public void setFahrenheit(double fahrenheit) {
        this.celsius = (fahrenheit - 32.0) * 5.0 / 9.0;
    }

    @Override
    public String toString() {
        return String.format("%.2f C (%.2f F)", getCelsius(), getFahrenheit());
    }
}
