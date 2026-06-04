public class ExceptionControlFlowApp {
    public static void main(String[] args) {
        IncidentBatch batch = new IncidentBatch(
                "weekday-triage",
                new String[] {
                    "P1,Identity provider outage,18,3",
                    "P2,Payment reconciliation drift,two,2",
                    "P3,Search latency spike,9,0",
                    "P4,Dashboard export failure,7",
                    "P2,Checkout retry storm,12,4"
                }
        );

        IncidentProcessor processor = new IncidentProcessor();

        try {
            processor.processBatch(batch);
        } catch (Throwable throwable) {
            System.out.println("Unexpected top-level failure.");
            ThrowableReporter.printSummary(throwable);
        }
    }
}
