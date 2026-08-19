### Exercise 1: In-Place Zero-Allocation Array Partitioning (Two-Pointer Technique)

**Task:** Write a Java method `public static void partitionEvenOdd(int[] arr)` that takes an array of integers and rearranges the elements in-place such that all even numbers appear before all odd numbers. You must achieve this using a two-pointer approach without allocating any extra arrays or collections.

* **Goal:** Practice contiguous memory array manipulation, efficient pointer management, and zero-allocation execution paths.

---

### Exercise 2: Stack-Based Matching Bracket Validator (`ArrayDeque`)

**Task:** Write a program that takes a string containing parentheses, brackets, and braces (`()`, `[]`, `{}`), and uses an `ArrayDeque<Character>` to verify whether the string is valid. A string is valid if open brackets are closed in the correct order. 

* **Goal:** Practice LIFO stack mechanics using modern Java collections (`ArrayDeque`) while avoiding legacy classes.

---

### Exercise 3: Monotonic Stack Temperature Analyzer (`ArrayDeque`)

**Task:** Given a daily temperature array (e.g., `[73, 74, 75, 71, 69, 72, 76, 73]`), write a method that returns an array where each element represents the number of days you would have to wait until a warmer temperature. If there is no future warmer day, put `0`. Use a monotonic decreasing stack to solve this in $O(n)$ time.

* **Goal:** Master advanced monotonic stack patterns to optimize sequential data lookups from quadratic to linear time complexity.
