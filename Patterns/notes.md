# LeetCode Practice Questions: Tortoise and Hare (Fast & Slow Pointers)

A curated collection of LeetCode problems covering the **Tortoise and Hare (Fast & Slow Pointer)** technique. This pattern is primarily used on linked lists to find the middle, detect cycles, locate cycle entrances, split lists, and manipulate linked list structure efficiently in **O(N)** time with **O(1)** extra space.

---

# What is the Tortoise and Hare Algorithm?

The **Tortoise and Hare algorithm** (also called **Floyd's Cycle Detection Algorithm**) is a two-pointer technique where:

- **Slow Pointer (Tortoise)** moves **1 node at a time**
- **Fast Pointer (Hare)** moves **2 nodes at a time**

Because the fast pointer moves twice as quickly, the two pointers eventually reveal useful information about the structure of the list.

## Common Uses

- Find the middle of a linked list
- Detect if a linked list contains a cycle
- Find the starting node of a cycle
- Find the length of a cycle
- Split a linked list for Merge Sort
- Reverse the second half of a linked list
- Reorder linked lists
- Check if a linked list is a palindrome


# Easy

These problems introduce the basic Fast & Slow Pointer pattern.

* **[876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)**
  * **Concepts:** Find Middle, Fast & Slow Pointers

* **[141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)**
  * **Concepts:** Floyd's Cycle Detection, Fast & Slow Pointers

* **[160. Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)**
  * **Concepts:** Two Pointers (Pointer Switching)

* **[234. Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)**
  * **Concepts:** Find Middle, Reverse Second Half, Fast & Slow Pointers

---

# Medium

These problems combine Fast & Slow Pointers with reversal, merging, and divide-and-conquer techniques.

* **[19. Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)**
  * **Concepts:** Two Pointers (Fixed Gap)

* **[142. Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)**
  * **Concepts:** Floyd's Algorithm, Find Cycle Entrance

* **[143. Reorder List](https://leetcode.com/problems/reorder-list/)**
  * **Concepts:** Find Middle, Reverse List, Merge Lists

* **[148. Sort List](https://leetcode.com/problems/sort-list/)**
  * **Concepts:** Merge Sort, Find Middle, Divide & Conquer

* **[61. Rotate List](https://leetcode.com/problems/rotate-list/)**
  * **Concepts:** Two Pointers, Circular Linked List

* **[86. Partition List](https://leetcode.com/problems/partition-list/)**
  * **Concepts:** Linked List Manipulation, Two Pointers

---

# Hard

These problems require combining multiple linked list techniques with advanced pointer manipulation.

* **[25. Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)**
  * **Concepts:** Pointer Manipulation, Linked List Reversal

* **[23. Merge k Sorted Lists](https://leetcode.com/problems/merge-k-sorted-lists/)**
  * **Concepts:** Divide & Conquer, Merge Lists

---

# Pattern Recognition Guide

| If the Question Says... | Think... |
|--------------------------|----------|
| Find the middle | Fast & Slow Pointers |
| Detect a loop | Floyd's Cycle Detection |
| Find where the cycle starts | Floyd's Algorithm |
| Split a linked list | Fast & Slow Pointers |
| Reverse the second half | Find Middle → Reverse |
| Reorder the list | Find Middle → Reverse → Merge |
| Palindrome linked list | Find Middle → Reverse → Compare |
| Merge Sort on linked list | Find Middle → Split |

---

# Complexity

| Operation | Time | Space |
|-----------|------|-------|
| Find Middle | O(N) | O(1) |
| Detect Cycle | O(N) | O(1) |
| Find Cycle Start | O(N) | O(1) |
| Find Cycle Length | O(N) | O(1) |
| Palindrome Check | O(N) | O(1) |
| Split for Merge Sort | O(N) | O(1) |

---