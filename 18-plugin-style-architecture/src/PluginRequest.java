public class PluginRequest {
    private final String id;
    private final String owner;
    private final String category;
    private String note;
    private WorkPriority priority;
    private boolean urgentKeywordDetected;
    private String route;
    private int estimatedHours;

    public PluginRequest(String id, String owner, String category, WorkPriority priority, String note) {
        this.id = requireText(id, "id");
        this.owner = requireText(owner, "owner");
        this.category = requireText(category, "category").toLowerCase();
        this.priority = priority == null ? WorkPriority.MEDIUM : priority;
        this.note = requireText(note, "note");
        this.route = "unassigned";
    }

    private static String requireText(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " must not be blank.");
        }
        return value.trim();
    }

    public String id() {
        return id;
    }

    public String owner() {
        return owner;
    }

    public String category() {
        return category;
    }

    public String note() {
        return note;
    }

    public void setNote(String note) {
        this.note = requireText(note, "note");
    }

    public WorkPriority priority() {
        return priority;
    }

    public void setPriority(WorkPriority priority) {
        if (priority == null) {
            throw new IllegalArgumentException("priority must not be null.");
        }
        this.priority = priority;
    }

    public boolean urgentKeywordDetected() {
        return urgentKeywordDetected;
    }

    public void setUrgentKeywordDetected(boolean urgentKeywordDetected) {
        this.urgentKeywordDetected = urgentKeywordDetected;
    }

    public String route() {
        return route;
    }

    public void setRoute(String route) {
        this.route = requireText(route, "route");
    }

    public int estimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(int estimatedHours) {
        if (estimatedHours < 0) {
            throw new IllegalArgumentException("estimatedHours must be non-negative.");
        }
        this.estimatedHours = estimatedHours;
    }

    public String snapshot() {
        return id + " owner=" + owner
                + " category=" + category
                + " priority=" + priority
                + " route=" + route
                + " hours=" + estimatedHours
                + " urgent=" + urgentKeywordDetected
                + " note=\"" + note + "\"";
    }
}
