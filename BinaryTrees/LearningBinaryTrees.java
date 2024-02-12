package BinaryTrees;

class BinaryTreesB {
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

    public Node root;
    private int indx;
    BinaryTreesB(){
        this.root = null;
        this.indx = -1;
    }

    private Node buildTreeRec(int[] arr){
        indx++;
        if(arr[indx] == -1){
            return null;
        }

        Node newNode = new Node(arr[indx]);
        newNode.left = buildTreeRec(arr);
        newNode.right = buildTreeRec(arr);
        return newNode;
    }

    public void buildTree(int[] arr){
        this.root = buildTreeRec(arr);
    }

    private void printTreeRec(Node root){
        if(root == null) {
            System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.data + " ");
        printTreeRec(root.left);
        printTreeRec(root.right);
    }

    public void printTree(){
        printTreeRec(this.root);
        System.out.println();
    }
}

public class LearningBinaryTrees {
    public static void main(String[] args) {
        int[] data = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1, -1};
        BinaryTreesB binaryTree = new BinaryTreesB();
        binaryTree.buildTree(data);
        binaryTree.printTree();
        // binaryTree.printTree();
    }
}
