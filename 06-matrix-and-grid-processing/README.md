# Day 06 - Matrix and Grid Processing

This project is a console lab for working with 2D arrays (matrices and grids). The focus is on:

- reading and validating 2D input
- clean index math and bounds checks
- row/column operations
- grid neighbor logic (orthogonal + diagonal)
- writing small, reusable methods for matrix transforms

## How to Run

From this folder:

```bash
javac -d out src/*.java
java -cp out GridLabApp
```

## What You Can Do

The menu lets you:

1) Create a matrix by specifying rows/cols and typing values
2) Create a random matrix in a value range
3) Print row/column sums and find the max cell
4) Transpose (copy)
5) Rotate 90 degrees clockwise (copy)
6) Apply a 3x3 neighbor "blur" (copy) using averages
7) Count connected regions in a 0/1 grid (flood fill using loops)

## Design Notes

- All transforms return new matrices rather than mutating the original.
- Flood fill is implemented iteratively (stack) so it stays loop-focused and avoids recursion for now.
- Later days will build on these patterns with stronger object models, generics, exceptions, and file-backed data.

