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

    class Info{
        boolean isBST;
        int size;
        int max;
        int min;
        Info(boolean isBST, int size, int max, int min){
            this.isBST = false;
            this.size = 0;
            this.max = 0;
            this.min = 0;
        }
    }
    static int maxBST = 0;
    private Info largestBSTRec(Node root){
        if(root == null){
            return new Info(true, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        Info leftInfo = largestBSTRec(root.left);
        Info righInfo = largestBSTRec(root.right);
        int size = leftInfo.size + righInfo.size + 1;
        int min = Math.min(root.data, Math.min(leftInfo.min, righInfo.min));
        int max = Math.max(root.data, Math.max(leftInfo.max, righInfo.max));

        if(root.data <= leftInfo.max && root.data >= righInfo.min){
            return new Info(false, size, max, min);
        }

        if(leftInfo.isBST && righInfo.isBST){
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, max, min);
        }

        return new Info(false, size, max, min);
    }

    public void largestBST(){
        Info info = largestBSTRec(root);
    }


    private Node mergeBSTRec(Node root1, Node root2){
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> finalArray = new ArrayList<>();

        returnArray(root1, arr1);
        returnArray(root2, arr2);

        int i=0, j=0;
        while (i<arr1.size() && j<arr2.size()) {
            if(arr1.get(i) <= arr2.get(j)){
                finalArray.add(arr1.get(i));
                i++;
            }
            else{
                finalArray.add(arr2.get(j));
                j++;
            }
        }

        while (i<arr1.size()) {
            finalArray.add(arr1.get(i));
            i++;
        }

        while (j<arr2.size()) {
            finalArray.add(arr2.get(j));
            j++;
        }

        return sortedArrayTreeRec(finalArray, 0, finalArray.size()-1);
    }

    public void mergeBST(Node root1, Node root2){
        this.root = mergeBSTRec(root1, root2);
    }
}

public class QueOnBinarySearchTree {
    public static void main(String[] args) {
        int[] data1 = {2,1,4};
        int[] data2 = {9,3,12};
        QueOnTree tree1 = new QueOnTree();
        QueOnTree tree2 = new QueOnTree();
        for (int i = 0; i < data2.length; i++) {
            tree1.insertNode(data1[i]);
            tree2.insertNode(data2[i]);
        }

        QueOnTree tree3 = new QueOnTree();
        tree3.mergeBST(tree1.root, tree2.root);
        tree3.inOrder();
    }
}
