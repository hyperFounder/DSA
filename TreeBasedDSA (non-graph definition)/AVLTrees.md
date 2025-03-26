## AVL Tree

An **AVL Tree** (Adelson-Velsky and Landis Tree) is a self-balancing binary search tree. 

- The **balance factor** of a node is (height of left subtree - height of right subtree) or (height of right Subtree - height of left Subtree)

![Screenshot 2025-03-24 at 22 54 19](https://github.com/user-attachments/assets/306227f0-5b17-44b0-8a8a-dd215a17b43e)

### Properties of AVL Tree:
- **Self-Balancing**: After every insertion or deletion, the tree automatically balances itself to ensure optimal search time.
- **Balance Factor**: The difference in heights between the left and right subtrees of any node must be -1, 0, or 1.
- **Height of AVL Tree**: The height of an AVL tree is guaranteed to be logarithmic in the number of nodes (`O(log n)`).

### Rotations in AVL Tree:
When the balance factor of any node becomes outside the allowed range (-1, 0, 1), rotations are performed to restore the balance. There are four types of rotations:
1. **Right Rotation**: Used when the left subtree of the left child is too heavy.
2. **Left Rotation**: Used when the right subtree of the right child is too heavy.
3. **Left-Right Rotation**: A combination of left and right rotations.
4. **Right-Left Rotation**: A combination of right and left rotations.
