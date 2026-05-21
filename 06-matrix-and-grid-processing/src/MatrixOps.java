import java.util.Random;

public final class MatrixOps {
    private MatrixOps() {
    }

    public static String shapeString(int[][] m) {
        if (m == null) {
            return "(null)";
        }
        if (m.length == 0) {
            return "0x0";
        }
        int cols = (m[0] == null) ? 0 : m[0].length;
        return m.length + "x" + cols;
    }

    public static boolean isRectangularNonEmpty(int[][] m) {
        if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
            return false;
        }
        int cols = m[0].length;
        for (int r = 0; r < m.length; r++) {
            if (m[r] == null || m[r].length != cols) {
                return false;
            }
        }
        return true;
    }

    public static int[][] randomMatrix(int rows, int cols, int lo, int hi, Random random) {
        int[][] m = new int[rows][cols];
        int range = hi - lo + 1;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                m[r][c] = lo + random.nextInt(range);
            }
        }
        return m;
    }

    public static long[] rowSums(int[][] m) {
        long[] sums = new long[m.length];
        for (int r = 0; r < m.length; r++) {
            long sum = 0L;
            for (int c = 0; c < m[r].length; c++) {
                sum += m[r][c];
            }
            sums[r] = sum;
        }
        return sums;
    }

    public static long[] colSums(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;
        long[] sums = new long[cols];
        for (int c = 0; c < cols; c++) {
            long sum = 0L;
            for (int r = 0; r < rows; r++) {
                sum += m[r][c];
            }
            sums[c] = sum;
        }
        return sums;
    }

    public static Cell maxCell(int[][] m) {
        int bestR = 0;
        int bestC = 0;
        int bestV = m[0][0];
        for (int r = 0; r < m.length; r++) {
            for (int c = 0; c < m[r].length; c++) {
                int v = m[r][c];
                if (v > bestV) {
                    bestV = v;
                    bestR = r;
                    bestC = c;
                }
            }
        }
        return new Cell(bestR, bestC, bestV);
    }

    public static int[][] transposeCopy(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;
        int[][] out = new int[cols][rows];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                out[c][r] = m[r][c];
            }
        }
        return out;
    }

    public static int[][] rotate90ClockwiseCopy(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;
        int[][] out = new int[cols][rows];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                out[c][rows - 1 - r] = m[r][c];
            }
        }
        return out;
    }

    public static int[][] blur3x3Copy(int[][] m) {
        int rows = m.length;
        int cols = m[0].length;
        int[][] out = new int[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                int sum = 0;
                int count = 0;
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        int rr = r + dr;
                        int cc = c + dc;
                        if (rr < 0 || rr >= rows || cc < 0 || cc >= cols) {
                            continue;
                        }
                        sum += m[rr][cc];
                        count++;
                    }
                }
                out[r][c] = (int) Math.round((double) sum / count);
            }
        }

        return out;
    }
}

