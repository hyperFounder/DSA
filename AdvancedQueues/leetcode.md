# LeetCode Practice Questions: Queues, Linked Lists & Heaps

A curated collection of LeetCode problems covering FIFO queues, BFS, deques and monotonic queues, linked list pointer manipulation, and heaps (min-heap, max-heap, two heaps, K-way merge), ordered by difficulty.
- Problem lists:
  - https://leetcode.com/problem-list/queue/
  - https://leetcode.com/problem-list/linked-list/
  - https://leetcode.com/problem-list/heap-priority-queue/

---

## Easy

These problems focus on core queue mechanics, basic linked list pointer rewiring, and simple heap usage with Java's built-in `PriorityQueue`.

* **[232. Implement Queue using Stacks](https://leetcode.com/problems/implement-queue-using-stacks/)** ✅
  * **Concepts:** FIFO vs LIFO, Two Stacks, Amortized O(1)
* **[225. Implement Stack using Queues](https://leetcode.com/problems/implement-stack-using-queues/)**
  * **Concepts:** Queue Rotation, FIFO to LIFO Conversion
* **[933. Number of Recent Calls](https://leetcode.com/problems/number-of-recent-calls/)**
  * **Concepts:** Sliding Time Window, Evicting from the Front of a Queue
* **[1700. Number of Students Unable to Eat Lunch](https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/)**
  * **Concepts:** Queue Simulation, Detecting a Stuck Loop
* **[206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)** ✅
  * **Concepts:** Three-Pointer Reversal (prev, curr, next), Recursion
* **[21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)**
  * **Concepts:** Dummy Head Node, Two Pointers
* **[1046. Last Stone Weight](https://leetcode.com/problems/last-stone-weight/)**
  * **Concepts:** Max-Heap via `Comparator.reverseOrder()`
* **[703. Kth Largest Element in a Stream](https://leetcode.com/problems/kth-largest-element-in-a-stream/)**
  * **Concepts:** Min-Heap of Size K, Streaming Data

---

## Medium

These problems introduce BFS templates, circular buffers, doubly linked list design, the "heap of size K" pattern, custom comparators on objects, and greedy scheduling with heaps.

* **[102. Binary Tree Level Order Traversal](https://leetcode.com/problems/binary-tree-level-order-traversal/)**
  * **Concepts:** BFS with `ArrayDeque`, Snapshotting Level Size
* **[199. Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)**
  * **Concepts:** Level Order BFS, Last Node per Level
* **[994. Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)**
  * **Concepts:** Multi-Source BFS, Grid Traversal
* **[622. Design Circular Queue](https://leetcode.com/problems/design-circular-queue/)**
  * **Concepts:** Ring Buffer, Modulo Index Wrapping
* **[641. Design Circular Deque](https://leetcode.com/problems/design-circular-deque/)**
  * **Concepts:** Ring Buffer at Both Ends, How `ArrayDeque` Works Internally
* **[707. Design Linked List](https://leetcode.com/problems/design-linked-list/)**
  * **Concepts:** Node Design, Insert/Delete at Index, Edge Cases (Head/Tail)
* **[19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)**
  * **Concepts:** Two Pointers with a Gap, Dummy Head Node
* **[142. Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)**
  * **Concepts:** Floyd's Algorithm, Finding the Cycle Entry Point
* **[143. Reorder List](https://leetcode.com/problems/reorder-list/)**
  * **Concepts:** Find Middle + Reverse Second Half + Merge
* **[2. Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)**
  * **Concepts:** Linked List Traversal with Carry
* **[146. LRU Cache](https://leetcode.com/problems/lru-cache/)**
  * **Concepts:** Doubly Linked List + HashMap, O(1) Move-to-Front
* **[215. Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)**
  * **Concepts:** Min-Heap of Size K, QuickSelect
* **[347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)**
  * **Concepts:** HashMap Counting + Min-Heap, Bucket Sort
* **[973. K Closest Points to Origin](https://leetcode.com/problems/k-closest-points-to-origin/)**
  * **Concepts:** Max-Heap of Size K, Custom Comparator
* **[767. Reorganize String](https://leetcode.com/problems/reorganize-string/)**
  * **Concepts:** Greedy with Max-Heap, Holding Back the Previous Element
* **[621. Task Scheduler](https://leetcode.com/problems/task-scheduler/)**
  * **Concepts:** Max-Heap + Cooldown Queue, Greedy Scheduling
* **[1834. Single-Threaded CPU](https://leetcode.com/problems/single-threaded-cpu/)**
  * **Concepts:** Sort by Arrival + Min-Heap by Processing Time, Tie-Breaking
* **[743. Network Delay Time](https://leetcode.com/problems/network-delay-time/)**
  * **Concepts:** Dijkstra's Algorithm, Lazy Deletion in `PriorityQueue`
* **[253. Meeting Rooms II](https://leetcode.com/problems/meeting-rooms-ii/)** *(Premium)*
  * **Concepts:** Sort by Start Time, Min-Heap of End Times

---

## Hard

These problems require K-way merges, two coordinated heaps, monotonic deques, in-place group reversal of linked lists, and combining heaps with other structures.

* **[23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)**
  * **Concepts:** K-Way Merge, Min-Heap of List Heads, O(N log K)
* **[295. Find Median from Data Stream](https://leetcode.com/problems/find-median-from-data-stream/)**
  * **Concepts:** Two Heaps (Max-Heap Lower Half, Min-Heap Upper Half), Rebalancing
* **[239. Sliding Window Maximum](https://leetcode.com/problems/sliding-window-maximum/)**
  * **Concepts:** Monotonic Deque, O(N) Window Tracking
* **[862. Shortest Subarray with Sum at Least K](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/)**
  * **Concepts:** Prefix Sums + Monotonic Deque, Handling Negative Numbers
* **[25. Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)**
  * **Concepts:** In-Place Segment Reversal, Reconnecting Group Boundaries
* **[460. LFU Cache](https://leetcode.com/problems/lfu-cache/)**
  * **Concepts:** HashMap of Doubly Linked Lists per Frequency, O(1) Eviction
* **[480. Sliding Window Median](https://leetcode.com/problems/sliding-window-median/)**
  * **Concepts:** Two Heaps with Removal, Lazy Deletion
* **[502. IPO](https://leetcode.com/problems/ipo/)**
  * **Concepts:** Min-Heap by Capital + Max-Heap by Profit, Greedy
* **[632. Smallest Range Covering Elements from K Lists](https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/)**
  * **Concepts:** K-Way Merge, Tracking the Current Max alongside a Min-Heap
* **[407. Trapping Rain Water II](https://leetcode.com/problems/trapping-rain-water-ii/)**
  * **Concepts:** Min-Heap BFS from the Boundary Inwards, 2D Grid
