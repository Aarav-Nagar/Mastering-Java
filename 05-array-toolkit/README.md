# Day 05 - Array Toolkit

This project is a console "array lab" that practices core array operations in a reusable, testable way.

The goal is to get comfortable with:

- building arrays from user input
- searching (linear + binary) and understanding preconditions
- common transformations (reverse, rotate, clamp)
- small, focused utility methods that don't mutate unless documented

## How to Run

From this folder:

```bash
javac -d out src/*.java
java -cp out ArrayToolkitApp
```

## Features

Inside the menu you can:

1) Build / replace the working array
2) Print basic stats (min, max, sum, average)
3) Reverse the array (copy, non-mutating)
4) Rotate left/right by k (copy, non-mutating)
5) Linear search for a value
6) Sort a copy + binary search (requires sorted array)
7) Clamp values into [lo, hi] (copy, non-mutating)

## Design Notes

- Input handling is defensive: the program re-prompts rather than crashing on invalid values.
- Array utilities are pure where practical (return new arrays rather than mutating inputs).
- Later days build on this by introducing stronger object models, generics, exceptions, file-backed data, and JavaFX.

