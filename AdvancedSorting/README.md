### Phase 2: Sorting Algorithms and Strategies (Weeks 10–11)

- **Core Concepts:**
    - Comparison-based Sorting (Merge Sort, Quick Sort, Heap Sort).
    - Iterative/Basic Sorting (Insertion Sort, Selection Sort, Bubble Sort) - Good to know for fundamentals.
    - Non-comparison Sorting (Counting Sort, Bucket Sort, Radix Sort) - O(N) time complexity.
    - Concept of **Stability** (Does the algorithm preserve the relative order of equal elements?).
    - Time and Space Complexities (Understanding O(N log N) bounds and worst-case scenarios).
    - In-place sorting: rearranges elements inside the original array, using only a constant amount of extra memory (typically O(1)).

- **Java Specifics:** 
    - `Arrays.sort(primitives)` uses Dual-Pivot Quicksort (Unstable).
    - `Arrays.sort(objects)` and `Collections.sort()` use **Timsort** (A hybrid of Merge Sort and Insertion Sort, which is Stable).
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
    - Picks a **pivot** element and partitions the array so elements smaller than the pivot are on the left, and larger ones are on the right. Recursively applies to sub-arrays.
    - **Time:** O(N log N) average/best, O(N²) worst-case (happens when the array is already sorted and a poor pivot like the last element is chosen).
    - **Space:** O(log N) space for the recursive call stack.
    - **Characteristics:** **Unstable**. Generally faster in practice for arrays due to better cache locality (in-place sorting).

- **Bucket / Counting Sort (Linear Time O(N))**:
    - When the range of potential values is bounded and relatively small (e.g., frequencies of elements in an array), you can map them to indices in a frequency/count array. This circumvents the O(N log N) mathematical limit of comparison-based sorting.
