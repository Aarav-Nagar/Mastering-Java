# Day 20: Defensive Programming

## What This Program Does

This console app reviews workshop registration requests before they can reserve seats in a small training catalog. It validates each request, raises custom exceptions when a rule is broken, and only mutates registry state after the request has been sanitized.

The demo intentionally mixes accepted and rejected requests so the output shows defensive programming in action: blank fields, unsupported tracks, invalid seat counts, and capacity overruns are all rejected with specific feedback.

## How to Compile and Run

From this project folder in PowerShell:

```powershell
javac -d out (Get-ChildItem src -Filter *.java | ForEach-Object { $_.FullName })
java -cp out DefensiveProgrammingApp
```

## Design Notes

- `RegistrationValidator` centralizes input checks and returns a cleaned `RegistrationRequest` so downstream code never has to trust raw values.
- `ValidationException` and its subclasses separate missing-field problems, range violations, and unsupported-track errors into explicit failure types.
- `WorkshopRegistry` makes defensive copies of setup data and refuses to overbook a track, which keeps internal state consistent even when callers pass bad data.
- The program uses immutable request objects to reduce accidental state changes after validation.
