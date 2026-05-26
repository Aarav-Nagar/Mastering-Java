package app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class BankAccount {
    public static final BigDecimal MIN_DEPOSIT = new BigDecimal("0.01");
    public static final BigDecimal MIN_WITHDRAWAL = new BigDecimal("0.01");

    private static int nextAccountNumber = 1000;
    private static BigDecimal annualInterestRate = new BigDecimal("0.00");

    private final int accountNumber;
    private final String ownerName;
    private BigDecimal balance;

    public BankAccount(String ownerName) {
        this.ownerName = requireNonBlank(ownerName, "ownerName");
        this.accountNumber = nextAccountNumber++;
        this.balance = new BigDecimal("0.00");
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public static BigDecimal getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static void setAnnualInterestRate(double rate) {
        if (rate < 0.0) {
            throw new IllegalArgumentException("rate must be non-negative");
        }
        annualInterestRate = new BigDecimal(Double.toString(rate));
    }

    public void deposit(double amount) {
        BigDecimal depositAmount = money(amount);
        if (depositAmount.compareTo(MIN_DEPOSIT) < 0) {
            throw new IllegalArgumentException("deposit must be at least " + MIN_DEPOSIT);
        }
        balance = balance.add(depositAmount);
    }

    public void withdraw(double amount) {
        BigDecimal withdrawalAmount = money(amount);
        if (withdrawalAmount.compareTo(MIN_WITHDRAWAL) < 0) {
            throw new IllegalArgumentException("withdrawal must be at least " + MIN_WITHDRAWAL);
        }
        if (withdrawalAmount.compareTo(balance) > 0) {
            throw new IllegalArgumentException("insufficient funds");
        }
        balance = balance.subtract(withdrawalAmount);
    }

    public void applyMonthlyInterest() {
        BigDecimal monthlyRate = annualInterestRate.divide(new BigDecimal("12"), 12, RoundingMode.HALF_UP);
        BigDecimal interest = balance.multiply(monthlyRate);
        balance = balance.add(interest).setScale(2, RoundingMode.HALF_UP);
    }

    @Override
    public String toString() {
        return String.format(
                "Account #%d (%s) — balance: $%s, APR: %s",
                accountNumber,
                ownerName,
                balance.setScale(2, RoundingMode.HALF_UP),
                annualInterestRate
        );
    }

    private static BigDecimal money(double amount) {
        if (Double.isNaN(amount) || Double.isInfinite(amount)) {
            throw new IllegalArgumentException("amount must be a finite number");
        }
        if (amount < 0.0) {
            throw new IllegalArgumentException("amount must be non-negative");
        }
        return new BigDecimal(Double.toString(amount)).setScale(2, RoundingMode.HALF_UP);
    }

    private static String requireNonBlank(String value, String name) {
        Objects.requireNonNull(value, name + " must not be null");
        String trimmed = value.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException(name + " must not be blank");
        }
        return trimmed;
    }
}

