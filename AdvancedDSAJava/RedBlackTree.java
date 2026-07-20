package org.example;


class Node{
    int data;
    Node parent;
    Node left;
    Node right;
    int color; // 0 for black, 1 for red

}

public class RedBlackTree{
    private Node root;
    private Node TNUll; // Represents the leaves of a tree

    public RedBlackTree(){
        TNUll = new Node();
        TNUll.color = 0; // Leaves are always black
        TNUll.left = null;
        TNUll.right = null;
        root = TNUll;
    }

    private boolean isRedBlackTree(){
        if (root != TNUll && root.color != 0 )return false;

        return checkProperties(root) != -1;
    }
    private int checkProperties(Node node){
        if (node == TNUll) return 1; // Rule 3: Every child of a leaf node is black (NULL)

        // Check Red rule 4: If node is red, children must be black.
        if (node.color == 1){
            if ((node.left != TNUll && node.left.color == 1)
                || (node.right != TNUll && node.right.color == 1)){
                return -1;
            }
        }

        int leftBlackHeight = checkProperties(node.left);
        int rightBlackHeight = checkProperties(node.right);
        // If any subtree is invalid or heights don't match (Rule 5), return -1
        if (leftBlackHeight == -1 || rightBlackHeight == -1 || leftBlackHeight != rightBlackHeight){
            return -1;
        }

        return (node.color == 0) ? leftBlackHeight + 1 : leftBlackHeight;
    }

    // Recursive DFS: Post-order traversal (Left, Right, Node)
    public int height(Node node){
        if (node == null || node == TNUll){
            return -1;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Left rotation
    private void leftRotate(Node x){
        Node y = x.right;
        x.right = y.left; // The left subtree of y (if it exists) becomes the new right subtree of x
        if (y.left != TNUll){
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null){
            this.root = y;
        } else if (x == x.parent.left){
            x.parent.left=y;
        }
        else{
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    // Right Rotation
    private void rightRotate(Node x){
        Node y = x.left;
        x.left = y.right;
        if (y.right != TNUll){
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null){
            this.root = y;
        } else if (x == x.parent.right){
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;

    }

    // In order traversal: Left, root, right
    //Verification BSTProperty: After every rotation, perform an in order traversal.
    // If the sequence is sorted, rotation was successful.
    private int previousValue;
    private boolean isBST(){
        previousValue = Integer.MIN_VALUE;
        return isBSTRecursive(root);
    }
    private boolean isBSTRecursive(Node node){
        // Base case: hit a leaf or null, return true
        if (node == null || node == TNUll){
            return true;
        }

        //1. Traverse left
        if (!isBSTRecursive(node.left)){
            return false;
        }
        //2. Check current node.
        // If curr isn't larger than the one before it, it's not a BST
        if (node.data <= previousValue){
            return false;
        }
        previousValue = node.data;

        //3. Traverse right
        return isBSTRecursive(node.right);
    }

    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();

        Node x = new Node(); x.data = 10;
        Node y = new Node(); y.data = 20;
        Node z = new Node(); z.data = 15;

        rbt.root = x;
        x.right = y;
        y.parent = x;
        y.left = z;
        z.parent = y;

        // Ensure leaves point to null
        x.left = rbt.TNUll;
        y.right = rbt.TNUll;
        z.left = rbt.TNUll;
        z.right = rbt.TNUll;

        System.out.println("Before rotation, root is :" + rbt.root.data + "Right child is: " + rbt.root.right.data);

        // Perform a left rotation on x
        rbt.leftRotate(x);

        System.out.println(rbt.isRedBlackTree());

        // Show results
        System.out.println("After Left rotation, root is: " + rbt.root.data + "Left child is: " + rbt.root.left.data);

        System.out.println("Does RBL keep it's property (Check: in-order-traversal)? " + rbt.isBST());

        System.out.println("Trees height is: " + rbt.height(rbt.root));

        System.out.println(rbt.isBST());
    }
}