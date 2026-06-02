## Day 18 - Plugin-Style Architecture

This project is a console app that models a tiny plugin host for incoming work requests. The host registers multiple plugins, runs them in sequence, and lets each plugin contribute one focused behavior such as request cleanup, routing, or effort estimation.

The goal is to practice a plugin-style design where an abstract base class holds shared plugin state while small interfaces describe optional capabilities.

### What the program does

- registers plugins in a central `PluginHost`
- processes a few sample requests through each task-oriented plugin
- updates each request as plugins add routing and estimate data
- prints per-plugin reports plus host-level counters at the end

### Compile and run

From the `18-plugin-style-architecture` folder:

```powershell
javac -d out (Get-ChildItem src -Recurse -Filter *.java | ForEach-Object { $_.FullName })
java -cp out PluginStyleArchitectureApp
```

### Design notes

- `Plugin` is the shared abstract base type. It stores identity, display metadata, and enabled state so concrete plugins do not repeat that plumbing.
- `TaskPlugin`, `ReportPlugin`, and `LifecycleAware` are small capability interfaces. A plugin can opt into one or more behaviors without forcing every plugin to implement the same methods.
- `PluginHost` works against the abstract base type for registration, then checks interface capabilities when it needs to run task logic or render reports.
- `PluginRequest` is intentionally mutable because the host runs a pipeline and each plugin may add more structure to the same request snapshot.
- The app stays console-based and small, but the design mirrors how a larger host could keep adding plugins without rewriting the core orchestration code.
