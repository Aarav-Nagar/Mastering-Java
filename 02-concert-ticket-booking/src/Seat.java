public class Seat {
    private final int rowIndex;
    private final int number;

    public Seat(int rowIndex, int number) {
        this.rowIndex = rowIndex;
        this.number = number;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getNumber() {
        return number;
    }

    public static Seat parse(String text) {
        if (text == null) {
            return null;
        }
        String trimmed = text.trim().toUpperCase();
        if (trimmed.length() < 2) {
            return null;
        }

        char rowLetter = trimmed.charAt(0);
        if (rowLetter < 'A' || rowLetter > 'Z') {
            return null;
        }

        String numberText = trimmed.substring(1);
        int number;
        try {
            number = Integer.parseInt(numberText);
        } catch (NumberFormatException e) {
            return null;
        }

        int rowIndex = (rowLetter - 'A') + 1;
        return new Seat(rowIndex, number);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Seat)) {
            return false;
        }
        Seat that = (Seat) other;
        return rowIndex == that.rowIndex && number == that.number;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + rowIndex;
        result = 31 * result + number;
        return result;
    }

    @Override
    public String toString() {
        char rowLetter = (char) ('A' + (rowIndex - 1));
        return "" + rowLetter + number;
    }
}

