### Phase 1: Core Java Collections — Arrays and Stacks (Weeks 1–3)

- **Core Concepts:**
    - **Contiguous Memory:** Arrays store elements in a single continuous block. Primitive arrays (`int[]`, `double[]`, etc.) give excellent spatial locality and cache performance.
    - **LIFO (Last-In, First-Out):** Stacks process the most recently added element first. Essential for nested structures, parsing, DFS, and backtracking.
    - **Monotonic Stacks:** Maintain elements in strictly increasing or decreasing order. Each element is pushed/popped at most once → turns many \(O(n^2)\) problems into \(O(n)\).
    - **In-place vs. Dynamic:** Static arrays have fixed size and zero overhead. Dynamic arrays (`ArrayList`) resize automatically but pay a cost on growth and middle insertions/deletions.

- **Java Specifics:**
    - Prefer **`ArrayDeque`** over the legacy `Stack` class. `Stack` is synchronized (unnecessary overhead) and has a poorer API. Use:
      ```java
      Deque<Integer> stack = new ArrayDeque<>();
      stack.push(x);
      int top = stack.pop();
      ```
    - **`ArrayList`** is the default dynamic array. Backed by a resizable `Object[]`. Excellent for random access and appends; \(O(n)\) for middle insertions/deletions.
    - Primitive arrays avoid boxing and GC pressure. Prefer them on hot paths.

- **Key LeetCode Problems:** Valid Parentheses, Evaluate Reverse Polish Notation, Daily Temperatures, Sliding Window Maximum, Largest Rectangle in Histogram, Next Greater Element, Asteroid Collision, Trapping Rain Water.

---

### Fundamental Structures

- **Static Arrays (`T[]` or primitive arrays)**  
  Fixed-size contiguous memory allocated at creation.  
  - **Time:** \(O(1)\) random access and iteration.  
  - **Space:** Exactly the size you allocate; no extra overhead for primitives.  
  - **Characteristics:** Maximum cache friendliness. Cannot grow or shrink. Ideal for fixed buffers, lookup tables, and performance-critical loops.

- **ArrayList (Dynamic Arrays)**  
  Resizable array that grows (≈1.5×) when capacity is exceeded.  
  - **Time:** \(O(1)\) amortized append, \(O(1)\) random access, \(O(n)\) insert/delete in the middle.  
  - **Space:** \(O(n)\) with occasional extra capacity.  
  - **Characteristics:** Default choice for most lists. Boxing cost when storing primitives. Good cache behavior on sequential access.

- **Stacks via `ArrayDeque`**  
  LIFO collection. Recommended concrete implementation is `ArrayDeque`.  
  - **Time:** \(O(1)\) push, pop, peek.  
  - **Space:** \(O(n)\).  
  - **Characteristics:** Faster and cleaner than legacy `Stack`. Also works as a queue or deque. Perfect for DFS, expression evaluation, and monotonic-stack patterns.

- **Monotonic Stack**  
  Stack that keeps elements in monotonic order (increasing or decreasing).  
  - When a new element breaks the order, pop until the order is restored.  
  - Each element is pushed and popped at most once → \(O(n)\) overall.  
  - Classic uses: Next Greater/Smaller Element, Daily Temperatures, Largest Rectangle in Histogram, Sliding Window Maximum (with deque).

---

### Quick Reference – When to Use What

| Structure          | Best For                              | Avoid When                     |
|--------------------|---------------------------------------|--------------------------------|
| Primitive Array    | Fixed size, hot loops, cache critical | Size unknown or changes often  |
| ArrayList          | General-purpose lists, random access  | Frequent middle insert/delete  |
| ArrayDeque (Stack) | LIFO, DFS, parsing, monotonic patterns| Need random access by index    |

---
