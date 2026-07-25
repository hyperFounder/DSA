import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFS {

    // =========================================================================
    // 1. BINARY TREE IMPLEMENTATION
    // =========================================================================

    private TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left, right;

        public TreeNode(int data) {
            this.val = data;
        }
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
        } else {
            curr.right = insertRecursive(curr.right, data);
        }
        return curr;
    }

    public List<List<Integer>> levelOrderTree() {
        return levelOrderTree(this.root);
    }

    public List<List<Integer>> levelOrderTree(TreeNode root) {
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

    // =========================================================================
    // 2. GRAPH IMPLEMENTATION (STANDARD FLAT BFS)
    // =========================================================================

    static class GraphNode {
        int val;
        List<GraphNode> neighbors;

        public GraphNode(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }

        public void addNeighbor(GraphNode neighbor) {
            this.neighbors.add(neighbor);
        }
    }

    /**
     * Standard Graph BFS returning a flat order of visited nodes.
     */
    public static List<Integer> standardGraphBFS(GraphNode startNode) {
        List<Integer> result = new ArrayList<>();
        if (startNode == null) return result;

        Queue<GraphNode> queue = new LinkedList<>();
        Set<GraphNode> visited = new HashSet<>();

        // 1. Initialize queue and visited set with starting node
        queue.offer(startNode);
        visited.add(startNode);

        // 2. Process elements sequentially without level snapshotting
        while (!queue.isEmpty()) {
            GraphNode curr = queue.poll();
            result.add(curr.val);

            for (GraphNode neighbor : curr.neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor); // Mark visited BEFORE enqueuing
                    queue.offer(neighbor);
                }
            }
        }
        return result;
    }

    // =========================================================================
    // MAIN METHOD
    // =========================================================================

    public static void main(String[] args) {
        // --- 1. Test Tree BFS ---
        System.out.println("--- TREE LEVEL ORDER BFS ---");
        BFS tree = new BFS();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(10); // Duplicate

        List<List<Integer>> treeLevels = tree.levelOrderTree();
        System.out.println(treeLevels); // Output: [[10], [5, 15], [10]]

        // --- 2. Test Graph BFS ---
        System.out.println("\n--- STANDARD GRAPH BFS ---");

        // Build a graph with a cycle: 1 -> 2, 1 -> 3, 2 -> 4, 3 -> 4, 4 -> 1
        GraphNode g1 = new GraphNode(1);
        GraphNode g2 = new GraphNode(2);
        GraphNode g3 = new GraphNode(3);
        GraphNode g4 = new GraphNode(4);

        g1.addNeighbor(g2);
        g1.addNeighbor(g3);
        g2.addNeighbor(g4);
        g3.addNeighbor(g4);
        g4.addNeighbor(g1); // Creates a cycle back to start

        List<Integer> graphOrder = standardGraphBFS(g1);
        System.out.println(graphOrder); // Output: [1, 2, 3, 4]
    }
}
