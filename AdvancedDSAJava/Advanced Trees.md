- A **tree** is a nonlinear hierarchical data structure consisting of nodes connected by edges.
- A basic BST works efficiently only when it remains balanced, and can degrade into linked lists if elements are inserted sequentially in sorted order, ruining their efficiency. 
Insert: 10, 20, 30, 40, 50

10
  \
   20
     \
      30
        \
         40
           \
            50

Complexity: O(n)

Advanced trees solve this by maintaining the *self balancing property*.

---
- Red-Black Trees: **Self-balancing BST**. The **advantage** of Red Black Trees to BSTs is that they guarantee O(log n) time complexity for search, insert, and delete operations. **Java's TreeMap and TreeSet are built using Red-Black Trees.** 

![[BSTtime.png]]
## Motivation: Why Red Black Trees

1. Guaranteed O(log n operations): The tree won't even degrade into a linked list because of Rule 5 (Black height rule)
2. Designed for faster **insertions/deletions**. This is because they allow a little more imbalance and often fix violations using recoloring instead of many rotations.
3. Predictability in backend engineering: Worst-case performance is bounded by O(log n).

- Rules:
	- 1: Each node is either red, or black
	- 2: The root is always black
	- 3: Every child of a leaf node is black (represented as NULL)
	- 4: A red node cannot have a red child. If that's the case, then this is called a Red-Red violation
	- 5: Black height rule: Every path from a node to its descendant NIL/NULL leaves must contain the same number of Black nodes
- Each node is either Red, or Black.
### Height/Depth of a Tree

- Height: Longest path from a node down to a leaf
- Depth: Distance from the root down to a specific node

          20          depth 0
         /  \
       10    30       depth 1
      /
     5               depth 2
Height = 2
### Left Rotation on node $x$:

1. **$y$** (the right child of $x$) becomes the new root of this subtree.
2. **$x$** becomes the left child of $y$.
3. **The left subtree of $y$** (if it exists) becomes the new right subtree of $x$.
### Right Rotation on node $x$:

- **$y$** (the left child of $x$) becomes the new root of this subtree.
- **$x$** becomes the right child of $y$.
- **The right subtree of $y$** (if it exists) becomes the new left subtree of $x$.

Insertion
- Standard BST insertion. Always insert a Red node, then "fix the tree"
Search
- Identical to BST
Deletion
- Standard BST deletion then "fix the tree"


---
## BSTs

- A raw BST (without self-balancing logic like Red-Black tree) is dangerous in production because of the O(n) worst-case scenario. It is only useful when data arrives at a random order, or live data streams.
- BST properties:
	- 1. All values in node's left subtree are strictly less than the node's own value.
	- 2. Same thing for the right subtree
	- 3. Both the left and right subtrees must also be valid BSTs.
- **Note:** Never use a raw BST for user-provided input or live data streams. If an attacker knows you are using an unbalanced BST, they can intentionally send sorted data to cause performance issues to O(n), a common DoS attack vector.

---
## AVL Trees (Self-balancing BST)

1. AVL Trees are designed for faster **search operations** because they maintain stricter balance, keeping the tree shorter.

- A node is balanced if its balance factor is: 
	- -1 (right subtree is one level taller)
	- 0 (both subtrees have equal height)
	- +1 (left subtree is one level taller) 

- A node becomes imbalanced if its balance factor is: 
	- +2 (left-heavy)
	- -2 (right-heavy) 

- When an imbalance occurs, AVL trees perform rotations to restore balance.
- Balance factor = Height(Left Subtree) - Height(Right Subtree)

| Balance Factor | Imbalance | Rotation |
|---------------:|-----------|----------|
| **+2** | Left-Left (LL) | **Right Rotation** |
| **+2** | Left-Right (LR) | **Left Rotation** on the left child, then **Right Rotation** on the unbalanced node |
| **-2** | Right-Right (RR) | **Left Rotation** |
| **-2** | Right-Left (RL) | **Right Rotation** on the right child, then **Left Rotation** on the unbalanced node |


---

- B-Trees: Unlike BSTs where each node has at most two children, B-Trees are "fat trees" where nodes can have many children and store multiple keys. They are designed for reading/writing large blocks of data such as databases, file systems, minimising expensive disk access, etc.