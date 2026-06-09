import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileBackedDataApp {
    public static void main(String[] args) {
        Path dataPath = Paths.get("data", "study-log.txt");
        StudyLogRepository repository = new StudyLogRepository(dataPath, new StudySessionParser());

        try {
            SessionLoadReport loadReport = repository.load();
            StudyLogService service = new StudyLogService(loadReport.getSessions());

            System.out.println("Loaded sessions:");
            for (StudySession session : service.getSessions()) {
                System.out.println("- " + session);
            }

            System.out.println();
            System.out.println("Parse warnings:");
            if (loadReport.getErrors().isEmpty()) {
                System.out.println("- none");
            } else {
                for (String error : loadReport.getErrors()) {
                    System.out.println("- " + error);
                }
            }

            StudySession newSession = new StudySession("2026-06-08", "Repository persistence pass", 75, true);
            service.addSession(newSession);
            repository.save(service.getSessions());

            SessionSummary summary = service.summarize();
            System.out.println();
            System.out.println("Updated summary:");
            System.out.println("- sessions saved: " + summary.getLoadedCount());
            System.out.println("- total minutes: " + summary.getTotalMinutes());
            System.out.println("- focused minutes: " + summary.getFocusedMinutes());

            List<StudySession> longSessions = service.findLongSessions(60);
            System.out.println("- sessions >= 60 min: " + longSessions.size());
        } catch (IOException exception) {
            System.out.println("File error: " + exception.getMessage());
        }
    }
}
