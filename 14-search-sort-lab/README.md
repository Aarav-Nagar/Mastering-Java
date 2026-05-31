# Day 14: Search + Sort Lab

This mini-lab is a small command-line playground for implementing and sanity-checking classic search and sort algorithms.

## What it does

- Generates integer arrays (random, already-sorted, reverse-sorted, nearly-sorted).
- Runs a selected algorithm and verifies the result is sorted.
- Optionally times each run to compare rough performance.

## How to compile and run

From this folder:

```powershell
Remove-Item -Recurse -Force out -ErrorAction SilentlyContinue
javac -d out (Get-ChildItem src -Recurse -Filter *.java | ForEach-Object { $_.FullName })
java -cp out lab.App
```

## Design notes

- Algorithms live in `lab.algorithms.*` and are written as pure functions where possible.
- `lab.util.*` contains small utilities for generating arrays and checking sortedness.
- `lab.App` is intentionally minimal: it wires options together and prints results.

