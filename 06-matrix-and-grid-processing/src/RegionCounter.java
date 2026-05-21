import java.util.ArrayDeque;

public final class RegionCounter {
    private RegionCounter() {
    }

    public static int countRegions(int[][] grid, boolean diagonal) {
        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] seen = new boolean[rows][cols];
        int regions = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (seen[r][c]) {
                    continue;
                }
                if (grid[r][c] == 0) {
                    seen[r][c] = true;
                    continue;
                }

                regions++;
                floodFill(grid, seen, r, c, diagonal);
            }
        }

        return regions;
    }

    private static void floodFill(int[][] grid, boolean[][] seen, int startR, int startC, boolean diagonal) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[] dr4 = {-1, 1, 0, 0};
        int[] dc4 = {0, 0, -1, 1};
        int[] dr8 = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc8 = {-1, 0, 1, -1, 1, -1, 0, 1};

        ArrayDeque<Cell> stack = new ArrayDeque<>();
        stack.push(new Cell(startR, startC, 1));

        while (!stack.isEmpty()) {
            Cell cur = stack.pop();
            int r = cur.row();
            int c = cur.col();

            if (r < 0 || r >= rows || c < 0 || c >= cols) {
                continue;
            }
            if (seen[r][c]) {
                continue;
            }
            seen[r][c] = true;
            if (grid[r][c] == 0) {
                continue;
            }

            if (diagonal) {
                for (int i = 0; i < 8; i++) {
                    stack.push(new Cell(r + dr8[i], c + dc8[i], 1));
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    stack.push(new Cell(r + dr4[i], c + dc4[i], 1));
                }
            }
        }
    }
}

