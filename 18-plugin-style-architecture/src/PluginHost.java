import java.util.ArrayList;
import java.util.List;

public class PluginHost {
    private final PluginContext context;
    private final List<Plugin> plugins;

    public PluginHost(String environmentName) {
        this.context = new PluginContext(environmentName);
        this.plugins = new ArrayList<>();
    }

    public void register(Plugin plugin) {
        if (plugin == null) {
            throw new IllegalArgumentException("plugin must not be null.");
        }
        plugins.add(plugin);

        if (plugin instanceof LifecycleAware) {
            LifecycleAware lifecycleAware = (LifecycleAware) plugin;
            lifecycleAware.onRegistered(context);
        }
    }

    public void describePlugins() {
        System.out.println("Registered plugins:");
        for (Plugin plugin : plugins) {
            System.out.println("  - " + plugin.label() + ": " + plugin.describePurpose());
        }
    }

    public void processRequests(List<PluginRequest> requests) {
        for (PluginRequest request : requests) {
            System.out.println();
            System.out.println("Processing " + request.id() + "...");

            for (Plugin plugin : plugins) {
                if (!plugin.isEnabled() || !(plugin instanceof TaskPlugin)) {
                    continue;
                }

                TaskPlugin taskPlugin = (TaskPlugin) plugin;
                PluginResult result = taskPlugin.apply(request, context);
                System.out.println("  " + result.formatLine());
            }

            System.out.println("  final snapshot: " + request.snapshot());
        }
    }

    public void printReports() {
        System.out.println();
        System.out.println("Plugin reports:");
        for (Plugin plugin : plugins) {
            if (plugin instanceof ReportPlugin) {
                ReportPlugin reportPlugin = (ReportPlugin) plugin;
                System.out.println("  " + reportPlugin.renderReport());
            }
        }

        System.out.println();
        System.out.println("Host counters: " + context.countersSummary());
    }
}
