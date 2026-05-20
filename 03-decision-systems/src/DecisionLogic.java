import java.util.ArrayList;

public final class DecisionLogic {
    private DecisionLogic() {
    }

    public static DecisionResult parkingPermit(int credits, boolean livesOnCampus,
                                               boolean hasDisabilityPlacard, boolean isCarpoolDriver) {
        DecisionResult result = new DecisionResult();

        if (credits < 0) {
            result.setOutcome("Invalid");
            result.addReason("Credits cannot be negative.");
            return result;
        }

        if (hasDisabilityPlacard) {
            result.setOutcome("Accessible Permit");
            result.addReason("Disability placard overrides other criteria.");
            return result;
        }

        boolean isUpperclass = credits >= 60;
        boolean isCommuter = !livesOnCampus;

        if (isUpperclass && isCommuter) {
            result.setOutcome("Standard Permit");
            result.addReason("Upperclass commuter: credits >= 60 and not living on campus.");
        } else if (isUpperclass) {
            result.setOutcome("Resident Permit");
            result.addReason("Upperclass resident: credits >= 60 and living on campus.");
        } else if (isCommuter && isCarpoolDriver) {
            result.setOutcome("Carpool Permit");
            result.addReason("Commuter carpool driver: not living on campus AND driving a carpool.");
        } else if (isCommuter) {
            result.setOutcome("Limited Permit");
            result.addReason("Commuter but not upperclass and not a carpool driver.");
        } else {
            result.setOutcome("No Permit");
            result.addReason("Resident with credits < 60 (newer resident students do not get parking).");
        }

        return result;
    }

    public static DecisionResult tutoringPlan(double lastExamPercent, double homeworkCompletionPercent, int missedClasses) {
        DecisionResult result = new DecisionResult();

        if (lastExamPercent < 0 || lastExamPercent > 100) {
            result.setOutcome("Invalid");
            result.addReason("Exam percent must be between 0 and 100.");
            return result;
        }
        if (homeworkCompletionPercent < 0 || homeworkCompletionPercent > 100) {
            result.setOutcome("Invalid");
            result.addReason("Homework completion must be between 0 and 100.");
            return result;
        }
        if (missedClasses < 0) {
            result.setOutcome("Invalid");
            result.addReason("Missed classes cannot be negative.");
            return result;
        }

        boolean lowExam = lastExamPercent < 70;
        boolean veryLowExam = lastExamPercent < 55;
        boolean lowHomework = homeworkCompletionPercent < 75;
        boolean highAbsences = missedClasses >= 3;

        if (veryLowExam || (lowExam && (lowHomework || highAbsences))) {
            result.setOutcome("Intensive Plan");
            result.addReason("Triggered by very low exam OR low exam with weak habits (homework/attendance).");
            result.addReason("Schedule: 2 tutoring sessions/week + daily 20-minute review.");
        } else if (lowExam || lowHomework || highAbsences) {
            result.setOutcome("Standard Plan");
            result.addReason("At least one risk factor detected (exam/homework/attendance).");
            result.addReason("Schedule: 1 tutoring session/week + targeted practice sets.");
        } else {
            result.setOutcome("Maintain");
            result.addReason("No risk factors detected; keep current study routine.");
        }

        return result;
    }

    public static DecisionResult budgetTier(double budgetDollars, boolean needsGaming, boolean wantsLongBatteryLife) {
        DecisionResult result = new DecisionResult();

        if (budgetDollars < 0) {
            result.setOutcome("Invalid");
            result.addReason("Budget cannot be negative.");
            return result;
        }

        int tier;
        if (budgetDollars < 500) {
            tier = 1;
        } else if (budgetDollars < 900) {
            tier = 2;
        } else if (budgetDollars < 1400) {
            tier = 3;
        } else {
            tier = 4;
        }

        String label;
        switch (tier) {
            case 1:
                label = "Budget";
                break;
            case 2:
                label = "Midrange";
                break;
            case 3:
                label = "Performance";
                break;
            case 4:
                label = "Premium";
                break;
            default:
                label = "Unknown";
        }
        result.setOutcome(label);

        ArrayList<String> notes = new ArrayList<>();
        if (needsGaming && tier < 3) {
            notes.add("Gaming needs often require Performance tier (>= $900) for a stronger GPU.");
        }
        if (wantsLongBatteryLife && tier >= 3) {
            notes.add("High-performance laptops can trade battery life for speed; check wattage and reviews.");
        }
        if (!needsGaming && wantsLongBatteryLife && tier >= 2) {
            notes.add("Prioritize efficiency CPUs and a larger battery over discrete graphics.");
        }
        if (notes.isEmpty()) {
            notes.add("Tier chosen purely from budget bands; adjust for your specific constraints.");
        }

        for (String note : notes) {
            result.addReason(note);
        }

        return result;
    }
}
