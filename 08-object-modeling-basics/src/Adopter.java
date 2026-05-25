public class Adopter {
    private final String name;

    public Adopter(String name) {
        this.name = requireNonBlank(name, "name");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    private static String requireNonBlank(String value, String fieldName) {
        if (value == null) {
            throw new IllegalArgumentException(fieldName + " cannot be null.");
        }
        String trimmed = value.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be blank.");
        }
        return trimmed;
    }
}

