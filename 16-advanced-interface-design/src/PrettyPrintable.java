public interface PrettyPrintable {
    default String format() {
        return toString();
    }

    static String box(Object value) {
        String s = String.valueOf(value);
        String line = "+-" + "-".repeat(s.length()) + "-+";
        return line + System.lineSeparator()
                + "| " + s + " |" + System.lineSeparator()
                + line;
    }
}

