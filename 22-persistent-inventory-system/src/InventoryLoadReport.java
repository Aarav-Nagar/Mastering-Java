import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryLoadReport {
    private final List<InventoryItem> items;
    private final List<String> warnings;

    public InventoryLoadReport(List<InventoryItem> items, List<String> warnings) {
        this.items = new ArrayList<InventoryItem>(items);
        this.warnings = new ArrayList<String>(warnings);
    }

    public List<InventoryItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public List<String> getWarnings() {
        return Collections.unmodifiableList(warnings);
    }
}
