import java.util.LinkedHashMap;
import java.util.Map;

public class PluginContext {
    private final String environmentName;
    private final Map<String, Integer> counters;

    public PluginContext(String environmentName) {
        if (environmentName == null || environmentName.trim().isEmpty()) {
            throw new IllegalArgumentException("environmentName must not be blank.");
        }
        this.environmentName = environmentName.trim();
        this.counters = new LinkedHashMap<>();
    }

    public String environmentName() {
        return environmentName;
    }

    public void increment(String counterName) {
        Integer current = counters.get(counterName);
        if (current == null) {
            counters.put(counterName, 1);
        } else {
            counters.put(counterName, current + 1);
        }
    }

    public int counterValue(String counterName) {
        Integer value = counters.get(counterName);
        return value == null ? 0 : value;
    }

    public String countersSummary() {
        if (counters.isEmpty()) {
            return "no counters";
        }

        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, Integer> entry : counters.entrySet()) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(entry.getKey()).append("=").append(entry.getValue());
            first = false;
        }
        return sb.toString();
    }
}
