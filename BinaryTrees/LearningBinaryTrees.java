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

    private int countNodesRec(Node root){
        if(root == null){
            return 0;
        }

        int leftNodes = countNodesRec(root.left);
        int rightNodes = countNodesRec(root.right);

        return leftNodes + rightNodes + 1;
    }

    public int countNodes(){
        return countNodesRec(root);
    }

    private int sumRec(Node root){
        if(root == null){
            return 0;
        }

        int leftSum = sumRec(root.left);
        int rightSum = sumRec(root.right);

        return leftSum + rightSum + root.data;
    }

    public int sum(){
        return sumRec(root);
    }

    // private int diamtereRec(Node root){
    //     if(root == null){
    //         return 0;
    //     }

    //     int leftDiam = diamtereRec(root.left);
    //     int leftHeight = heightRec(root.left);
    //     int rightDiam = diamtereRec(root.right);
    //     int rightHeight = heightRec(root.right);
    //     int incRootDiam = leftHeight + rightHeight + 1;
    //     return Math.max(incRootDiam, Math.max(leftDiam, rightDiam));
    // }
    // public int diameter(){
    //     return diamtereRec(root);
    // }

    class Info{
        int diam;
        int ht;
        Info(int diam, int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }
    private Info diameterRec(Node root){
        if(root == null){
            return new Info(0, 0);
        }

        Info leftInfo = diameterRec(root.left);
        Info righInfo = diameterRec(root.right);

        int diam = Math.max(Math.max(leftInfo.diam, righInfo.diam),leftInfo.ht + righInfo.ht + 1);
        int ht = Math.max(leftInfo.ht, righInfo.ht) + 1;
        return new Info(diam, ht);
    }

    public int diameter(){
        Info info = diameterRec(root);
        return info.diam;
    }

    public boolean isSubTree(Node subTree){
        return isSubTree(this.root, subTree);
    }

    private boolean isSubTree(Node root, Node subTree){
        if(root == null){
            return false;
        }

        if(root.data == subTree.data){
            if(isIdentical(root, subTree)){
                return true;
            }
        }

        return isSubTree(root.left, subTree) || isSubTree(root.right, subTree);
    }

    private boolean isIdentical(Node root, Node subTree){
        if(root == null && subTree == null ){
            return true;
        }
        else if(root == null || subTree == null || root.data != subTree.data){
            return false;
        }

        if(!isIdentical(root.left, subTree.left)){
            return false;
        }
        if(!isIdentical(root.right, subTree.right)){
            return false;
        }

        return true;
    }
}

public class LearningBinaryTrees {
    public static void main(String[] args) {
        int[] data = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1, 7, -1, -1};
        int[] data2 = {2, 4, -1, -1, 5, -1, -1};
        BinaryTreesB binaryTree = new BinaryTreesB();
        binaryTree.buildTree(data);

        BinaryTreesB subTree = new BinaryTreesB();
        subTree.buildTree(data2);
        subTree.preOrder();

        System.out.println(binaryTree.isSubTree(subTree.root));
    }
}
