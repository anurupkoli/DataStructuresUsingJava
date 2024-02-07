package Stacks;

class StackLL{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public int size;
    StackLL(){
        this.head = null;
        size = 0;
    }

    public boolean isEmpty(){
        return head ==  null;
    }

    public void push(int data){
        Node newNode = new Node(data);
        if(isEmpty()){
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public int pop(){
        if(isEmpty()){
            return -1;
        }

        int data = head.data;
        head = head.next;
        return data;
    }

    public int peek(){
        if(isEmpty()){
            return -1;
        }

        return head.data;
    }
}

public class StacksUsingLinkedLists {
    public static void main(String[] args) {
        
    }
}
