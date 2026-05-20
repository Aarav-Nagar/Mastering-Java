# Day 04 — Loop-Driven Simulations

This project is a set of small simulation-style programs that are intentionally loop-heavy. The goal is to get comfortable writing programs where:

- a "state" is updated step-by-step inside a loop
- you stop based on a condition (not a fixed number of iterations)
- nested loops are used for tables and repeated trials
- `break` / `continue` are used deliberately (not as a crutch)

## What You Can Run

From this folder:

```bash
javac -d out src/*.java
java -cp out LoopSimApp
```

Inside the app:

1) **Staircase Climb** — how many steps until you reach a target height  
2) **Savings Goal** — month-by-month balance growth until a goal is reached  
3) **Random Walk (1D)** — walk until you hit +N or -N, track steps  
4) **Digit Histogram** — scan input text and build a frequency bar chart  
5) **Pi Approximation (Monte Carlo)** — estimate π using repeated trials  

## Design Notes

- Each simulation is implemented as a small class with a `run(...)` method.
- Input parsing is defensive: invalid values are re-prompted without crashing.
- Output is intentionally "text UI": later days will use stronger object modeling and then JavaFX (no Swing).

