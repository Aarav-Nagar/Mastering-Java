# Day 23: Generics and ArrayList

## What This Program Does

This console application models two ranked backlogs: one for study modules and one for pair-programming opportunities. Both domains run through the same generic collection container and utility methods, which keeps the program focused on reusable `ArrayList` workflows instead of duplicating list logic in each class.

The app prints each backlog in priority order, calculates average priority, identifies the top item, removes duplicate tags while preserving order, and rotates a list view to show how the same helpers can work across different data types.

## How to Compile and Run

From this project folder in PowerShell:

```powershell
javac -d out (Get-ChildItem src -Filter *.java | ForEach-Object { $_.FullName })
java -cp out GenericsArrayListApp
```

## Design Notes

- `ReviewBucket<T extends RankedItem>` is a reusable generic container backed by `ArrayList<T>`.
- `ArrayListWorkbench` contains generic helper methods for copying, de-duplicating, rotating, sorting, and choosing the highest-priority item.
- `StudyModule` and `PairProgrammingMatch` are separate domain models that both implement `RankedItem`, which lets the same generic code operate on each type safely.
- The sorting logic is implemented manually instead of relying on advanced library features so the data-structure practice stays visible in the source.
