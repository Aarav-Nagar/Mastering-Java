import java.util.Locale;
import java.util.Scanner;

public final class ConsoleIO {
    private static final Scanner SCANNER = new Scanner(System.in);

    private ConsoleIO() {
    }

    public static String readLine(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine();
    }

    public static int readInt(String prompt) {
        while (true) {
            String raw = readLine(prompt).trim();
            try {
                return Integer.parseInt(raw);
            } catch (NumberFormatException ignored) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    public static double readDouble(String prompt) {
        while (true) {
            String raw = readLine(prompt).trim();
            try {
                return Double.parseDouble(raw);
            } catch (NumberFormatException ignored) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    public static boolean readYesNo(String prompt) {
        while (true) {
            String raw = readLine(prompt).trim().toLowerCase(Locale.ROOT);
            if (raw.equals("y") || raw.equals("yes")) {
                return true;
            }
            if (raw.equals("n") || raw.equals("no")) {
                return false;
            }
            System.out.println("Please type y/n.");
        }
    }
}

