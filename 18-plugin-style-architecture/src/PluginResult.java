public class PluginResult {
    private final String pluginId;
    private final boolean changedRequest;
    private final String summary;

    public PluginResult(String pluginId, boolean changedRequest, String summary) {
        if (pluginId == null || pluginId.trim().isEmpty()) {
            throw new IllegalArgumentException("pluginId must not be blank.");
        }
        if (summary == null || summary.trim().isEmpty()) {
            throw new IllegalArgumentException("summary must not be blank.");
        }
        this.pluginId = pluginId.trim();
        this.changedRequest = changedRequest;
        this.summary = summary.trim();
    }

    public String pluginId() {
        return pluginId;
    }

    public boolean changedRequest() {
        return changedRequest;
    }

    public String summary() {
        return summary;
    }

    public String formatLine() {
        String marker = changedRequest ? "updated" : "observed";
        return pluginId + ": " + marker + " - " + summary;
    }
}
