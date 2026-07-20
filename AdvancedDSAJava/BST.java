package org.example;

public class BST {
    private Node root;
    private static class Node{
        int data;
        Node left, right;

        Node (int data){
            this.data = data;
        }
    }

    public void insert(int data){
        root = insertRecursive(root, data);
    }
    private Node insertRecursive(Node curr, int data){
        if (curr == null){
            return new Node(data);
        }
        if (data < curr.data) curr.left = insertRecursive(curr.left, data);
        else if (data > curr.data) curr.right = insertRecursive(curr.right, data);
        return curr;
    }

    public boolean search(int data){
        return searchRecursive(root, data);
    }

    // DFS
    private boolean searchRecursive(Node curr, int data){
        if (curr == null) return false;
        if (data == curr.data) return true;
        return data < curr.data ?
                searchRecursive(curr.left, data)
                : searchRecursive(curr.right, data);
    }

    public void delete(int data){
        root = deleteRecursive(root, data);
    }
    private Node deleteRecursive(Node curr, int data){
        if (curr == null) return null;
        if (data < curr.data){
            curr.left = deleteRecursive(curr.left, data);
        } else if(data > curr.data){
            curr.right = deleteRecursive(curr.right, data);
        } else{
            // case 1: leaf node
            if (curr.left == null && curr.right == null) return null;
            if (curr.left == null) return curr.right; // case 2: only right child
            if (curr.right == null) return curr.left; // case 3: only left child
            // case 4: Node has two children. Find the smallest value in the right subtree
            // (in order traversal) and replace such smallest value with the node
            curr.data = findSmallestValue(curr.right);
            curr.right = deleteRecursive(curr.right, curr.data);
        }
        return curr;
    }

    private int findSmallestValue(Node node){
        return node.left == null ? node.data : findSmallestValue(node.left);
    }

    public void printRecursive(){
        inOrderTraversal(root);
    }

    // Printing: DFS In order traversal (Left, Root, Right)
    private void inOrderTraversal(Node node){
        if (node == null) return;
        inOrderTraversal(node.left); // Left
        System.out.println(node.data + " "); // Root
        inOrderTraversal(node.right); // Right
    }

    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(10);
        tree.insert(15);
        tree.insert(20);

        tree.printRecursive();

        tree.delete(15);
        tree.printRecursive();

    }
}
