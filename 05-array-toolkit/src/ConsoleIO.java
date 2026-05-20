import java.util.Scanner;

public final class ConsoleIO {
    private ConsoleIO() {
    }

    public static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    public static int readIntInRange(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            int v = readInt(scanner, prompt);
            if (v < min || v > max) {
                System.out.println("Enter a number in [" + min + ", " + max + "].");
                continue;
            }
            return v;
        }
    }

    public static int[] readIntArray(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Enter at least one integer (or include spaces between numbers).");
                continue;
            }

            String[] parts = line.split("\\s+");
            int[] out = new int[parts.length];
            boolean ok = true;

            for (int i = 0; i < parts.length; i++) {
                try {
                    out[i] = Integer.parseInt(parts[i]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid integer: '" + parts[i] + "'. Try again.");
                    ok = false;
                    break;
                }
            }

            if (ok) {
                return out;
            }
        }
    }
}

