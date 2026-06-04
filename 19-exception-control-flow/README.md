## Day 19 - Exception Control Flow

This project is a console app that simulates triaging a batch of production incidents. Each raw incident line passes through parsing, validation, and workload estimation so the program can show where exceptions start, how they move up the call stack, and how different `catch` blocks can keep the batch running.

### What the program does

- loads one incident batch with both valid and broken records
- parses each record into a structured `IncidentRecord`
- estimates response load per engineer for valid records
- handles malformed input, missing fields, and divide-by-zero failures with separate catch paths
- prints a short stack-trace summary for each handled `Throwable`

### Compile and run

From the `19-exception-control-flow` folder:

```powershell
javac -d out (Get-ChildItem src -Recurse -Filter *.java | ForEach-Object { $_.FullName })
java -cp out ExceptionControlFlowApp
```

### Design notes

- `IncidentProcessor` owns the layered workflow so the call stack is easy to follow from `main` into parsing and workload estimation.
- `ThrowableReporter` keeps exception reporting separate from business logic and shows a few stack frames without dumping the full trace every time.
- `IncidentSeverity` centralizes severity parsing so bad codes fail in one predictable place.
- The app uses standard Java exceptions on purpose. That keeps the focus on control flow, stack traces, and catch ordering before the next project introduces custom exception types.
