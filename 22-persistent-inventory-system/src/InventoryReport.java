import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryReport {
    private final int totalUnits;
    private final double totalValue;
    private final List<InventoryItem> lowStockItems;

    public InventoryReport(int totalUnits, double totalValue, List<InventoryItem> lowStockItems) {
        this.totalUnits = totalUnits;
        this.totalValue = totalValue;
        this.lowStockItems = new ArrayList<InventoryItem>(lowStockItems);
    }

    public int getTotalUnits() {
        return totalUnits;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public List<InventoryItem> getLowStockItems() {
        return Collections.unmodifiableList(lowStockItems);
    }
}
