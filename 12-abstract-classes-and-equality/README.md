# Day 12: Abstract Classes and Equality

## Learning Objectives

- Use abstract classes to define incomplete type hierarchies
- Implement abstract methods that subclasses must override
- Override `equals()` for meaningful object comparison
- Override `hashCode()` consistently with `equals()`
- Override `toString()` for clear object representation
- Understand Object method contracts

## Project Overview

This project implements a **Vehicle Management System** demonstrating abstract classes and proper Object method implementation.

### Class Hierarchy

```
Vehicle (abstract)
├── Car
├── Truck
└── Motorcycle
```

### Key Features

1. **Vehicle (Abstract Base Class)**
   - Abstract methods: `calculateDepreciation()`, `getVehicleType()`
   - Concrete method: `getCurrentValue()`, `describe()`
   - Overridden `equals()`: compares make, model, year
   - Overridden `hashCode()`: consistent with equals()
   - Overridden `toString()`: detailed representation

2. **Car, Truck, Motorcycle**
   - Each implements depreciation differently
   - Provides vehicle-specific properties
   - Inherits equality and string representation

3. **AbstractEqualityApp**
   - Creates vehicle collection
   - Demonstrates equals() behavior
   - Tests hashCode() consistency
   - Verifies Object method contracts
   - Shows polymorphic depreciation calculations

## Key Concepts Demonstrated

- **Abstract Classes**: Cannot be instantiated directly
- **Abstract Methods**: Force subclasses to implement behavior
- **equals() Override**: Custom comparison logic
- **hashCode() Override**: Consistent with equals()
- **toString() Override**: Clear object representation
- **Object Contracts**: Rules for equals/hashCode relationship
- **Polymorphism**: Different depreciation rates per vehicle type

## Compilation & Execution

```bash
javac src/*.java
java -cp src AbstractEqualityApp
```

## Expected Output

The app demonstrates:
- Abstract method polymorphism for depreciation calculations
- Object equality based on make/model/year
- HashSet deduplication using equals() and hashCode()
- Verification of Object method contracts
