package main.trees;

import java.util.ArrayList;
import java.util.List;

public class TreeDFSTraversals {

    public static void main(String[] args) {
        TreeDFSTraversals tree = new TreeDFSTraversals();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(10);

        System.out.println("Pre-order: " + tree.preOrder());
        System.out.println("IN-order: " + tree.inOrder());
        System.out.println("Post-order: " + tree.postOrder());

        int a = 4;
        int b = 10;

        System.out.println(a);
        System.out.println(b);

        System.out.println("swapping");

        int temp = a; // temp = 4
        a = b; // a = 10;
        b = temp; // b = 4
        System.out.println(a);
        System.out.println(b);
    }

    private TreeNode root;

    static class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    // In order traversal (Left, root, right)
    public List<Integer> inOrder(){
        List<Integer> result = new ArrayList<>();
        inOrderRecursive(this.root, result);
        return result;
    }
    private void inOrderRecursive(TreeNode node, List<Integer> result){
        if (node == null) return;
        inOrderRecursive(node.left, result);
        result.add(node.val);
        inOrderRecursive(node.right, result);
    }

    public List<Integer> postOrder(){
        List<Integer> result = new ArrayList<>();
        postOrderRecursive(this.root, result);
        return result;
    }

    public List<Integer> preOrder(){
        List<Integer> result = new ArrayList<>();
        preOrderTraversal(this.root, result);
        return result;
    }
    // Left, right, root
    private void postOrderRecursive(TreeNode node, List<Integer> result){
        if (node == null) return;
        postOrderRecursive(node.left, result);
        postOrderRecursive(node.right, result);
        result.add(node.val);
    }

    private void preOrderTraversal(TreeNode node, List<Integer> result){
        if (node == null) return;
        // Root, left, right
        result.add(node.val);
        preOrderTraversal(node.left, result);
        preOrderTraversal(node.right, result);
    }




    public void insert(int data){
        root = insertRecursive(root, data);
    }

    private TreeNode insertRecursive(TreeNode node, int val){

        if (node == null) return new TreeNode(val);
        if (val < node.val) node.left = insertRecursive(node.left, val);
        else{
            node.right = insertRecursive(node.right, val);
        }
        return node;
    }
}
