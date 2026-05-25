import java.util.Locale;
import java.util.Scanner;

public class ConsoleIO {
    public static String readNonBlank(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            if (line != null && !line.trim().isEmpty()) {
                return line.trim();
            }
            System.out.println("Please enter a non-blank value.");
        }
    }

    public static int readInt(Scanner scanner, String prompt, int minInclusive, int maxInclusive) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            try {
                int value = Integer.parseInt(line.trim());
                if (value < minInclusive || value > maxInclusive) {
                    System.out.println("Enter a number between " + minInclusive + " and " + maxInclusive + ".");
                    continue;
                }
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Enter a valid integer.");
            }
        }
    }

    public static Species readSpecies(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String raw = scanner.nextLine();
            if (raw == null) {
                System.out.println("Please enter a value.");
                continue;
            }
            String s = raw.trim().toLowerCase(Locale.ROOT);
            if (s.isEmpty()) {
                System.out.println("Please enter a value.");
                continue;
            }
            switch (s) {
                case "dog":
                    return Species.DOG;
                case "cat":
                    return Species.CAT;
                case "rabbit":
                    return Species.RABBIT;
                default:
                    return Species.OTHER;
            }
        }
    }
}
