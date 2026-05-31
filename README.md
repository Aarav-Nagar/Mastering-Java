# Mastering Java

This is my 30-day Java mastery track. The point is to build real, small projects that move from core Java syntax into stronger object-oriented design, algorithms, generics, exceptions, file-backed programs, custom data structures, recursion, and JavaFX.

This is not a dump of course assignments. Each folder is an original practice project with its own README and source files.

## Progress

| Day | Folder | Focus | Status |
| ---: | --- | --- | --- |
| 1 | `01-gradebook-gpa-calculator` | Java foundations, input, conditionals, lists, basic class design | Added |
| 2 | `02-concert-ticket-booking` | OOP composition, collections, validation, menu-driven app state | Added |
| 3 | `03-decision-systems` | Conditionals, switch, logical operators, reusable decision logic | Added |
| 4 | `04-loop-driven-simulations` | loops, nested loops, break/continue, simulation-style programs | Added |
| 5 | `05-array-toolkit` | arrays, searching, wrapper classes, command-line arguments | Added |
| 6 | `06-matrix-and-grid-processing` | 2D arrays, ragged arrays, grid/matrix processing | Added |
| 7 | `07-method-design-toolbox` | method decomposition, overloading, reusable utilities | Added |
| 8 | `08-object-modeling-basics` | classes, objects, fields, constructors, access control | Added |
| 9 | `09-encapsulation-and-object-state` | getters, setters, `this`, constructor chaining, `toString` | Added |
| 10 | `10-static-and-class-design` | `static`, constants, class-level state, object testing | Added |
| 11 | `11-inheritance-systems` | inheritance, `protected`, `final`, class hierarchies | Added |
| 12 | `12-abstract-classes-and-equality` | abstract classes, overriding `equals`, `Object` methods | Added |
| 13 | `13-interfaces-and-comparable` | interfaces, `Comparable`, `Arrays.sort`, generic comparison | Added |
| 14 | `14-search-sort-lab` | selection sort, insertion sort, merge sort, linear/binary search | Added |
| 15 | `15-algorithm-analysis-lab` | Big-O, growth rates, empirical timing, algorithm tradeoffs | Added |
| 16 | `16-advanced-interface-design` | default/static interface methods, constants, interface hierarchies | Next |
| 17 | `17-polymorphism-engine` | polymorphism, dynamic binding, safe casting, type design | Planned |
| 18 | `18-plugin-style-architecture` | abstract classes + interfaces in a plugin-style mini-project | Planned |
| 19 | `19-exception-control-flow` | call stack, `Throwable`, try/catch, multiple catch blocks | Planned |
| 20 | `20-defensive-programming` | custom exceptions, validation, defensive programming | Planned |
| 21 | `21-file-backed-data-app` | file I/O, delimited files, parsing, persistence | Planned |
| 22 | `22-persistent-inventory-system` | larger file-backed app with custom exceptions and reports | Planned |
| 23 | `23-generics-and-arraylist` | generics, `ArrayList`, reusable collection utilities | Planned |
| 24 | `24-linked-list-from-scratch` | nodes, traversal, insert/remove, linked-list internals | Planned |
| 25 | `25-generic-linked-list-library` | generic linked list with iterator-style behavior | Planned |
| 26 | `26-recursion-foundations` | recursion, base cases, call stack, recursive math/string methods | Planned |
| 27 | `27-recursive-data-structure-algorithms` | recursive array and linked-list algorithms | Planned |
| 28 | `28-javafx-foundations` | JavaFX scene graph, panes, controls, layout basics | Planned |
| 29 | `29-javafx-event-driven-apps` | JavaFX events, lambdas, layouts, app state | Planned |
| 30 | `30-mastering-java-capstone` | JavaFX capstone using OOP, generics, file I/O, exceptions, and recursion | Planned |

## Daily Rules

- Add exactly one new project per day.
- Keep the code original and in my own style.
- Include a README inside every project folder.
- Compile the new project before committing.
- Use JavaFX only for GUI projects.
- Do not use Swing.
- Push each day to GitHub after the project is added.

## How to Compile a Project

From a project folder:

```bash
javac -d out src/*.java
java -cp out MainClassName
```

Example:

```bash
cd 01-gradebook-gpa-calculator
javac -d out src/*.java
java -cp out GradebookApp
```

## Why I Am Building This

I want this repo to show real Java growth: not just syntax, but better design decisions over time. The later projects matter the most because they combine interfaces, polymorphism, exceptions, file I/O, generics, recursion, and JavaFX into programs that feel closer to actual software.
