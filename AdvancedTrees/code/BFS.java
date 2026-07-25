import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    private TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int data) {
            this.val = data;
        }
    }

    public static void main(String[] args) {
        BFS tree = new BFS();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(10); // Duplicate handled properly now

        // Call the parameterless helper method
        List<List<Integer>> levels = tree.levelOrder();
        System.out.println(levels); // Output: [[10], [5, 15], [10]]
    }

    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private TreeNode insertRecursive(TreeNode curr, int data) {
        if (curr == null) {
            return new TreeNode(data);
        }
        if (data < curr.val) {
            curr.left = insertRecursive(curr.left, data);
        } else { // Allows duplicates on the right side
            curr.right = insertRecursive(curr.right, data);
        }
        return curr;
    }

    // Convenience wrapper so callers don't need access to root
    public List<List<Integer>> levelOrder() {
        return levelOrder(this.root);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = queue.poll();
                currLevel.add(curr.val);

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
            result.add(currLevel);
        }
        return result;
    }
}
