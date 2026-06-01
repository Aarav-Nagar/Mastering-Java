public interface CompactPrintable {
    default String format() {
        return toString();
    }
}

