# Day 11 — Inheritance Systems

This project practices building small class hierarchies, using `protected` carefully, and deciding where behavior belongs in a base class vs. subclasses.

## What it does

A tiny console “combat simulator”:

- A base `Character` class defines shared state (name, HP) and shared rules (taking damage, being alive).
- `Fighter`, `Mage`, and `Tank` subclasses implement different attacks.
- A `Battle` orchestrates a short turn-based fight and prints a play-by-play.

## Compile and run (PowerShell)

From inside this folder:

```powershell
Remove-Item -Recurse -Force out -ErrorAction SilentlyContinue
javac -d out (Get-ChildItem src -Recurse -Filter *.java | ForEach-Object { $_.FullName })
java -cp out game.Main
```

## Design notes

- **Shared invariants live in the base class:** HP clamping and “alive/dead” logic are enforced by `Character` so subclasses can’t forget them.
- **`protected` with intent:** subclasses can read `name` for messaging, but external code can’t mutate character state directly.
- **Polymorphism over conditionals:** the `Battle` loop calls `attack(target)` on a `Character` reference; each subclass decides what that means.

