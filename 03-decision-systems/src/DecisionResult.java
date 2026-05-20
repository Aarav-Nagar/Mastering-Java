import java.util.ArrayList;
import java.util.List;

public final class DecisionResult {
    private String outcome;
    private final ArrayList<String> reasons;

    public DecisionResult() {
        this.outcome = "";
        this.reasons = new ArrayList<>();
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome == null ? "" : outcome;
    }

    public void addReason(String reason) {
        if (reason != null && !reason.isBlank()) {
            reasons.add(reason);
        }
    }

    public List<String> getReasons() {
        return List.copyOf(reasons);
    }
}

