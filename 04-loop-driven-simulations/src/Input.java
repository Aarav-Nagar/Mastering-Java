import java.util.Scanner;

public final class Input {
    private Input() {}

    public static int readIntInRange(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String raw = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(raw);
                if (value < min || value > max) {
                    System.out.printf("Enter an integer in [%d, %d].%n", min, max);
                    continue;
                }
                return value;
            } catch (NumberFormatException ex) {
                System.out.println("Enter a valid integer.");
            }
        }
    }

    public static long readLongAtLeast(Scanner scanner, String prompt, long minInclusive) {
        while (true) {
            System.out.print(prompt);
            String raw = scanner.nextLine().trim();
            try {
                long value = Long.parseLong(raw);
                if (value < minInclusive) {
                    System.out.printf("Enter an integer at least %d.%n", minInclusive);
                    continue;
                }
                return value;
            } catch (NumberFormatException ex) {
                System.out.println("Enter a valid integer.");
            }
        }
    }

    public static double readDoubleInRange(Scanner scanner, String prompt, double min, double max) {
        while (true) {
            System.out.print(prompt);
            String raw = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(raw);
                if (value < min || value > max) {
                    System.out.printf("Enter a number in [%.4f, %.4f].%n", min, max);
                    continue;
                }
                return value;
            } catch (NumberFormatException ex) {
                System.out.println("Enter a valid number.");
            }
        }
    }
}

