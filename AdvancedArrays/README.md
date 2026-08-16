### Phase 1: Core Java Collections: Arrays and Stacks (Weeks 1–3)


- **Core Concepts:**
    - **Contiguous Memory:** Arrays require contiguous blocks of memory to store elements[cite: 1]. Storing primitives sequentially in flat arrays (like `int[]` or `double[]`) guarantees spatial locality, allowing the CPU to efficiently pre-fetch data into the L1/L2 cache[cite: 1].
    - **LIFO (Last-In, First-Out):** Stacks process elements in a Last-In, First-Out order[cite: 1]. They are essential for tracking nested states, handling parsing, and executing Depth-First Search (DFS) traversals[cite: 1]. 
    - **The Call Stack:** The JVM relies on a recursive call stack, which inherently dictates the space complexity for recursive algorithms like Quick Sort ($O(\log n)$)[cite: 1].
    - **Monotonic Stacks:** Advanced stack patterns used to maintain elements in a specific order, which optimizes sequential data lookups[cite: 1].

- **Java Specifics:**
    - **Avoid the Legacy `Stack`:** In modern Java, you should always use the `Deque` interface (specifically `ArrayDeque`) instead of the legacy `Stack` class[cite: 1].
    - **`ArrayList`:** A dynamic collection backed by internal resizing arrays[cite: 5]. It provides optimal performance for random access and read-heavy operations[cite: 5].
    - **Sorting Primitives vs. Objects:** `Arrays.sort(primitives)` uses an unstable Dual-Pivot Quicksort algorithm[cite: 1]. In contrast, `Arrays.sort(objects)` and `Collections.sort()` use Timsort, which is a stable hybrid of Merge Sort and Insertion Sort[cite: 1, 5].

- **Key LeetCode Problems:** *Valid Parentheses, Evaluate Reverse Polish Notation, Daily Temperatures, Sliding Window Maximum*[cite: 1].

---

### Data Structure Explanations

- **Static Arrays (`T[]` or `int[]`)**:
    - **Explanation:** Fixed-size structures holding elements contiguously in memory[cite: 1]. 
    - **Characteristics:** They are highly cache-friendly and can eliminate object churn and garbage collection overhead if used with primitives on hot paths[cite: 1]. However, their size cannot be changed after initialization.

- **ArrayList (Dynamic Arrays)**:
    - **Explanation:** Java's dynamic array implementation that automatically resizes its internal array as new elements are added[cite: 5].
    - **Characteristics:** It provides exceptionally fast random access but is less efficient for frequent insertions or deletions in the middle of the collection[cite: 5]. 

- **Stacks (via `ArrayDeque`)**:
    - **Explanation:** A collection designed to add and remove elements from the same end (LIFO)[cite: 1].
    - **Characteristics:** `ArrayDeque` is the most highly recommended, high-performance class for stack behavior in modern Java development[cite: 1].
