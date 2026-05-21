import java.util.Random;
import java.util.Scanner;

public class GridLabApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[][] matrix = new int[0][0];

        while (true) {
            System.out.println("=== Matrix and Grid Processing (Day 06) ===");
            System.out.println("Current matrix: " + MatrixOps.shapeString(matrix));
            System.out.println();
            System.out.println("1) Create matrix (manual)");
            System.out.println("2) Create matrix (random)");
            System.out.println("3) Analyze (row/col sums, max cell)");
            System.out.println("4) Transpose (copy)");
            System.out.println("5) Rotate 90° clockwise (copy)");
            System.out.println("6) 3x3 neighbor blur (copy)");
            System.out.println("7) Count regions in 0/1 grid");
            System.out.println("0) Exit");
            System.out.println();

            int choice = ConsoleIO.readIntInRange(scanner, "Choose an option: ", 0, 7);
            if (choice == 0) {
                System.out.println("Goodbye.");
                return;
            }

            switch (choice) {
                case 1:
                    matrix = buildManual(scanner);
                    break;
                case 2:
                    matrix = buildRandom(scanner, random);
                    break;
                case 3:
                    analyze(matrix);
                    break;
                case 4:
                    matrix = requireNonEmptyThen(matrix, MatrixOps::transposeCopy, "Transposed");
                    break;
                case 5:
                    matrix = requireNonEmptyThen(matrix, MatrixOps::rotate90ClockwiseCopy, "Rotated");
                    break;
                case 6:
                    matrix = requireNonEmptyThen(matrix, MatrixOps::blur3x3Copy, "Blurred");
                    break;
                case 7:
                    countRegions(scanner, matrix);
                    break;
                default:
                    System.out.println("Unexpected option.");
            }

            System.out.println();
        }
    }

    private static int[][] buildManual(Scanner scanner) {
        int rows = ConsoleIO.readIntInRange(scanner, "Rows: ", 1, 50);
        int cols = ConsoleIO.readIntInRange(scanner, "Cols: ", 1, 50);

        int[][] m = new int[rows][cols];
        System.out.println("Enter " + (rows * cols) + " integers (row-major):");
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                m[r][c] = ConsoleIO.readInt(scanner, "m[" + r + "][" + c + "]: ");
            }
        }
        return m;
    }

    private static int[][] buildRandom(Scanner scanner, Random random) {
        int rows = ConsoleIO.readIntInRange(scanner, "Rows: ", 1, 200);
        int cols = ConsoleIO.readIntInRange(scanner, "Cols: ", 1, 200);
        int lo = ConsoleIO.readInt(scanner, "Min value: ");
        int hi = ConsoleIO.readInt(scanner, "Max value: ");
        if (lo > hi) {
            int tmp = lo;
            lo = hi;
            hi = tmp;
        }

        return MatrixOps.randomMatrix(rows, cols, lo, hi, random);
    }

    private static void analyze(int[][] m) {
        if (!MatrixOps.isRectangularNonEmpty(m)) {
            System.out.println("No rectangular matrix loaded yet. Create one (option 1 or 2).");
            return;
        }

        long[] rowSums = MatrixOps.rowSums(m);
        long[] colSums = MatrixOps.colSums(m);
        Cell max = MatrixOps.maxCell(m);

        System.out.println(MatrixOps.shapeString(m));
        System.out.println("Row sums:");
        for (int i = 0; i < rowSums.length; i++) {
            System.out.println("  row " + i + ": " + rowSums[i]);
        }
        System.out.println("Col sums:");
        for (int i = 0; i < colSums.length; i++) {
            System.out.println("  col " + i + ": " + colSums[i]);
        }
        System.out.println("Max cell: value=" + max.value() + " at (" + max.row() + "," + max.col() + ")");
    }

    private static int[][] requireNonEmptyThen(int[][] m, MatrixTransform transform, String label) {
        if (!MatrixOps.isRectangularNonEmpty(m)) {
            System.out.println("No rectangular matrix loaded yet. Create one (option 1 or 2).");
            return m;
        }
        int[][] out = transform.apply(m);
        System.out.println(label + " matrix ready: " + MatrixOps.shapeString(out));
        return out;
    }

    private static void countRegions(Scanner scanner, int[][] m) {
        if (!MatrixOps.isRectangularNonEmpty(m)) {
            System.out.println("No rectangular matrix loaded yet. Create one (option 1 or 2).");
            return;
        }

        System.out.println("Region counting treats any non-zero cell as 'filled'.");
        boolean diagonal = ConsoleIO.readYesNo(scanner, "Use diagonal adjacency too? (y/n): ");

        int regions = RegionCounter.countRegions(m, diagonal);
        System.out.println("Regions: " + regions);
    }
}

