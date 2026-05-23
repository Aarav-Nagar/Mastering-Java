import java.util.Arrays;

public final class NumericUtils {
    private NumericUtils() {
    }

    public static int clamp(int value, int min, int max) {
        if (min > max) {
            int tmp = min;
            min = max;
            max = tmp;
        }
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    public static double clamp(double value, double min, double max) {
        if (min > max) {
            double tmp = min;
            min = max;
            max = tmp;
        }
        if (value < min) {
            return min;
        }
        if (value > max) {
            return max;
        }
        return value;
    }

    public static long gcd(long a, long b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static long lcm(long a, long b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        return Math.abs(a / gcd(a, b) * b);
    }

    public static double mean(double... values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("mean requires at least one value");
        }
        double sum = 0.0;
        for (double v : values) {
            sum += v;
        }
        return sum / values.length;
    }

    public static double median(double... values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("median requires at least one value");
        }
        double[] copy = Arrays.copyOf(values, values.length);
        Arrays.sort(copy);
        int mid = copy.length / 2;
        if (copy.length % 2 == 1) {
            return copy[mid];
        }
        return (copy[mid - 1] + copy[mid]) / 2.0;
    }

    public static double roundTo(double value, int decimals) {
        if (decimals < 0) {
            throw new IllegalArgumentException("decimals must be >= 0");
        }
        double pow = Math.pow(10, decimals);
        return Math.round(value * pow) / pow;
    }
}

