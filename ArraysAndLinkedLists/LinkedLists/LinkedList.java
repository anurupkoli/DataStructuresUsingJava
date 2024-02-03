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
    public int length = 0;
    LinkedListL(){
        this.head = null;
        this.tail = null;
    }

    public void addFirst(int data){
        length++;
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
   
    public void add(int data){
        length++;
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int index, int data){
        length++;
        Node newNode = new Node(data);
        Node temp = head;
        if(index >= this.length || index < 0){
            System.out.println("Index out of bound");
            return;
        }
        if(index == 0){
            newNode.next = head;
            head = newNode;
            return;
        }
        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void print(){
        if(head == null){
            System.out.println("Empty!");
            return;
        }
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
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(0, 5);
        ll.print();
    }
}
