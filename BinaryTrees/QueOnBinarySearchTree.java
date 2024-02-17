package BinaryTrees;

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
    Node root;
    QueOnTree(){
        this.size = 0;
        this.root = null;
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
    }
}

public class QueOnBinarySearchTree {
    public static void main(String[] args) {
        int[] arr = {3,4,5,6,8,9,10};
        QueOnTree tree = new QueOnTree();
        tree.sortedArrayTree(arr);
        tree.preOrder();
    }
}
