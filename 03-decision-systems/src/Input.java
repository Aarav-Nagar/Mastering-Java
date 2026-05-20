import java.util.Locale;
import java.util.Scanner;

public final class Input {
    private static final Scanner SCANNER = new Scanner(System.in);

    private Input() {
    }

    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = SCANNER.nextLine().trim();
            try {
                return Integer.parseInt(raw);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a whole number.");
            }
        }
    }

    public static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = SCANNER.nextLine().trim();
            try {
                return Double.parseDouble(raw);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

    public static boolean readYesNo(String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = SCANNER.nextLine().trim().toLowerCase(Locale.ROOT);
            if (raw.equals("y") || raw.equals("yes")) {
                return true;
            }
            if (raw.equals("n") || raw.equals("no")) {
                return false;
            }
            System.out.println("Please answer y/n.");
        }
    }

    public static void close() {
        SCANNER.close();
    }
}

