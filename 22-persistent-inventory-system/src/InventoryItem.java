public class InventoryItem {
    private final String sku;
    private final String name;
    private int quantity;
    private final int reorderLevel;
    private final double unitCost;

    public InventoryItem(String sku, String name, int quantity, int reorderLevel, double unitCost)
        throws InventoryValidationException {
        if (quantity < 0) {
            throw new InventoryValidationException("Quantity cannot be negative.");
        }
        if (reorderLevel < 0) {
            throw new InventoryValidationException("Reorder level cannot be negative.");
        }
        if (unitCost < 0.0) {
            throw new InventoryValidationException("Unit cost cannot be negative.");
        }

        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
        this.reorderLevel = reorderLevel;
        this.unitCost = unitCost;
    }

    public String getSku() {
        return sku;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void receiveUnits(int units) throws InventoryValidationException {
        if (units <= 0) {
            throw new InventoryValidationException("Received units must be positive.");
        }
        quantity += units;
    }

    public void sellUnits(int units) throws InventoryValidationException {
        if (units <= 0) {
            throw new InventoryValidationException("Sold units must be positive.");
        }
        if (units > quantity) {
            throw new InventoryValidationException(
                "Cannot sell " + units + " units of " + sku + " when only " + quantity + " are available."
            );
        }
        quantity -= units;
    }

    public boolean isLowStock() {
        return quantity <= reorderLevel;
    }

    public double getInventoryValue() {
        return quantity * unitCost;
    }

    public String toFileLine() {
        return sku + "|" + name + "|" + quantity + "|" + reorderLevel + "|" + unitCost;
    }

    @Override
    public String toString() {
        return sku + " - " + name + " (" + quantity + " units, reorder at " + reorderLevel + ")";
    }
}
