import java.util.Scanner;

public class RandomWalk1DSim implements Simulation {
    @Override
    public String name() {
        return "Random Walk (1D)";
    }

    @Override
    public void run(Scanner scanner) {
        int boundary = Input.readIntInRange(scanner, "Boundary N (stop at +N or -N), 1..10000: ", 1, 10000);
        int maxSteps = Input.readIntInRange(scanner, "Max steps (safety cap), 10..10000000: ", 10, 10_000_000);

        int position = 0;
        int steps = 0;

        System.out.println();
        System.out.printf("Walking until position reaches +%d or -%d%n", boundary, boundary);

        while (true) {
            steps++;
            int step = RandomUtil.nextIntInclusive(0, 1) == 0 ? -1 : 1;
            position += step;

            if (steps <= 25) {
                System.out.printf("Step %d: %+d -> %d%n", steps, step, position);
            } else if (steps == 26) {
                System.out.println("... (suppressing intermediate steps) ...");
            }

            if (position >= boundary || position <= -boundary) {
                break;
            }
            if (steps >= maxSteps) {
                System.out.printf("Hit the step cap (%d) before reaching a boundary.%n", maxSteps);
                return;
            }
        }

        System.out.println();
        System.out.printf("Stopped after %d steps at position %d.%n", steps, position);
    }
}

