package BinaryTrees;

import java.util.ArrayList;

class QueOnTree{
    class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    int size;
    int indx;
    Node root;
    QueOnTree(){
        this.size = 0;
        this.root = null;
        this.indx = -1;
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

    //Minimum Height Tree for sorter arrays
    private Node sortedArrayTreeRec(int[] arr, int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end - start)/2;
        Node root = new Node(arr[mid]);
        root.left = sortedArrayTreeRec(arr, start, mid-1);
        root.right = sortedArrayTreeRec(arr, mid+1, end);

        return root;
    }

    public void sortedArrayTree(int[] arr){
        this.root = sortedArrayTreeRec(arr, 0, arr.length-1);
    }
    private Node sortedArrayTreeRec(ArrayList<Integer> arr, int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end - start)/2;
        Node root = new Node(arr.get(mid));
        root.left = sortedArrayTreeRec(arr, start, mid-1);
        root.right = sortedArrayTreeRec(arr, mid+1, end);

        return root;
    }

    public void sortedArrayTree(ArrayList<Integer> arr){
        this.root = sortedArrayTreeRec(arr, 0, arr.size()-1);
    }

    private Node buildTreeRec(int[] arr) {
        indx++;
        if (arr[indx] == -1) {
            return null;
        }

        Node newNode = new Node(arr[indx]);
        newNode.left = buildTreeRec(arr);
        newNode.right = buildTreeRec(arr);
        return newNode;
    }

    public void buildTree(int[] arr) {
        this.root = buildTreeRec(arr);
    }

    private void preOrderRec(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrderRec(root.left);
        preOrderRec(root.right);
    }

    public void preOrder(){
        preOrderRec(root);
        System.out.println();
    }
    private void inOrderRec(Node root){
        if(root == null){
            return;
        }
        inOrderRec(root.left);
        System.out.print(root.data + " ");
        inOrderRec(root.right);
    }

    public void inOrder(){
        inOrderRec(root);
        System.out.println();
    }

    private void returnArray(Node root, ArrayList<Integer> arrayList){
        if(root == null){
            return;
        }
        returnArray(root.left, arrayList);
        arrayList.add(root.data);
        returnArray(root.right, arrayList);
    }

    public ArrayList<Integer> returnArrayList(){
        ArrayList<Integer> arr = new ArrayList<>();
        returnArray(root, arr);
        return arr;
    }

    private void convertToBSTRec(Node root){
        ArrayList<Integer> inOrder = new ArrayList<>();
        returnArray(root, inOrder);
        sortedArrayTree(inOrder);
    }

    public void convertToBST(){
        convertToBSTRec(this.root);
    }
}

public class QueOnBinarySearchTree {
    public static void main(String[] args) {
        int[] data = {8,6,5,3,10,11,12};
        QueOnTree tree = new QueOnTree();
        for (int i = 0; i < data.length; i++) {
            tree.insertNode(data[i]);
        }
        tree.preOrder();
        tree.convertToBST();
        tree.preOrder();
    }
}
