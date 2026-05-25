# Day 08 - Object Modeling Basics

This project is a small console app that models a real-ish domain using plain Java classes.

The goal is to get comfortable with:

- fields and access control
- constructors and basic validation
- object relationships (an adoption center "has" pets and adoptions)
- instance methods that keep object state consistent

## How to Run

From this folder:

```bash
javac -d out src/*.java
java -cp out AdoptionApp
```

## What You Can Do

The menu lets you:

- register pets into the center
- list pets by availability
- adopt a pet to a named adopter
- view the adoption log

## Design Notes

- This is intentionally "no frameworks" — just classes, objects, and method calls.
- Most fields are private. The public API is small and explicit.
- The center class owns the rules for adoption so the rest of the app stays simple.

