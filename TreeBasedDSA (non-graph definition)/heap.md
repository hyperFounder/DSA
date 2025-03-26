## Heaps Data Structure

This data structure is a complete binary tree that satisfies the heap property, where any given node is

- always greater than its child node/s and the key of the root node is the largest among all other nodes. This property is also called max heap property.
- always smaller than the child node/s and the key of the root node is the smallest among all other nodes. This property is also called min heap property.

![Screenshot 2025-03-24 at 22 58 22](https://github.com/user-attachments/assets/d6bb93e2-53b7-4d2c-993e-d1993156a939)
![Screenshot 2025-03-24 at 22 58 43](https://github.com/user-attachments/assets/7530269a-cbd8-4d89-a52d-35563d2e7f53)

### Applications:
- **Priority Queues**: Heaps are often used to implement priority queues, where the highest (or lowest) priority element is always accessible in constant time.
- **Heap Sort**: Heaps can be used to implement heap sort, a comparison-based sorting algorithm.

---
## Heapify

This is a process that rearranges a tree or array to satisfy the heap property. It is mainly used to:
1. Build a heap from an arbitrary array of elements.
2. Restore the heap property after removing the root element or inserting a new element.

### Heapify Process

- **Top-Down (sift-down)**: Used when deleting the root element. The last element is moved to the root, and we "sift-down" to restore the heap property.
- **Bottom-Up (sift-up)**: Used when inserting a new element at the end, then moving it upward if necessary.

### Time Complexity
- **O(log n)** for a single heapify operation (e.g., per insertion or deletion).
- **O(n)** when building a heap from an unordered array.
