# Day 15: Algorithm Analysis Lab

This project explores algorithmic tradeoffs with a simple timing harness.

## What it does

- Generates arrays with different input patterns and sizes.
- Runs several algorithms and collects timing statistics.
- Prints a compact summary so you can compare growth trends.

## How to compile and run

From this folder:

```powershell
Remove-Item -Recurse -Force out -ErrorAction SilentlyContinue
javac -d out (Get-ChildItem src -Recurse -Filter *.java | ForEach-Object { $_.FullName })
java -cp out lab.App
```

Optional flags:

- `--minSize 100`
- `--maxSize 5000`
- `--step 200`
- `--trials 5`
- `--pattern RANDOM|SORTED|REVERSED|NEARLY_SORTED`

## Design notes

- The `Benchmark` class separates data generation from the thing being measured.
- Each algorithm is exposed through a small `IntArrayAlgorithm` interface so the harness stays generic.
- Output focuses on medians to reduce noise from one-off slow runs.

