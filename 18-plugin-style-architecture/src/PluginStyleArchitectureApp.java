import java.util.ArrayList;
import java.util.List;

public class PluginStyleArchitectureApp {
    public static void main(String[] args) {
        PluginHost host = new PluginHost("weekday-intake");
        host.register(new RequestSanitizerPlugin());
        host.register(new PriorityRouterPlugin());
        host.register(new EffortEstimatorPlugin());

        host.describePlugins();

        List<PluginRequest> requests = new ArrayList<>();
        requests.add(new PluginRequest(
                "REQ-201",
                "Ava",
                "bug",
                WorkPriority.MEDIUM,
                "  Checkout outage on mobile web. urgent customer escalation.  "));
        requests.add(new PluginRequest(
                "REQ-202",
                "Mateo",
                "content",
                WorkPriority.LOW,
                "Need a cleaner onboarding headline for the free trial banner."));
        requests.add(new PluginRequest(
                "REQ-203",
                "Nia",
                "infra",
                WorkPriority.MEDIUM,
                "Blocked deploy pipeline after secrets rotation."));

        System.out.println();
        System.out.println("== Plugin host run ==");
        host.processRequests(requests);
        host.printReports();
    }
}
