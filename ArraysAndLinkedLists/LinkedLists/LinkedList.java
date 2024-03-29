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

    public int search(int key){
        if(length == 0){
            return -1;
        }

        Node temp = head;
        for (int i = 0; i < length; i++) {
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
        }

        return -1;
    }

    public void reverseList(){
        if(length == 0){
            System.out.println("Empty!");
            return;
        }
        Node prevNode = null;
        Node currNode = tail = head;
        while(currNode != null){
            Node nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;
    }

    public void removeNthNodeFromLast(int index){
        if(index == length){
            head = head.next;
            length--;
            return;
        }
        else if(index > length){
            System.out.println("Index out of bound");
            return;
        }
        int oriIndex = length - index;
        Node currNode = head;
        for (int i = 0; i < oriIndex-1; i++) {
            currNode = currNode.next;
        }
        Node nextNode = currNode.next;
        currNode.next = nextNode.next;
        length--;
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
        System.out.println();
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node midNode = getMid(head);
        Node rightHead = midNode.next;
        midNode.next = null;

        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        return merge(newLeft, newRight);
    }

    private Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private Node merge(Node left, Node right){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while (left != null && right != null) {
            if(left.data <= right.data){
                temp.next = left;
                left = left.next;
                temp = temp.next;
            }
            else{
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }

        while (left != null) {
            temp.next = left;
            left =  left.next;
            temp = temp.next;
        }

        while (right != null) {
            temp.next = right;
            right = right.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }

    public void zigZag(){
        Node mid = getMid(head);

        Node currNode = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (currNode != null) {
            next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }

        Node leftHead = head;
        Node rightHead = prev;
        Node leftNext;
        Node rightNext;

        while(leftHead != null && rightHead != null){
            leftNext = leftHead.next;
            rightNext = rightHead.next;
            leftHead.next = rightHead;
            rightHead.next = leftNext;

            leftHead = leftNext;
            rightHead = rightNext;
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
        ll.add(5);
        ll.print();
        ll.zigZag();
        ll.print();
    }
}
