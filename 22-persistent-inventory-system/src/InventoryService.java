import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InventoryService {
    private final List<InventoryItem> items;

    public InventoryService(List<InventoryItem> items) {
        this.items = new ArrayList<InventoryItem>(items);
    }

    public List<InventoryItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void receiveShipment(String sku, int units) throws InventoryValidationException {
        InventoryItem item = findBySku(sku);
        item.receiveUnits(units);
    }

    public void sellUnits(String sku, int units) throws InventoryValidationException {
        InventoryItem item = findBySku(sku);
        item.sellUnits(units);
    }

    public InventoryReport buildReport() {
        int totalUnits = 0;
        double totalValue = 0.0;
        List<InventoryItem> lowStockItems = new ArrayList<InventoryItem>();

        for (InventoryItem item : items) {
            totalUnits += item.getQuantity();
            totalValue += item.getInventoryValue();

            if (item.isLowStock()) {
                lowStockItems.add(item);
            }
        }

        return new InventoryReport(totalUnits, totalValue, lowStockItems);
    }

    private InventoryItem findBySku(String sku) throws InventoryValidationException {
        for (InventoryItem item : items) {
            if (item.getSku().equalsIgnoreCase(sku)) {
                return item;
            }
        }
        throw new InventoryValidationException("Unknown SKU: " + sku);
    }
}
