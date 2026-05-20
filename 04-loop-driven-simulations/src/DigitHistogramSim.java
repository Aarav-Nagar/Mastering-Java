import java.util.Scanner;

public class DigitHistogramSim implements Simulation {
    @Override
    public String name() {
        return "Digit Histogram";
    }

    @Override
    public void run(Scanner scanner) {
        System.out.println("Paste a line of text. We'll count digits 0-9.");
        System.out.print("Text: ");
        String text = scanner.nextLine();

        int[] counts = new int[10];
        int totalDigits = 0;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!Character.isDigit(c)) {
                continue;
            }
            counts[c - '0']++;
            totalDigits++;
        }

        System.out.println();
        if (totalDigits == 0) {
            System.out.println("No digits found.");
            return;
        }

        System.out.printf("Total digits: %d%n", totalDigits);
        System.out.println();
        for (int d = 0; d <= 9; d++) {
            System.out.printf("%d | ", d);
            for (int i = 0; i < counts[d]; i++) {
                if (i > 80) {
                    System.out.print("...");
                    break;
                }
                System.out.print("#");
            }
            System.out.printf(" (%d)%n", counts[d]);
        }
    }
}

