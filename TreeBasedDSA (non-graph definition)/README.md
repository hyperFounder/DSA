### Tree based DSA

A **tree** is a nonlinear hierarchical data structure consisting of nodes connected by edges. It is widely used to represent hierarchical relationships, such as organizational charts, file systems, and decision-making processes.

![Screenshot 2025-03-24 at 22 12 35](https://github.com/user-attachments/assets/d96d2f0f-3e32-465c-90f5-32facaddc94a)

### Applications of Trees:
1. **File Systems**: File systems like NTFS and HFS+ use trees to organize files and directories in a hierarchical manner.
2. **B-Trees**: A special type of self-balancing search tree in which each node can contain more than one key and can have more than two children. It is a generalized form of the binary search tree.
   - **Applications**: B-trees and their variations are used in databases for indexing data and efficiently searching records.
---
## Mathematical Definitions:
### Depth and Height:
- **Depth of a node**: The number of edges from the root to the node.
  - Example: In the tree below, the depth of node 5 is 2 because it takes 2 edges to reach from the root to node 5.

    ```
         1
        / \
       2   3
      / \
     4   5
    ```
  - Depth of node 5 = 2

- **Height of a node**: The number of edges on the longest path from the node to a leaf.
  - Example: The height of node 2 is 2 because the longest path from node 2 leads to node 5 with 2 edges.

    ```
         1
        / \
       2   3
      / \
     4   5
    ```

  - Height of node 2 = 2
