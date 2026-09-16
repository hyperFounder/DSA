### Phase 2: Sorting Algorithms and Strategies (Weeks 10–11) 

- **Core Concepts:**
    - Comparison-based Sorting (Merge Sort, Quick Sort, Heap Sort).
    - Iterative/Basic Sorting (Insertion Sort, Selection Sort, Bubble Sort) - Good to know for fundamentals.
    - Non-comparison Sorting (Counting Sort, Bucket Sort, Radix Sort) - O(N) time complexity.
    - Concept of **Stability** (Does the algorithm preserve the relative order of equal elements?).
    - Time and Space Complexities (Understanding O(N log N) bounds and worst-case scenarios).
    - **In-place sorting:** rearranges elements inside the original array, using only a constant amount of extra memory (typically O(1)).

- **Java Specifics:**
    - `Arrays.sort(primitives)` uses Dual-Pivot Quicksort (Unstable).
    - `Arrays.sort(objects)` and `Collections.sort()` use **Timsort** (A hybrid of Merge Sort and Insertion Sort, which is Stable).
    - Use **`Collections.sort()`** when you are working with collections that implement the List interface, such as **ArrayList or LinkedList**. If you are working with a raw array (e.g., int[] or Employee[]), you cannot use Collections.sort(); you must use **Arrays.sort()** instead.
    - Object oriented sorting: Understand how to implement the `Comparable<T>` interface (`compareTo(T o)`) for natural ordering.
    - Custom sorting logic: Master passing `Comparator<T>` via lambda expressions.
      * Example: `Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));` to sort a 2D array by the first column.
        
- **Key Leetcode Problems:** _Sort Colors (Dutch National Flag), Merge Intervals, Kth Largest Element in an Array (Quickselect), Top K Frequent Elements (Bucket Sort), Largest Number, Meeting Rooms II_.

### Fundamental Sorting Algorithms (Divide & Conquer)
https://www.youtube.com/watch?v=kPRA0W1kECg (Merge Sort)
https://www.youtube.com/watch?v=Hoixgm4-P4M (Quick Sort)

- **Merge Sort**: 
    - Divides the array into two halves, recursively sorts them, and then **merges** the two sorted halves back together.
    - **Time:** O(N log N) in all cases (Best, Average, Worst).
    - **Space:** O(N) auxiliary space needed for the temporary merge arrays.
    - **Characteristics:** **Stable**. Highly recommended when sorting Linked Lists since linked lists do not require extra space for merging. **[148. Sort List](https://leetcode.com/problems/sort-list)** ✅

- **Quick Sort**:
    - Picks a **pivot** element and partitions the array so elements smaller than the pivot are on the left, and larger ones are on the right (Lomuto partition). Recursively applies to sub-arrays. 
    - **Time:** O(N log N) average/best, O(N²) worst-case (happens when the array is already sorted and a poor pivot like the last element is chosen).
    - **Space:** O(log N) space for the recursive call stack.
    - **Characteristics:** **Unstable**. Generally faster in practice for arrays due to better cache locality (in-place sorting).
 
- **Insertion Sort**:
    - Builds a final sorted array one item at a time by repeatedly taking the next element (the "key") and sliding it backward into its correct relative position among the already-sorted elements to its left. https://www.youtube.com/watch?v=Kg4bqzAqRBM
    - **Time:** $O(N)$ best-case (when the array is already sorted), $O(N^2)$ average and worst-case (when the array is reverse-sorted).
    - **Space:** $O(1)$ auxiliary space (in-place sorting).
    - **Characteristics:** Stable. Highly efficient for small datasets or nearly sorted arrays (which is why high-performance engines like Java's Timsort use it as a fallback).

- **Bubble Sort**:
    - Repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order. The largest elements "bubble" up to the end of the array with each full pass.
    - **Time:** $O(N)$ best-case (when optimized with a swap flag and the array is already sorted), $O(N^2)$ average and worst-case (when the array is reverse-sorted or randomly ordered).
    - **Space:** $O(1)$ auxiliary space (in-place sorting).
    - **Characteristics:** Stable. Highly inefficient for large datasets, but historically significant as the simplest sorting algorithm to conceptualize.

- **Selection Sort**:
    - Repeatedly iterates through the unsorted portion of the array to find the minimum element, then swaps it with the first unsorted position, gradually building a sorted region at the front. **The unsorted part of the array is always at the end.**
    - **Time:** $O(N^2)$ across all cases (best, average, and worst) because it always scans the remaining elements regardless of initial order.
    - **Space:** $O(1)$ auxiliary space (in-place sorting).
    - **Characteristics:** Unstable. Performs the minimum possible number of writes (at most $O(N)$ swaps) compared to other quadratic sorts, making it useful when memory write operations are costly.
 
- **Binary Search**: https://www.geeksforgeeks.org/java/arrays-binarysearch-java-examples-set-1/
    - Searches for a target value in a **sorted array** by repeatedly comparing the target with the middle element and eliminating half of the remaining search space on each iteration. **The search range is halved after every comparison.** ```Arrays.binarySearch() ```
    - **Time:**
        - Best Case: $O(1)$ (target is found at the middle element immediately).
        - Average Case: $O(\log N)$.
        - Worst Case: $O(\log N)$.
    - **Space:**
        - Iterative implementation: $O(1)$ auxiliary space.
        - Recursive implementation: $O(\log N)$ due to the call stack.

- **Bucket / Counting Sort (Linear Time O(N))**: Top k frequent elements: Heap or Bucket Sort.
    - https://leetcode.com/problems/top-k-frequent-elements/description/
    - When the range of potential values is bounded and relatively small (e.g., frequencies of elements in an array), you can map them to indices in a frequency/count array. This circumvents the O(N log N) mathematical limit of comparison-based sorting.
    - **Either solve with a heap O(klogn) where k is the number of frequent elements or with Bucket sort O(n)**
    - https://www.youtube.com/watch?v=YPTqKIgVk-k&t=238s
