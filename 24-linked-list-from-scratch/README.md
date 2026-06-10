# Day 24: Linked List From Scratch

## What This Program Does

This console application builds a study plan on top of a hand-made singly linked list instead of using Java collection classes for the main storage. The program adds checkpoints to the front and back of the list, inserts one in the middle, removes an item by index, searches for a checkpoint title, and prints a small summary report.

The point is to keep the node-level behavior visible. Each operation walks pointers directly so the project demonstrates traversal, insertion, removal, and boundary handling in a concrete way.

## How to Compile and Run

From this project folder in PowerShell:

```powershell
javac -d out (Get-ChildItem src -Filter *.java | ForEach-Object { $_.FullName })
java -cp out LinkedListPlannerApp
```

## Design Notes

- `StudyPlanLinkedList` owns the custom node structure and all pointer updates for add, insert, get, search, and remove operations.
- `StudyPlanService` sets up a realistic sequence of checkpoints so the app exercises front insertion, middle insertion, traversal, and deletion in one run.
- `StudyPlanReport` gathers summary values without mixing reporting logic into the linked-list internals.
- `snapshot()` returns an `ArrayList` view when an outside consumer needs a simple copy, while the actual storage remains a manual linked list.
