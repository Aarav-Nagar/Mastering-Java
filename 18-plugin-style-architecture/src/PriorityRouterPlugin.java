public class PriorityRouterPlugin extends Plugin implements TaskPlugin, ReportPlugin, LifecycleAware {
    private int platformCount;
    private int supportCount;
    private int rushCount;

    public PriorityRouterPlugin() {
        super("router", "Priority Router");
    }

    @Override
    public String describePurpose() {
        return "Assigns each request to a route based on category and priority.";
    }

    @Override
    public void onRegistered(PluginContext context) {
        context.increment("registered.router");
    }

    @Override
    public PluginResult apply(PluginRequest request, PluginContext context) {
        String route;
        if (request.priority() == WorkPriority.CRITICAL || request.priority() == WorkPriority.HIGH) {
            route = "rush-queue";
            rushCount++;
        } else if ("bug".equals(request.category()) || "infra".equals(request.category())) {
            route = "platform-lane";
            platformCount++;
        } else {
            route = "support-lane";
            supportCount++;
        }

        request.setRoute(route);
        context.increment("routed." + route);
        return new PluginResult(id(), true, "assigned route " + route);
    }

    @Override
    public String renderReport() {
        return label()
                + " report: rush=" + rushCount
                + ", platform=" + platformCount
                + ", support=" + supportCount;
    }
}
