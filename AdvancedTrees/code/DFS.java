import java.util.ArrayList;
import java.util.List;

public class TreeDFSTraversals {

    private TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    // =========================================================================
    // 1. PRE-ORDER TRAVERSAL (Root -> Left -> Right)
    // =========================================================================
    public List<Integer> preOrder() {
        List<Integer> result = new ArrayList<>();
        preOrderRecursive(this.root, result);
        return result;
    }

    private void preOrderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) return;

        result.add(node.val);               // 1. Visit Root
        preOrderRecursive(node.left, result);  // 2. Visit Left
        preOrderRecursive(node.right, result); // 3. Visit Right
    }

    // =========================================================================
    // 2. IN-ORDER TRAVERSAL (Left -> Root -> Right)
    // =========================================================================
    public List<Integer> inOrder() {
        List<Integer> result = new ArrayList<>();
        inOrderRecursive(this.root, result);
        return result;
    }

    private void inOrderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) return;

        inOrderRecursive(node.left, result);   // 1. Visit Left
        result.add(node.val);               // 2. Visit Root
        inOrderRecursive(node.right, result);  // 3. Visit Right
    }

    // =========================================================================
    // 3. POST-ORDER TRAVERSAL (Left -> Right -> Root)
    // =========================================================================
    public List<Integer> postOrder() {
        List<Integer> result = new ArrayList<>();
        postOrderRecursive(this.root, result);
        return result;
    }

    private void postOrderRecursive(TreeNode node, List<Integer> result) {
        if (node == null) return;

        postOrderRecursive(node.left, result);  // 1. Visit Left
        postOrderRecursive(node.right, result); // 2. Visit Right
        result.add(node.val);               // 3. Visit Root
    }

    // Helper method to insert into BST
    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private TreeNode insertRecursive(TreeNode curr, int data) {
        if (curr == null) {
            return new TreeNode(data);
        }
        if (data < curr.val) {
            curr.left = insertRecursive(curr.left, data);
        } else {
            curr.right = insertRecursive(curr.right, data);
        }
        return curr;
    }

    // =========================================================================
    // MAIN METHOD
    // =========================================================================
    public static void main(String[] args) {
        TreeDFSTraversals tree = new TreeDFSTraversals();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(10); // Duplicate goes to right child of 10

        /*
              Tree Structure:
                    10
                   /  \
                  5    15
                      /
                     10
        */

        System.out.println("Pre-Order  (Root -> Left -> Right): " + tree.preOrder());
        // Output: [10, 5, 15, 10]

        System.out.println("In-Order   (Left -> Root -> Right): " + tree.inOrder());
        // Output: [5, 10, 10, 15]  (Notice: In-order on a BST gives sorted order!)

        System.out.println("Post-Order (Left -> Right -> Root): " + tree.postOrder());
        // Output: [5, 10, 15, 10]
    }
}
