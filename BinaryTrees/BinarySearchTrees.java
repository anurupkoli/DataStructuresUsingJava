package BinaryTrees;

class BinarySearchTree{
    /**
     *  Node
     */
    public class Node {
    
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    Node root;
    BinarySearchTree(){
        this.root = null;
    }

    private Node insertNodeRec(Node root, int data){
        Node newNode = new Node(data);
        if(root == null){
            root = newNode;
            return root;
        }
        if(data < root.data){
            root.left = insertNodeRec(root.left, data);
        }
        if(data > root.data){
            root.right = insertNodeRec(root.right, data);
        }
        return root;
    }

    public void insertNode(int data){
        root = insertNodeRec(this.root, data);
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
}

public class BinarySearchTrees {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] arr = {5,1,3,4,2,7};
        for (int i = 0; i < arr.length; i++) {
            tree.insertNode(arr[i]);
        }
        tree.inOrder();
    }
}
