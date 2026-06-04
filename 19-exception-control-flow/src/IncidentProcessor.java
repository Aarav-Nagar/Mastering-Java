public class IncidentProcessor {
    public void processBatch(IncidentBatch batch) {
        int handled = 0;
        int failed = 0;

        System.out.println("== Incident batch: " + batch.getName() + " ==");

        String[] rawEntries = batch.getRawEntries();
        for (int index = 0; index < rawEntries.length; index++) {
            String rawEntry = rawEntries[index];
            System.out.println();
            System.out.println("Record " + (index + 1) + ": " + rawEntry);

            try {
                IncidentRecord record = parseRecord(rawEntry);
                int loadPerEngineer = estimateLoadPerEngineer(record);
                handled++;
                System.out.println("Accepted " + record.getSeverity().getCode()
                        + " incident '" + record.getTitle() + "' with load "
                        + loadPerEngineer + " minutes per engineer.");
            } catch (NumberFormatException exception) {
                failed++;
                System.out.println("Handled parsing failure.");
                ThrowableReporter.printSummary(exception);
            } catch (IllegalArgumentException exception) {
                failed++;
                System.out.println("Handled validation failure.");
                ThrowableReporter.printSummary(exception);
            } catch (ArithmeticException exception) {
                failed++;
                System.out.println("Handled workload math failure.");
                ThrowableReporter.printSummary(exception);
            } finally {
                System.out.println("Closing record " + (index + 1) + ".");
            }
        }

        System.out.println();
        System.out.println("Batch complete. handled=" + handled + ", failed=" + failed);
    }

    private IncidentRecord parseRecord(String rawEntry) {
        String[] parts = rawEntry.split(",");
        if (parts.length != 4) {
            throw new IllegalArgumentException(
                    "Expected 4 comma-separated fields but found " + parts.length + ".");
        }

        IncidentSeverity severity = IncidentSeverity.fromCode(parts[0].trim());
        String title = parts[1].trim();
        if (title.length() == 0) {
            throw new IllegalArgumentException("Incident title cannot be empty.");
        }

        int ackMinutes = parsePositiveInt(parts[2].trim(), "ack minutes");
        int engineerCount = parseNonNegativeInt(parts[3].trim(), "engineer count");
        return new IncidentRecord(severity, title, ackMinutes, engineerCount);
    }

    private int parsePositiveInt(String text, String label) {
        int value = Integer.parseInt(text);
        if (value <= 0) {
            throw new IllegalArgumentException(label + " must be positive.");
        }
        return value;
    }

    private int parseNonNegativeInt(String text, String label) {
        int value = Integer.parseInt(text);
        if (value < 0) {
            throw new IllegalArgumentException(label + " cannot be negative.");
        }
        return value;
    }

    private int estimateLoadPerEngineer(IncidentRecord record) {
        return record.getAckMinutes() / record.getEngineerCount();
    }
}
