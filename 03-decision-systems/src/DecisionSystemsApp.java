public class DecisionSystemsApp {
    public static void main(String[] args) {
        System.out.println("Decision Systems");
        System.out.println("----------------");

        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("Choose a system:");
            System.out.println("1) Parking Permit Selector");
            System.out.println("2) Tutoring Plan Advisor");
            System.out.println("3) Budget Tier Helper");
            System.out.println("0) Exit");

            int choice = Input.readInt("Enter choice: ");

            switch (choice) {
                case 1:
                    runParkingPermit();
                    break;
                case 2:
                    runTutoringPlan();
                    break;
                case 3:
                    runBudgetTier();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Unknown choice. Try again.");
            }
        }

        System.out.println("Goodbye.");
        Input.close();
    }

    private static void runParkingPermit() {
        System.out.println();
        System.out.println("Parking Permit Selector");

        int credits = Input.readInt("Credits earned: ");
        boolean livesOnCampus = Input.readYesNo("Lives on campus (y/n)? ");
        boolean disabilityPlacard = Input.readYesNo("Has disability placard (y/n)? ");
        boolean carpoolDriver = Input.readYesNo("Carpool driver (y/n)? ");

        DecisionResult result = DecisionLogic.parkingPermit(credits, livesOnCampus, disabilityPlacard, carpoolDriver);
        printResult(result);
    }

    private static void runTutoringPlan() {
        System.out.println();
        System.out.println("Tutoring Plan Advisor");

        double exam = Input.readDouble("Last exam percent (0-100): ");
        double homework = Input.readDouble("Homework completion percent (0-100): ");
        int missed = Input.readInt("Missed classes (0+): ");

        DecisionResult result = DecisionLogic.tutoringPlan(exam, homework, missed);
        printResult(result);
    }

    private static void runBudgetTier() {
        System.out.println();
        System.out.println("Budget Tier Helper");

        double budget = Input.readDouble("Budget in dollars: ");
        boolean gaming = Input.readYesNo("Needs gaming performance (y/n)? ");
        boolean battery = Input.readYesNo("Wants long battery life (y/n)? ");

        DecisionResult result = DecisionLogic.budgetTier(budget, gaming, battery);
        printResult(result);
    }

    private static void printResult(DecisionResult result) {
        System.out.println();
        System.out.println("Outcome: " + result.getOutcome());
        for (String reason : result.getReasons()) {
            System.out.println("- " + reason);
        }
    }
}
