public interface Prioritizable extends HasId {
    Priority priority();

    default boolean isUrgent() {
        return priority() == Priority.HIGH;
    }
}

