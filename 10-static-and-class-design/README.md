# Day 10 — Static and Class Design

This project practices designing with `static` fields/methods, constants, and small classes that keep their responsibilities clear.

## What it does

Runs a short console demo of a tiny banking model:

- `BankAccount` instances represent individual accounts.
- A class-level account number generator ensures unique IDs.
- A class-level interest rate applies consistently to all accounts.
- Constants define simple domain rules (like minimum deposit).

The demo creates a couple of accounts, performs deposits/withdrawals, and applies monthly interest.

## Compile and run (PowerShell)

From inside this folder:

```powershell
Remove-Item -Recurse -Force out -ErrorAction SilentlyContinue
javac -d out (Get-ChildItem src -Filter *.java | ForEach-Object { $_.FullName })
java -cp out app.Main
```

## Design notes

- **Static state:** `BankAccount` owns the next account number and the shared interest rate because those are class-wide concerns.
- **Constants:** simple “rules of the world” are `public static final` values so they’re easy to find and hard to accidentally change.
- **Testability:** instance methods (`deposit`, `withdraw`, `applyMonthlyInterest`) avoid printing; `Main` is the only place that prints so the model is easy to unit test later.

