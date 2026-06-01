public class Ticket implements Named, Prioritizable, PrettyPrintable, CompactPrintable {
    private final String id;
    private final String title;
    private final Priority priority;
    private final String area;

    private Ticket(String id, String title, Priority priority, String area) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("id must be non-empty");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must be non-empty");
        }
        if (priority == null) {
            throw new IllegalArgumentException("priority must be non-null");
        }
        if (area == null || area.isBlank()) {
            throw new IllegalArgumentException("area must be non-empty");
        }
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.area = area;
    }

    public static Ticket create(String rawId, String title, Priority priority, String area) {
        return new Ticket(HasId.normalizeToId(rawId), title.trim(), priority, area.trim().toLowerCase());
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public String title() {
        return title;
    }

    @Override
    public Priority priority() {
        return priority;
    }

    public String area() {
        return area;
    }

    @Override
    public String format() {
        String compact = CompactPrintable.super.format();
        String pretty = PrettyPrintable.super.format();
        return label() + " (" + area + ", " + priority + ")"
                + (isUrgent() ? " !" : "")
                + " :: " + compact + " / " + pretty;
    }

    @Override
    public String toString() {
        return "Ticket{id='" + id + "', title='" + title + "', priority=" + priority + ", area='" + area + "'}";
    }
}

