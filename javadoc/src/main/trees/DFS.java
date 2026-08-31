package main.trees;

import java.util.*;

public class DFS{

    private TreeNode root;

    static class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int val){
            this.val = val;
        }
    }


    public void insert(int data){
        root = insertRecursive(this.root, data);
    }

    private TreeNode insertRecursive(TreeNode node, int data){
        if (node == null) return new TreeNode(data);
        if (data < node.val) node.left = insertRecursive(node.left, data);
        else node.right = insertRecursive(node.right, data);
        return node;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> result){
        if (node == null) return;
        inOrderTraversal(node.left, result);
        result.add(node.val);
        inOrderTraversal(node.right, result);
    }

    public List<Integer> inOrder(){
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(this.root, result);
        return result;
    }

    private void preOrderTraversal(TreeNode node, List<Integer> result){
        if (node == null) return;
        result.add(node.val);
        preOrderTraversal(node.left, result);
        preOrderTraversal(node.right, result);
    }

    public List<Integer> preOrder(){
        List<Integer> result = new ArrayList<>();
        preOrderTraversal(this.root, result);
        return result;
    }

    private void postOrderTraversal(TreeNode node, List<Integer> result){
        if (node == null) return;
        postOrderTraversal(node.left, result);
        postOrderTraversal(node.right, result);
        result.add(node.val);
    }

    public List<Integer> postOrder(){
        List<Integer> result = new ArrayList<>();
        postOrderTraversal(this.root, result);
        return result;
    }

    public static void main(String[] args) {
        DFS tree = new DFS();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        System.out.println(tree.inOrder());
        System.out.println(tree.postOrder());
        System.out.println(tree.preOrder());
    }
}