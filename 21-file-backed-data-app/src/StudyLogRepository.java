import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class StudyLogRepository {
    private final Path filePath;
    private final StudySessionParser parser;

    public StudyLogRepository(Path filePath, StudySessionParser parser) {
        this.filePath = filePath;
        this.parser = parser;
    }

    public SessionLoadReport load() throws IOException {
        if (!Files.exists(filePath)) {
            Files.createDirectories(filePath.getParent());
            Files.write(filePath, new ArrayList<String>(), StandardCharsets.UTF_8);
        }

        List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
        List<StudySession> sessions = new ArrayList<StudySession>();
        List<String> errors = new ArrayList<String>();

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.length() == 0) {
                continue;
            }

            try {
                sessions.add(parser.parse(line));
            } catch (SessionParseException exception) {
                errors.add("Line " + (i + 1) + ": " + exception.getMessage() + " Source=" + line);
            }
        }

        return new SessionLoadReport(sessions, errors);
    }

    public void save(List<StudySession> sessions) throws IOException {
        List<String> lines = new ArrayList<String>();
        for (StudySession session : sessions) {
            lines.add(session.toFileLine());
        }
        Files.write(filePath, lines, StandardCharsets.UTF_8);
    }
}
