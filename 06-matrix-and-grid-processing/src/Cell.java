public final class Cell {
    private final int row;
    private final int col;
    private final int value;

    public Cell(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }

    public int row() {
        return row;
    }

    public int col() {
        return col;
    }

    public int value() {
        return value;
    }
}
