import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class InventoryRepository {
    private final Path sourcePath;
    private final Path snapshotPath;
    private final InventoryFileParser parser;

    public InventoryRepository(Path sourcePath, Path snapshotPath, InventoryFileParser parser) {
        this.sourcePath = sourcePath;
        this.snapshotPath = snapshotPath;
        this.parser = parser;
    }

    public InventoryLoadReport load() throws IOException {
        List<String> lines = Files.readAllLines(sourcePath, StandardCharsets.UTF_8);
        List<InventoryItem> items = new ArrayList<InventoryItem>();
        List<String> warnings = new ArrayList<String>();

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.length() == 0) {
                continue;
            }

            try {
                items.add(parser.parse(line));
            } catch (InventoryValidationException exception) {
                warnings.add("Line " + (i + 1) + ": " + exception.getMessage() + " Source=" + line);
            }
        }

        return new InventoryLoadReport(items, warnings);
    }

    public void saveSnapshot(List<InventoryItem> items) throws IOException {
        if (!Files.exists(snapshotPath.getParent())) {
            Files.createDirectories(snapshotPath.getParent());
        }

        List<String> lines = new ArrayList<String>();
        for (InventoryItem item : items) {
            lines.add(item.toFileLine());
        }

        Files.write(snapshotPath, lines, StandardCharsets.UTF_8);
    }
}
