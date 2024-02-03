package ArraysAndLinkedLists.LinkedLists;

class LinkedListL{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node head, tail;
    LinkedListL(){
        this.head = null;
        this.tail = null;
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print(){
        Node travNode = head;
        while(travNode != null){
            System.out.print(travNode.data + " ");
            travNode = travNode.next;
        }
    }
}

public class LinkedList {
    public static void main(String[] args) {
        LinkedListL ll = new LinkedListL();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.print();
    }
}
