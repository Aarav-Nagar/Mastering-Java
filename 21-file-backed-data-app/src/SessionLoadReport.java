import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SessionLoadReport {
    private final List<StudySession> sessions;
    private final List<String> errors;

    public SessionLoadReport(List<StudySession> sessions, List<String> errors) {
        this.sessions = new ArrayList<StudySession>(sessions);
        this.errors = new ArrayList<String>(errors);
    }

    public List<StudySession> getSessions() {
        return Collections.unmodifiableList(sessions);
    }

    public List<String> getErrors() {
        return Collections.unmodifiableList(errors);
    }
}
