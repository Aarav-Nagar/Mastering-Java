import java.util.Locale;
import java.util.Scanner;

public class ThermostatApp {
    private static final double DEFAULT_TOLERANCE_C = 0.25;

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Thermostat Simulator (Encapsulation Practice)");
        System.out.println("Enter temperatures in either C or F.");

        Temperature initial = promptTemperature(scanner, "Initial temperature");
        Temperature target = promptTemperature(scanner, "Target temperature");

        Thermostat thermostat = new Thermostat(initial, target);

        System.out.print("Step size in C (e.g., 0.5): ");
        double step = readPositiveDouble(scanner);

        System.out.println();
        System.out.println(thermostat);

        int ticks = 0;
        while (!thermostat.isAtTarget(DEFAULT_TOLERANCE_C)) {
            thermostat.applyStepTowardTarget(step);
            ticks++;
            System.out.printf("Tick %d -> %s%n", ticks, thermostat);
        }

        System.out.println();
        System.out.println("Reached target (within tolerance). Total ticks: " + ticks);
        scanner.close();
    }

    private static Temperature promptTemperature(Scanner scanner, String label) {
        while (true) {
            System.out.print(label + " value: ");
            String valueToken = scanner.next();

            System.out.print(label + " unit (C/F): ");
            String unitToken = scanner.next();

            try {
                double value = Double.parseDouble(valueToken);
                String unit = unitToken.trim().toUpperCase();
                if (unit.equals("C")) {
                    return new Temperature(value);
                }
                if (unit.equals("F")) {
                    return Temperature.fromFahrenheit(value);
                }

                System.out.println("Unit must be C or F. Try again.");
            } catch (NumberFormatException ex) {
                System.out.println("Value must be a number. Try again.");
            }
        }
    }

    private static double readPositiveDouble(Scanner scanner) {
        while (true) {
            String token = scanner.next();
            try {
                double value = Double.parseDouble(token);
                if (value > 0) {
                    return value;
                }
                System.out.print("Must be > 0. Try again: ");
            } catch (NumberFormatException ex) {
                System.out.print("Must be a number. Try again: ");
            }
        }
    }
}
