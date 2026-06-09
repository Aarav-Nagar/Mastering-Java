# Day 22: Persistent Inventory System

## What This Program Does

This console application loads warehouse inventory records from a delimited file, validates each line, reports malformed records, applies inventory transactions, and writes an updated inventory snapshot back to disk.

The workflow is built to show a larger file-backed design than Day 21. The app separates parsing, persistence, validation, business rules, and reporting so inventory updates do not get tangled with file I/O.

## How to Compile and Run

From this project folder in PowerShell:

```powershell
javac -d out (Get-ChildItem src -Filter *.java | ForEach-Object { $_.FullName })
java -cp out PersistentInventoryApp
```

## Design Notes

- `InventoryRepository` handles reading seed data and saving the current snapshot.
- `InventoryFileParser` validates one record at a time and throws `InventoryValidationException` for malformed lines.
- `InventoryService` owns stock changes such as restocking and selling units so inventory rules stay in one place.
- `InventoryReport` gathers summary values and low-stock items for a simple management report.
- The program writes to `data/inventory-snapshot.txt` instead of rewriting the seed file, which keeps the demo repeatable.
