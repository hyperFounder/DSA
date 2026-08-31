package main.trees;

import java.util.*;

public class BFS{

    public static void main(String[] args) {
        BFS tree = new BFS();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        System.out.println(tree.levelOrderTree());
    }

    private TreeNode root;

    static class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    public void insert(int data){
        root = insertRecursive(root, data);
    }

    private TreeNode insertRecursive(TreeNode node, int data){
        if (node == null) return new TreeNode(data);
        if (data < node.val) node.left = insertRecursive(node.left, data);
        else node.right = insertRecursive(node.right, data);
        return node;
    }

    public List<List<Integer>> levelOrderTree(){
        return levelOrderTree(this.root);
    }

    public List<List<Integer>> levelOrderTree(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
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