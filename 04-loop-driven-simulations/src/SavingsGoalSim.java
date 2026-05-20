import java.util.Scanner;

public class SavingsGoalSim implements Simulation {
    @Override
    public String name() {
        return "Savings Goal";
    }

    @Override
    public void run(Scanner scanner) {
        double starting = Input.readDoubleInRange(scanner, "Starting balance ($), 0..1e9: ", 0.0, 1_000_000_000.0);
        double monthlyDeposit = Input.readDoubleInRange(scanner, "Monthly deposit ($), 0..1e8: ", 0.0, 100_000_000.0);
        double monthlyRate = Input.readDoubleInRange(scanner, "Monthly interest rate (e.g., 0.01 for 1%), 0..0.2: ", 0.0, 0.2);
        double goal = Input.readDoubleInRange(scanner, "Goal balance ($), 0..1e12: ", 0.0, 1_000_000_000_000.0);

        if (goal <= starting) {
            System.out.printf("Already at or above goal (%.2f >= %.2f).%n", starting, goal);
            return;
        }

        int month = 0;
        double balance = starting;

        System.out.println();
        System.out.println("Month | Start        | Deposit      | Interest     | End");
        System.out.println("----- | ------------ | ------------ | ------------ | ------------");

        while (balance < goal) {
            month++;
            double start = balance;
            balance += monthlyDeposit;
            double afterDeposit = balance;
            double interest = balance * monthlyRate;
            balance += interest;

            if (month <= 24 || balance >= goal) {
                System.out.printf(
                        "%5d | %12.2f | %12.2f | %12.2f | %12.2f%n",
                        month,
                        start,
                        (afterDeposit - start),
                        interest,
                        balance
                );
            } else if (month == 25) {
                System.out.println("... (suppressing intermediate months) ...");
            }

            if (month > 2000) {
                System.out.println("Stopping after 2000 months (sanity limit). Try a higher deposit or rate.");
                return;
            }
        }

        System.out.println();
        System.out.printf("Goal reached in %d months. Final balance: $%.2f%n", month, balance);
    }
}

