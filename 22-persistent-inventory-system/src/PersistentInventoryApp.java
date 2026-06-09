import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersistentInventoryApp {
    public static void main(String[] args) {
        Path sourcePath = Paths.get("data", "inventory-seed.txt");
        Path snapshotPath = Paths.get("data", "inventory-snapshot.txt");

        InventoryRepository repository = new InventoryRepository(
            sourcePath,
            snapshotPath,
            new InventoryFileParser()
        );

        try {
            InventoryLoadReport loadReport = repository.load();
            InventoryService service = new InventoryService(loadReport.getItems());

            System.out.println("Loaded inventory:");
            for (InventoryItem item : service.getItems()) {
                System.out.println("- " + item);
            }

            System.out.println();
            System.out.println("Parse warnings:");
            if (loadReport.getWarnings().isEmpty()) {
                System.out.println("- none");
            } else {
                for (String warning : loadReport.getWarnings()) {
                    System.out.println("- " + warning);
                }
            }

            service.receiveShipment("B205", 8);
            service.sellUnits("A100", 3);

            try {
                service.sellUnits("B205", 20);
            } catch (InventoryValidationException exception) {
                System.out.println();
                System.out.println("Rejected transaction: " + exception.getMessage());
            }

            InventoryReport report = service.buildReport();
            repository.saveSnapshot(service.getItems());

            System.out.println();
            System.out.println("Inventory report:");
            System.out.println("- total units: " + report.getTotalUnits());
            System.out.println("- total value: $" + String.format("%.2f", report.getTotalValue()));
            System.out.println("- low stock items: " + report.getLowStockItems().size());
            for (InventoryItem item : report.getLowStockItems()) {
                System.out.println("  * " + item.getSku() + " needs attention at " + item.getQuantity() + " units");
            }
            System.out.println("- snapshot saved to: " + snapshotPath);
        } catch (IOException exception) {
            System.out.println("File error: " + exception.getMessage());
        } catch (InventoryValidationException exception) {
            System.out.println("Inventory rule error: " + exception.getMessage());
        }
    }
}
