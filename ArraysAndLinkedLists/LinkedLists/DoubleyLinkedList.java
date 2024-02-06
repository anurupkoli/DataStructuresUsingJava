package ArraysAndLinkedLists.LinkedLists;

class DoublyLL{
    class Node {
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public Node head;
    public Node tail;
    public int length;

    DoublyLL(){
        this.head = null;
        this.tail = null;
        length = 0;
    }

    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            length++;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        length++;
    }

    public void removeFirst(){
        if(head == null){
            System.out.println("Empty!");
            return;
        }
        else if(head.next == null){
            head = tail = null;
            length--;
            return;
        }

        head = head.next;
        head.prev = null;
        length--;
    }

    public void print(){
        Node tempNode = head;
        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
        System.out.println();
    }

    public void reverseList(){
        if(head == null){
            return;
        }

        Node currNode = head;
        Node prev = null;
        Node next;

        while(currNode != null){
            next = currNode.next;
            currNode.next = prev;
            currNode.prev = next;
            prev = currNode;
            currNode = next;
        }
        
        head = prev;
    }
}

public class DoubleyLinkedList {
    public static void main(String[] args) {
        DoublyLL ll = new DoublyLL();
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(3);
        ll.addFirst(4);
        ll.print();
        ll.reverseList();
        ll.print();
    }
}
