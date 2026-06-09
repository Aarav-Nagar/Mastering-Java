# Day 21: File-Backed Data App

## What This Program Does

This console app loads a study log from a delimited text file, parses each record into Java objects, reports malformed lines without crashing the whole run, adds a new session, and writes the updated data back to disk.

The sample dataset intentionally includes a few broken records so the program demonstrates file I/O, parsing, partial recovery, and persistence in one small workflow.

## How to Compile and Run

From this project folder in PowerShell:

```powershell
javac -d out (Get-ChildItem src -Filter *.java | ForEach-Object { $_.FullName })
java -cp out FileBackedDataApp
```

## Design Notes

- `StudyLogRepository` owns file reads and writes so persistence behavior stays separate from reporting logic.
- `StudySessionParser` turns one delimited line into a `StudySession` and throws a checked exception when a line is malformed.
- `SessionLoadReport` preserves both valid sessions and parse warnings, which lets the app continue working with partial data instead of failing the whole load.
- `StudyLogService` handles application-level behavior like adding sessions, producing totals, and filtering longer sessions.
