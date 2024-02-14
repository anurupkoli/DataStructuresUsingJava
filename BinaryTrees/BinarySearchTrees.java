package BinaryTrees;

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
}

public class BinarySearchTrees {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        int[] arr = { 5, 1, 3, 4, 2, 7, 9, 10 };
        for (int i = 0; i < arr.length; i++) {
            tree.insertNode(arr[i]);
        }
        tree.inOrder();
        tree.delete(10);
        tree.inOrder();
    }
}
