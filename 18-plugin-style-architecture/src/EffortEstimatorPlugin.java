public class EffortEstimatorPlugin extends Plugin implements TaskPlugin, ReportPlugin {
    private int totalEstimatedHours;
    private int processedRequests;

    public EffortEstimatorPlugin() {
        super("estimate", "Effort Estimator");
    }

    @Override
    public String describePurpose() {
        return "Converts a request snapshot into a rough effort estimate for triage.";
    }

    @Override
    public PluginResult apply(PluginRequest request, PluginContext context) {
        int hours = 1;
        if (request.priority() == WorkPriority.MEDIUM) {
            hours += 1;
        } else if (request.priority() == WorkPriority.HIGH) {
            hours += 2;
        } else if (request.priority() == WorkPriority.CRITICAL) {
            hours += 4;
        }

        if (request.note().length() > 60) {
            hours += 1;
        }
        if ("platform-lane".equals(request.route())) {
            hours += 1;
        }
        if (request.urgentKeywordDetected()) {
            hours += 1;
        }

        request.setEstimatedHours(hours);
        totalEstimatedHours += hours;
        processedRequests++;
        context.increment("estimated.requests");
        return new PluginResult(id(), true, "estimated " + hours + " hour(s)");
    }

    @Override
    public String renderReport() {
        if (processedRequests == 0) {
            return label() + " report: no requests processed";
        }
        double average = (double) totalEstimatedHours / processedRequests;
        return label()
                + " report: totalHours=" + totalEstimatedHours
                + ", averageHours=" + String.format("%.1f", average);
    }
}
