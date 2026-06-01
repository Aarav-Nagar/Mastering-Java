public interface HasId {
    String ID_PREFIX = "T-";

    String id();

    static boolean isValidRawId(String raw) {
        if (raw == null) {
            return false;
        }
        String trimmed = raw.trim();
        if (trimmed.isEmpty()) {
            return false;
        }
        for (int i = 0; i < trimmed.length(); i++) {
            char c = trimmed.charAt(i);
            boolean ok = Character.isLetterOrDigit(c) || c == '-' || c == '_';
            if (!ok) {
                return false;
            }
        }
        return true;
    }

    static String normalizeToId(String raw) {
        if (!isValidRawId(raw)) {
            throw new IllegalArgumentException("Invalid id: " + raw);
        }
        String trimmed = raw.trim();
        if (trimmed.startsWith(ID_PREFIX)) {
            return trimmed;
        }
        return ID_PREFIX + trimmed;
    }

    default String displayId() {
        return "[" + id() + "]";
    }
}

