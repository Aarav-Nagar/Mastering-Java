package lab.util;

import java.util.Random;

public final class ArrayGenerator {
    public enum Pattern {
        RANDOM,
        SORTED,
        REVERSED,
        NEARLY_SORTED;

        public static Pattern parse(String raw) {
            String normalized = raw.trim().toUpperCase().replace('-', '_');
            return Pattern.valueOf(normalized);
        }
    }

    private ArrayGenerator() {}

    public static int[] generate(int size, Pattern pattern, long seed) {
        if (size < 0) {
            throw new IllegalArgumentException("size must be >= 0");
        }

        int[] data = new int[size];
        Random random = new Random(seed);

        switch (pattern) {
            case RANDOM:
                for (int i = 0; i < data.length; i++) {
                    data[i] = random.nextInt(10_000) - 5_000;
                }
                break;
            case SORTED: {
                int v = random.nextInt(20) - 10;
                for (int i = 0; i < data.length; i++) {
                    v += random.nextInt(3);
                    data[i] = v;
                }
                break;
            }
            case REVERSED: {
                int v = random.nextInt(20) - 10;
                for (int i = 0; i < data.length; i++) {
                    v += random.nextInt(3);
                    data[i] = v;
                }
                reverseInPlace(data);
                break;
            }
            case NEARLY_SORTED: {
                int v = random.nextInt(20) - 10;
                for (int i = 0; i < data.length; i++) {
                    v += random.nextInt(3);
                    data[i] = v;
                }
                for (int i = 0; i < Math.min(5, data.length); i++) {
                    int a = random.nextInt(data.length);
                    int b = random.nextInt(data.length);
                    int tmp = data[a];
                    data[a] = data[b];
                    data[b] = tmp;
                }
                break;
            }
            default:
                throw new IllegalStateException("Unknown pattern: " + pattern);
        }

        return data;
    }

    private static void reverseInPlace(int[] data) {
        int i = 0;
        int j = data.length - 1;
        while (i < j) {
            int tmp = data[i];
            data[i] = data[j];
            data[j] = tmp;
            i++;
            j--;
        }
    }
}
