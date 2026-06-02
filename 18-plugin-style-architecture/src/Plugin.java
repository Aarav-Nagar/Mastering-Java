public abstract class Plugin {
    private final String id;
    private final String displayName;
    private boolean enabled;

    protected Plugin(String id, String displayName) {
        this.id = requireText(id, "id");
        this.displayName = requireText(displayName, "displayName");
        this.enabled = true;
    }

    public final String id() {
        return id;
    }

    public final String displayName() {
        return displayName;
    }

    public final boolean isEnabled() {
        return enabled;
    }

    public final void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public final String label() {
        return displayName + " [" + id + "]";
    }

    public abstract String describePurpose();

    protected final String requireText(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " must not be blank.");
        }
        return value.trim();
    }
}
