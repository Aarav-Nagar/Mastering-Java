package app;

public final class Main {
    public static void main(String[] args) {
        BankAccount.setAnnualInterestRate(0.04);

        BankAccount alice = new BankAccount("Alice");
        BankAccount bob = new BankAccount("Bob");

        alice.deposit(500.00);
        bob.deposit(200.00);

        alice.withdraw(120.25);
        bob.withdraw(50.00);

        System.out.println("Before interest:");
        System.out.println(alice);
        System.out.println(bob);

        alice.applyMonthlyInterest();
        bob.applyMonthlyInterest();

        System.out.println();
        System.out.println("After interest:");
        System.out.println(alice);
        System.out.println(bob);
    }
}

