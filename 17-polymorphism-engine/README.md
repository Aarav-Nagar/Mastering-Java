## Day 17 — Polymorphism Engine

This project is a small console app that exercises polymorphism and dynamic binding through a tiny turn-based combat “engine”.

You’ll see:

- a common base type (`Unit`) with multiple concrete implementations
- dynamic dispatch (`unit.takeTurn(...)`) based on the runtime type
- safe casting with `instanceof` for optional capabilities (mana, rage, etc.)
- type design tradeoffs (what belongs in the base class vs. a capability interface)

### Compile and run

From the `17-polymorphism-engine` folder:

```bash
# compile
javac -d out (Get-ChildItem src -Recurse -Filter *.java | ForEach-Object { $_.FullName })

# run
java -cp out PolymorphismEngineApp
```

### Design notes

- `Unit` owns shared state and invariants (name, hp, alive/dead).
- Optional resources are modeled via small capability interfaces:
  - `HasMana` for mana-based units
  - `HasRage` for rage-based units
- The engine uses the base type (`Unit`) everywhere it can, and only downcasts when a behavior truly depends on a capability.

