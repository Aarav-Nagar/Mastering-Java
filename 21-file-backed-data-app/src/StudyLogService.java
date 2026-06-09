import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudyLogService {
    private final List<StudySession> sessions;

    public StudyLogService(List<StudySession> sessions) {
        this.sessions = new ArrayList<StudySession>(sessions);
    }

    public void addSession(StudySession session) {
        sessions.add(session);
    }

    public List<StudySession> getSessions() {
        return Collections.unmodifiableList(sessions);
    }

    public SessionSummary summarize() {
        int totalMinutes = 0;
        int focusedMinutes = 0;

        for (StudySession session : sessions) {
            totalMinutes += session.getMinutes();
            if (session.isFocused()) {
                focusedMinutes += session.getMinutes();
            }
        }

        return new SessionSummary(sessions.size(), 0, totalMinutes, focusedMinutes);
    }

    public List<StudySession> findLongSessions(int minimumMinutes) {
        List<StudySession> matches = new ArrayList<StudySession>();
        for (StudySession session : sessions) {
            if (session.getMinutes() >= minimumMinutes) {
                matches.add(session);
            }
        }
        return matches;
    }
}
