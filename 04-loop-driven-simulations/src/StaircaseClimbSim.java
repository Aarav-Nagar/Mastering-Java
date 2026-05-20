import java.util.Scanner;

public class StaircaseClimbSim implements Simulation {
    @Override
    public String name() {
        return "Staircase Climb";
    }

    @Override
    public void run(Scanner scanner) {
        int targetHeight = Input.readIntInRange(scanner, "Target height (steps), 1..100000: ", 1, 100000);
        int strideMin = Input.readIntInRange(scanner, "Minimum stride per move, 1..1000: ", 1, 1000);
        int strideMax = Input.readIntInRange(scanner, "Maximum stride per move, min..1000: ", strideMin, 1000);

        int height = 0;
        int moves = 0;

        System.out.println();
        System.out.printf("Climbing to %d steps (stride %d..%d)%n", targetHeight, strideMin, strideMax);

        while (height < targetHeight) {
            int stride = RandomUtil.nextIntInclusive(strideMin, strideMax);
            height += stride;
            moves++;

            if (moves <= 20 || height >= targetHeight) {
                System.out.printf("Move %d: +%d -> %d%n", moves, stride, height);
            } else if (moves == 21) {
                System.out.println("... (suppressing intermediate moves) ...");
            }
        }

        System.out.println();
        System.out.printf("Reached the top in %d moves.%n", moves);
    }
}

