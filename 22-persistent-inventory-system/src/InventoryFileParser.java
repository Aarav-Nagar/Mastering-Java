public class InventoryFileParser {
    public InventoryItem parse(String line) throws InventoryValidationException {
        String[] parts = line.split("\\|");
        if (parts.length != 5) {
            throw new InventoryValidationException("Expected 5 fields but found " + parts.length + ".");
        }

        String sku = parts[0].trim();
        String name = parts[1].trim();
        String quantityText = parts[2].trim();
        String reorderText = parts[3].trim();
        String unitCostText = parts[4].trim();

        if (sku.length() == 0 || name.length() == 0) {
            throw new InventoryValidationException("SKU and name are required.");
        }

        int quantity = parseInteger(quantityText, "Quantity");
        int reorderLevel = parseInteger(reorderText, "Reorder level");
        double unitCost = parseDouble(unitCostText, "Unit cost");

        return new InventoryItem(sku, name, quantity, reorderLevel, unitCost);
    }

    private int parseInteger(String value, String label) throws InventoryValidationException {
        try {
            int parsed = Integer.parseInt(value);
            if (parsed < 0) {
                throw new InventoryValidationException(label + " cannot be negative.");
            }
            return parsed;
        } catch (NumberFormatException exception) {
            throw new InventoryValidationException(label + " must be a whole number.");
        }
    }

    private double parseDouble(String value, String label) throws InventoryValidationException {
        try {
            double parsed = Double.parseDouble(value);
            if (parsed < 0.0) {
                throw new InventoryValidationException(label + " cannot be negative.");
            }
            return parsed;
        } catch (NumberFormatException exception) {
            throw new InventoryValidationException(label + " must be numeric.");
        }
    }
}
