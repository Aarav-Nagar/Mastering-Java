public class RequestSanitizerPlugin extends Plugin implements TaskPlugin, LifecycleAware {
    public RequestSanitizerPlugin() {
        super("sanitize", "Request Sanitizer");
    }

    @Override
    public String describePurpose() {
        return "Normalizes incoming notes and raises priority when urgent words appear.";
    }

    @Override
    public void onRegistered(PluginContext context) {
        context.increment("registered.sanitizer");
    }

    @Override
    public PluginResult apply(PluginRequest request, PluginContext context) {
        String originalNote = request.note();
        String normalizedNote = originalNote.trim().replaceAll("\\s+", " ");
        boolean changed = !normalizedNote.equals(originalNote);
        request.setNote(normalizedNote);

        String lowercase = normalizedNote.toLowerCase();
        boolean urgent = lowercase.contains("urgent")
                || lowercase.contains("outage")
                || lowercase.contains("blocked");
        if (urgent) {
            request.setUrgentKeywordDetected(true);
            if (request.priority() != WorkPriority.CRITICAL) {
                request.setPriority(request.priority().escalate());
                changed = true;
            }
            context.increment("urgent.requests");
            return new PluginResult(id(), changed,
                    "normalized note and escalated priority to " + request.priority());
        }

        return new PluginResult(id(), changed, "normalized note without urgency changes");
    }
}
