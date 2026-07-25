### Phase 1: Advanced Trees, BSTs, and Heaps (Weeks 7–9)

- **Core Concepts:**
    
    - Binary Trees & Recursion (DFS: Pre-order, In-order, Post-order; BFS: Level-order).
    - Binary Search Trees (BST invariants and range queries).
    - Heaps / Priority Queues (Min-Heap / Max-Heap implementations and streaming data).
        
- **Java Specifics:** `PriorityQueue` defaults to a Min-Heap. Know how to pass custom `Comparator` lambdas.
    
- **Key Leetcode Problems:** _Validate Binary Search Tree, Binary Tree Level Order Traversal, Kth Largest Element in an Array, Merge K Sorted Lists_.

### DFS/BFS Graph traversals
https://www.youtube.com/watch?v=pcKY4hjDrxk&t=554s

- BFS: Level order traversal. *The result of a BFS search on a graph/tree is a BFS spanning tree*.
- Depth first search algorithms explore as deep as possible along each branch before backtracking. There are 3 primary forms of DFS which are mentioned below.

1. Pre-order traversal (Root, left, right)
2. In-order traversal (Left, root, right)
3. Post-order travsersal (Left, right, root)

