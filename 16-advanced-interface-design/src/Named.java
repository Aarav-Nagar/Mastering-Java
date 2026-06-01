public interface Named extends HasId {
    String title();

    default String label() {
        return displayId() + " " + title();
    }
}

