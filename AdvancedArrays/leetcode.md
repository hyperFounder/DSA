# LeetCode Practice Questions: Arrays & Stacks

A curated collection of LeetCode problems covering contiguous memory arrays, dynamic arrays, hash-based array lookups, and LIFO stack operations (including monotonic patterns), ordered by difficulty.

---

## Easy

These problems focus on basic array iteration, hash-based duplicate detection, in-place pointer manipulation, and foundational Last-In, First-Out (LIFO) stack usage.

* **[1. Two Sum](https://leetcode.com/problems/two-sum/)**
  * **Concepts:** Array traversal, hashing for constant-time lookups.
* **[20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)**
  * **Concepts:** LIFO (Stack), tracking nested states, string parsing.
* **[26. Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)**
  * **Concepts:** Two Pointers, In-place array manipulation.
* **[121. Best Time to Buy and Sell Stock](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/)**
  * **Concepts:** Array traversal, Single-pass minimum element tracking.
* **[217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)**
  * **Concepts:** Frequency counting, duplicate detection.
* **[232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)**
  * **Concepts:** Two Stacks, LIFO to FIFO behavior conversion.

---

## Medium

These problems introduce custom stack design, monotonic stack patterns, advanced array parsing, dynamic stream processing, and utilizing pointers within arrays.

* **[11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/)**
  * **Concepts:** Array boundary scanning, Converging Two Pointers.
* **[735. Asteroid Collision](https://leetcode.com/problems/asteroid-collision/)**
  * **Concepts:** LIFO (Stack), simulation of collisions, handling directional movement.
* **[15. 3Sum](https://leetcode.com/problems/3sum/)**
  * **Concepts:** Linear scans, Two Pointers (converging from ends).
* **[49. Group Anagrams](https://leetcode.com/problems/group-anagrams/)**
  * **Concepts:** Array traversal, string manipulation, mapping relationships.
* **[53. Maximum Subarray](https://leetcode.com/problems/maximum-subarray/)**
  * **Concepts:** Contiguous array scan, Kadane's Algorithm.
* **[71. Simplify Path](https://leetcode.com/problems/simplify-path/)**
  * **Concepts:** LIFO (Stack), Canonical string parsing, Directory state resolution.
* **[150. Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)**
  * **Concepts:** LIFO (Stack), evaluating mathematical expressions, utilizing Deque.
* **[155. Min Stack](https://leetcode.com/problems/min-stack/)**
  * **Concepts:** Stack Design, Auxiliary stack state tracking.
* **[503. Next Greater Element II](https://leetcode.com/problems/next-greater-element-ii/)**
  * **Concepts:** Monotonic Stack, Circular array indexing.
* **[739. Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)**
  * **Concepts:** Monotonic Stack, optimizing sequential data lookups, tracking state.
* **[901. Online Stock Span](https://leetcode.com/problems/online-stock-span/)**
  * **Concepts:** Monotonic Stack, Online data stream evaluation.

---

## Hard

These problems require complex dynamic window tracking, modifying standard array operations, and combining monotonic structures with strict time/space complexities to compute geometric and spatial bounds.

* **[41. First Missing Positive](https://leetcode.com/problems/first-missing-positive/)**
  * **Concepts:** Cyclic Sort (In-place array hashing), O(N) Time / O(1) Space Limit.
* **[42. Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)**
  * **Concepts:** Monotonic Stack or Two Pointers, Array boundary evaluation.
* **[84. Largest Rectangle in Histogram](https://leetcode.com/problems/largest-rectangle-in-histogram/)**
  * **Concepts:** Monotonic Stack, Calculating index-bounded areas in linear arrays.
* **[85. Maximal Rectangle](https://leetcode.com/problems/maximal-rectangle/)**
  * **Concepts:** 2D Array conversion to 1D Monotonic Stack calculations.
* **[239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)**
  * **Concepts:** Monotonic Queue/Deque, sliding window (dynamic size windows for subarray problems).
