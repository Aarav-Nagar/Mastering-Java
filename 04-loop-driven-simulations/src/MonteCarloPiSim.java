import java.util.Scanner;

public class MonteCarloPiSim implements Simulation {
    @Override
    public String name() {
        return "Pi Approximation (Monte Carlo)";
    }

    @Override
    public void run(Scanner scanner) {
        long trials = Input.readLongAtLeast(scanner, "Trials (>= 1000 recommended): ", 1);
        long reportEvery = Input.readLongAtLeast(scanner, "Report every N trials (e.g., 10000): ", 1);

        long inside = 0;
        for (long i = 1; i <= trials; i++) {
            double x = RandomUtil.nextDouble();
            double y = RandomUtil.nextDouble();
            if ((x * x + y * y) <= 1.0) {
                inside++;
            }

            if (i % reportEvery == 0 || i == trials) {
                double piEstimate = 4.0 * ((double) inside / (double) i);
                System.out.printf("Trials: %d | inside: %d | pi ~= %.6f%n", i, inside, piEstimate);
            }
        }
    }
}

