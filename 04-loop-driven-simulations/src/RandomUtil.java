import java.util.Random;

public final class RandomUtil {
    private static final Random RNG = new Random();

    private RandomUtil() {}

    public static int nextIntInclusive(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("min > max");
        }
        return min + RNG.nextInt((max - min) + 1);
    }

    public static double nextDouble() {
        return RNG.nextDouble();
    }
}

