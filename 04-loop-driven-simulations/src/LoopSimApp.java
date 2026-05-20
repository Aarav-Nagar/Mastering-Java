import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoopSimApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Simulation> simulations = new ArrayList<>();
        simulations.add(new StaircaseClimbSim());
        simulations.add(new SavingsGoalSim());
        simulations.add(new RandomWalk1DSim());
        simulations.add(new DigitHistogramSim());
        simulations.add(new MonteCarloPiSim());

        while (true) {
            System.out.println();
            System.out.println("=== Loop-Driven Simulations (Day 04) ===");
            for (int i = 0; i < simulations.size(); i++) {
                System.out.printf("%d) %s%n", i + 1, simulations.get(i).name());
            }
            System.out.println("0) Exit");

            int choice = Input.readIntInRange(scanner, "Choose an option: ", 0, simulations.size());
            if (choice == 0) {
                System.out.println("Goodbye.");
                break;
            }

            System.out.println();
            simulations.get(choice - 1).run(scanner);
            System.out.println();
            System.out.println("(Press Enter to return to menu)");
            scanner.nextLine();
        }
    }
}

