## Day 16 — Advanced Interface Design

This project is a small console app that demonstrates practical interface design patterns in Java:

- interface hierarchies (`extends`)
- interface constants (and when to use them)
- `default` methods (including resolving conflicts)
- `static` interface methods (validation + small factories)

The app models a tiny ticket tracker with a couple of different formatting strategies.

### Compile and run

From the `16-advanced-interface-design` folder:

```bash
# compile
javac -d out (Get-ChildItem src -Recurse -Filter *.java | ForEach-Object { $_.FullName })

# run
java -cp out InterfaceDesignApp
```

### Design notes

- `HasId` is the base interface. It includes:
  - a constant `ID_PREFIX` to keep IDs consistent across the system
  - a `static` method to validate raw IDs
  - a `default` method that provides a useful behavior for all implementers
- `Named` and `Prioritizable` extend `HasId` to build a small interface hierarchy.
- `PrettyPrintable` and `CompactPrintable` intentionally have the same default method signature (`format()`).
  - `Ticket` implements both, so it must resolve the default-method conflict by overriding `format()`.
- `Ticket` remains a normal class; interfaces provide shared behavior contracts and sensible defaults,
  but the state and invariants live in the class.

