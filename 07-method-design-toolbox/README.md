# Day 07 - Method Design Toolbox

This project is a console "toolbox" app: a menu-driven runner that calls small, focused utility methods.

The goal is not to build one huge feature — it's to practice writing methods that are:

- single-purpose
- easy to test in isolation
- reusable across different inputs
- consistent in naming, parameters, and return values

This day also emphasizes method overloading, varargs, and defensive input handling.

## How to Run

From this folder:

```bash
javac -d out src/*.java
java -cp out ToolboxApp
```

## What You Can Do

The menu lets you run small demos like:

- numeric clamps and rounding
- `gcd` / `lcm`
- mean/median calculations
- string cleanup + occurrence counting
- array reversal + rotation

## Design Notes

- Methods avoid mutating inputs unless the name clearly implies mutation.
- Overloads are used when the behavior is conceptually the same but the inputs differ.
- The app is intentionally simple so the focus stays on method design quality.
