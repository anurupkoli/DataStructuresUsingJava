package BinaryTrees;

import java.util.ArrayList;

class BinarySearchTree {
    /**
     * Node
     */
    public class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        this.root = null;
    }

    private Node insertNodeRec(Node root, int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return root;
        }
        if (data < root.data) {
            root.left = insertNodeRec(root.left, data);
        }
        if (data > root.data) {
            root.right = insertNodeRec(root.right, data);
        }
        return root;
    }

    public void insertNode(int data) {
        root = insertNodeRec(this.root, data);
    }

    private void inOrderRec(Node root) {
        if (root == null) {
            return;
        }
        inOrderRec(root.left);
        System.out.print(root.data + " ");
        inOrderRec(root.right);
    }

    public void inOrder() {
        inOrderRec(root);
        System.out.println();
    }
    private void preOrderRec(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrderRec(root.left);
        preOrderRec(root.right);
    }

    public void preOrder() {
        preOrderRec(root);
        System.out.println();
    }

    private boolean searchRec(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (key < root.data) {
            return searchRec(root.left, key);
        } else if (key > root.data) {
            return searchRec(root.right, key);
        } else if (key == root.data) {
            return true;
        }
        return false;
    }

    public boolean search(int key) {
        return searchRec(root, key);
    }

    private Node deleteRec(Node root, int data) {
        if(root == null){
            return null;
        }
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        }
        if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }

            Node InorSucc = findInorderSuccessor(root.right);
            root.data = InorSucc.data;
            root.right = deleteRec(root.right, InorSucc.data);
        }

        return root;
    }

    private Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public void delete(int key) {
       root = deleteRec(root, key);
    }

    private void printInRangeRec(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(root.data >= k1 && root.data <= k2){
            printInRangeRec(root.left, k1, k2);;
            System.out.print(root.data + " ");
            printInRangeRec(root.right, k1, k2);
        }
        else if(root.data < k1){
            printInRangeRec(root.left, k1, k2);
        }
        else{
            printInRangeRec(root.right, k1, k2);
        }
    }

    public void printInRange(int k1, int k2){
        printInRangeRec(root, k1, k2);
    }

    private void printRoute2LeafRec(Node root, ArrayList<Integer> list){
        if(root == null){
            return;
        }

        list.add(root.data);

        if(root.left == null && root.right == null){
            System.out.println(list.toString());
        }

        printRoute2LeafRec(root.left, list);
        printRoute2LeafRec(root.right, list);
        list.remove(list.size()-1);
    }

    public void printRoute2Leaf(){
        printRoute2LeafRec(root, new ArrayList<>());
    }

    private boolean isValidRec(Node root, Node min, Node max){
        if(root == null){
            return true;
        }
        if(min != null && root.data <= min.data){
            return false;
        }
        else if(max != null && root.data >= max.data){
            return false;
        }

        return isValidRec(root.left, min, root) && isValidRec(root.right, root, max);
    }

    public boolean isValid(){
        return isValidRec(root, null, null);
    }

    private Node mirrorRec(Node root){
        if(root == null){
            return null;
        }

        Node right = mirrorRec(root.right);
        Node left = mirrorRec(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

    public void mirror(){
        root = mirrorRec(root);
    }
}

public class BinarySearchTrees {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] arr = { 8,5,10,3,6,11 };
        for (int i = 0; i < arr.length; i++) {
            tree.insertNode(arr[i]);
        }

        tree.preOrder();
        tree.mirror();
        tree.preOrder();
    }
}
