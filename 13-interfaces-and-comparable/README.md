# Day 13: Interfaces and Comparable

## Learning Objectives

- Define and implement interfaces for contracts
- Implement `Comparable<T>` for natural ordering
- Create custom `Comparator` implementations
- Use `Collections.sort()` with different strategies
- Design multiple sorting options without modifying core classes
- Understand the difference between Comparable and Comparator

## Project Overview

This project implements a **Book Library System** demonstrating interfaces, Comparable, and multiple Comparator strategies.

### Key Classes

1. **Book (implements Comparable<Book>)**
   - Natural ordering by title
   - Implements `compareTo()` method
   - Provides getters for all properties

2. **BookComparators**
   - `ByAuthor`: Sort by author name
   - `ByPrice`: Sort by price ascending
   - `ByPriceDescending`: Sort by price descending
   - `ByYear`: Sort by publication year
   - `ByPages`: Sort by page count

3. **Library (Interface)**
   - Contract: `addBook()`, `removeBook()`, `findByTitle()`
   - Query: `getBookCount()`, `displayAllBooks()`
   - Sorting: `sortByTitle()`, `sortByAuthor()`, `sortByPrice()`, `sortByYear()`

4. **BookLibrary (implements Library)**
   - ArrayList-based implementation
   - Uses Comparable for natural sorting
   - Uses custom Comparators for alternative sorting

5. **InterfaceComparableApp**
   - Demonstrates multiple sorting strategies
   - Shows Comparable vs Comparator usage
   - Validates finding and removing books

## Key Concepts Demonstrated

- **Interfaces**: Defining contracts without implementation
- **Comparable**: Natural ordering (one way to sort)
- **Comparator**: Alternative sorting strategies (many ways)
- **Collections.sort()**: Using natural order or custom comparators
- **Strategy Pattern**: Multiple sorting algorithms switchable at runtime
- **instanceof**: Type checking in polymorphic collections

## Compilation & Execution

```bash
javac src/*.java
java -cp src InterfaceComparableApp
```

## Expected Output

The app demonstrates:
- Books sorted by title (natural order, Comparable)
- Books sorted by author name (Comparator)
- Books sorted by price ascending (Comparator)
- Books sorted by publication year (Comparator)
- Finding and removing books via interface methods
- Multiple sorting strategies for same data
