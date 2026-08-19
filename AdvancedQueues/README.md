### Phase 2: Core Java Collections — Queues, Linked Lists, and Heaps

* **Core Concepts:**

  * **FIFO (First-In, First-Out):** Queues process elements sequentially. Essential for Breadth-First Search (BFS) and level-order traversals.
  * **Scattered vs. Contiguous Memory:** Linked lists use doubly-linked pointers connecting scattered nodes across the heap, unlike arrays which use continuous blocks.
  * **Priority & Heaps:** Heaps are complete binary trees where parent nodes are ordered relative to their children. They are essential for finding top-$K$ elements or handling dynamic minimum/maximum tracking efficiently.
  * **High-Performance Concurrency:** For ultra-low-latency systems, lock-free Single-Producer Single-Consumer (SPSC) Ring Buffers use pre-allocated primitive arrays to ensure zero object allocations and bypass garbage collection pauses.

* **Java Specifics:**

  * **`PriorityQueue`** defaults to a Min-Heap in Java. You must know how to pass custom `Comparator` lambdas to transform it into a Max-Heap or handle custom objects.
  * **`LinkedList`** implements both the `Deque` and `Queue` interfaces. While it provides $O(1)$ performance for insertions/deletions at the ends, it carries high memory overhead due to its node wrapper pointers and has $O(N)$ random access.
  * **`ArrayDeque`** remains the preferred, high-performance implementation for standard queues because it avoids the node-allocation overhead of `LinkedList`.

* **Key LeetCode Problems:** *Binary Tree Level Order Traversal, Kth Largest Element in an Array, Merge K Sorted Lists, Top K Frequent Elements.*

---

### Fundamental Structures

* **LinkedList (Nodes & Pointers)**
  Uses doubly-linked pointers connecting scattered nodes.

  * **Time:** $O(1)$ insertion and deletion at the ends; $O(N)$ for random access by index.
  * **Space:** High memory overhead due to object wrappers and pointers for every element.
  * **Characteristics:** Ideal for queues or deques where frequent mutations occur strictly at the ends. Suffers from poor CPU cache locality compared to array-backed structures.

* **Queue via `ArrayDeque`**
  FIFO collection backed by a resizing circular array.

  * **Time:** $O(1)$ amortized offer, poll, and peek.
  * **Space:** $O(N)$ with occasional extra capacity, but zero per-node allocation overhead.
  * **Characteristics:** The recommended class for standard queues in modern Java. Outperforms `LinkedList` due to contiguous memory spatial locality.

* **PriorityQueue (Min-Heap / Max-Heap)**
  A queue where elements are processed based on priority rather than insertion order.

  * **Time:** $O(\log N)$ for insertion (`offer`) and extraction (`poll`); $O(1)$ to peek at the extremum.
  * **Space:** $O(N)$ contiguous memory (implemented via an array under the hood).
  * **Characteristics:** Defaults to a Min-Heap. Highly efficient for streaming data evaluations, Dijkstra's Algorithm, and $K$-way merges.

* **Lock-Free Ring Buffers**
  Advanced circular arrays designed for inter-thread communication.

  * **Characteristics:** Pre-allocating primitive arrays (like `long[]` or `byte[]`) ensures zero new objects are allocated on the heap after initialization. Essential for HFT and systems engineering.

---

### Quick Reference – When to Use What

| Structure         | Best For                                     | Avoid When                                         |
| ----------------- | -------------------------------------------- | -------------------------------------------------- |
| **ArrayDeque**    | Standard FIFO queues, level-order BFS        | Processing elements based on priority/value        |
| **LinkedList**    | Frequent mutations strictly at the ends      | Need random access or memory is highly constrained |
| **PriorityQueue** | Top-$K$ elements, Dijkstra's, sorted streams | Strict FIFO ordering is required                   |
| **Ring Buffer**   | Ultra-low-latency inter-thread messaging     | General-purpose application logic                  |

---
