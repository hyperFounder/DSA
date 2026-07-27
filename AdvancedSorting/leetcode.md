# LeetCode Practice Questions: Sorting Algorithms & Strategies

A curated collection of LeetCode problems covering comparison-based sorting, non-comparison sorting (Bucket/Counting/Radix), custom comparators, and intervals, ordered by difficulty.

---

## Easy

These problems focus on basic sorting applications, using built-in sort functions, or simple array manipulation resembling sort sub-routines (like merging).

* **[88. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)**
  * **Concepts:** Merge Step of Merge Sort, Two Pointers (Backwards)
* **[217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)**
  * **Concepts:** Array Sorting, Adjacent Element Comparison
* **[169. Majority Element](https://leetcode.com/problems/majority-element/)**
  * **Concepts:** Array Sorting, Finding the Median
* **[268. Missing Number](https://leetcode.com/problems/missing-number/)**
  * **Concepts:** Cyclic Sort (Implicit), Math / Bit Manipulation
* **[977. Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/)**
  * **Concepts:** Two Pointers, Merging two sorted segments

---

## Medium

These problems introduce custom comparators, interval processing, divide & conquer sorting (Merge Sort / Quick Sort), and non-comparison sorting techniques (Bucket Sort).

* **[75. Sort Colors](https://leetcode.com/problems/sort-colors/)**
  * **Concepts:** Dutch National Flag Problem, In-Place 3-Way Partitioning
* **[56. Merge Intervals](https://leetcode.com/problems/merge-intervals/)**
  * **Concepts:** Custom Comparator (Sorting by start time), Interval Merging
* **[148. Sort List](https://leetcode.com/problems/sort-list/)** ✅
  * **Concepts:** Merge Sort (Linked List), Fast/Slow Pointers, Divide & Conquer
* **[347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)**
  * **Concepts:** Bucket Sort (Linear Time), Min-Heap
* **[179. Largest Number](https://leetcode.com/problems/largest-number/)**
  * **Concepts:** Custom String Comparator, Lexicographical Sorting
* **[15. 3Sum](https://leetcode.com/problems/3sum/)**
  * **Concepts:** Sorting as a Prerequisite, Two Pointers for Deduplication
* **[215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)**
  * **Concepts:** QuickSelect (Partitioning logic of Quick Sort), Min-Heap
* **[253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/)** *(Premium)*
  * **Concepts:** Chronological Sorting, Two Pointers (Start/End times), Min-Heap

---

## Hard

These problems require modifying standard sorting algorithms (like tracking counts during Merge Sort), applying cyclic sort in heavily constrained environments, or utilizing advanced Bucket/Radix sort logic for linear time requirements.

* **[41. First Missing Positive](https://leetcode.com/problems/first-missing-positive/)**
  * **Concepts:** Cyclic Sort (In-place array hashing), O(N) Time / O(1) Space Limit
* **[315. Count of Smaller Numbers After Self](https://leetcode.com/problems/count-of-smaller-numbers-after-self/)**
  * **Concepts:** Modified Merge Sort (Inversion Counting), Binary Indexed Tree / Segment Tree
* **[164. Maximum Gap](https://leetcode.com/problems/maximum-gap/)**
  * **Concepts:** Bucket Sort / Pigeonhole Principle, Linear Time Sorting Constraints
* **[493. Reverse Pairs](https://leetcode.com/problems/reverse-pairs/)**
  * **Concepts:** Modified Merge Sort, Divide & Conquer, Inversion Counting
* **[4. Median of Two Sorted Arrays](https://leetcode.com/problems/median-of-two-sorted-arrays/)**
  * **Concepts:** Merging Sorted Arrays (Logarithmic Time via Binary Search Partitioning)
