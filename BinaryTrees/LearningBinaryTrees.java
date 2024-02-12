package BinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

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

    private void preOrderRec(Node root){
        if(root == null) {
            // System.out.print(-1 + " ");
            return;
        }
        System.out.print(root.data + " ");
        preOrderRec(root.left);
        preOrderRec(root.right);
    }

    public void preOrder(){
        preOrderRec(this.root);
        System.out.println();
    }

    private void inOrderRec(Node root){
        if(root == null){
            // System.out.print(-1 + " ");
            return;
        }
        inOrderRec(root.left);
        System.out.print(root.data + " ");
        inOrderRec(root.right);
    }

    public void inOrder(){
        inOrderRec(this.root);
        System.out.println();
    }

    private void postOrderRec(Node root){
        if(root == null){
            // System.out.print(-1 + " ");
            return;
        }
        postOrderRec(root.left);
        postOrderRec(root.right);
        System.out.print(root.data + " ");
    }

    public void postOrder(){
        postOrderRec(this.root);
        System.out.println();
    }

    public void levelOrderRec(){
        if(root == null) return;
        Queue<Node> node = new LinkedList<>();
        node.add(root);
        node.add(null);
        while (!node.isEmpty()) {
            Node currNode = node.remove();
            if(currNode == null){
                if(node.isEmpty()){
                    break;
                }
                else{
                    node.add(null);
                }
            }
            else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    node.add(currNode.left);
                }
                if(currNode.right != null){
                    node.add(currNode.right);
                }
            }
        }
        System.out.println();
    }

    private int heightRec(Node root){
        if(root == null){
            return 0;
        }

        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int height(){
        return heightRec(root);
    }

    private int findLeafRec(Node root){
        if(root == null){
            return 0;
        }

        if(root.left == null && root.right == null){
            return 1;
        }

        return findLeafRec(root.left) + findLeafRec(root.right);
    }

    public int findLeaves(){
        return findLeafRec(root);
    }
}

public class LearningBinaryTrees {
    public static void main(String[] args) {
        int[] data = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1, -1};
        BinaryTreesB binaryTree = new BinaryTreesB();
        binaryTree.buildTree(data);
        binaryTree.preOrder();
        binaryTree.inOrder();
        binaryTree.postOrder();
        binaryTree.levelOrderRec();
        System.out.println(binaryTree.height());
        System.out.println(binaryTree.findLeaves());
        // binaryTree.printTree();
    }
}
