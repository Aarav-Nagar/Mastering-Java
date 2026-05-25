public class Thermostat {
    private Temperature current;
    private Temperature target;

    public Thermostat(Temperature current, Temperature target) {
        this.current = current;
        this.target = target;
    }

    public Thermostat(double currentCelsius, double targetCelsius) {
        this(new Temperature(currentCelsius), new Temperature(targetCelsius));
    }

    public Temperature getCurrent() {
        return new Temperature(current.getCelsius());
    }

    public Temperature getTarget() {
        return new Temperature(target.getCelsius());
    }

    public void setTargetCelsius(double celsius) {
        target.setCelsius(celsius);
    }

    public void setTargetFahrenheit(double fahrenheit) {
        target.setFahrenheit(fahrenheit);
    }

    public boolean isAtTarget(double toleranceCelsius) {
        return Math.abs(current.getCelsius() - target.getCelsius()) <= toleranceCelsius;
    }

    public void applyStepTowardTarget(double stepCelsius) {
        if (stepCelsius <= 0) {
            throw new IllegalArgumentException("stepCelsius must be positive");
        }

        double now = current.getCelsius();
        double goal = target.getCelsius();

        if (now == goal) {
            return;
        }

        double direction = Math.signum(goal - now);
        double next = now + direction * stepCelsius;

        if ((direction > 0 && next > goal) || (direction < 0 && next < goal)) {
            next = goal;
        }

        current.setCelsius(next);
    }

    @Override
    public String toString() {
        return "Current: " + current + " | Target: " + target;
    }
}
