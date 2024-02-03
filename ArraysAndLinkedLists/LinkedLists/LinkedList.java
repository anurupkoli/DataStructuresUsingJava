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
    public int length;
    LinkedListL(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(length == 0){
            head = tail = newNode;
            length++;
            return;
        }
        length++;
        newNode.next = head;
        head = newNode;
    }
   
    public void add(int data){
        Node newNode = new Node(data);
        if(length == 0){
            head = tail = newNode;
            length++;
            return;
        }
        length++;
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int index, int data){
        if(index > this.length || index < 0){
            System.out.println("Index out of bound");
            return;
        }
        if(index == 0){
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        length++;
        for (int i = 0; i < index-1; i++) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void removeFirst(){
        if(length == 0){
            System.out.println("Empty!");
            return;
        }
        else if(length == 1){
            head = tail = null;
            length = 0;
            return;
        }
        length--;
        head = head.next;
    }

    public void removeLast(){
        if(length == 0){
            System.out.println("Empty!");
            return;
        }
        else if(length == 1){
            head = tail = null;
            length = 0;
            return;
        }
        length--;
        Node prevNode = head;
        int i = 0;
        while (i < length-1) {
            prevNode = prevNode.next;
            i++;
        };
        prevNode.next = null;
        tail = prevNode;
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
        ll.add(4);
        ll.removeLast();
        ll.print();
    }
}
