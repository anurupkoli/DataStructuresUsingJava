package Queues;


class QueuesLL{
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    Node front;
    Node rear;
    int size;
    QueuesLL(){
        this.front = null;
        this.rear = null;
        size = 0;
    }

    public boolean isEmpty(){
        return rear == null;
    }

    public void add(int data){
        Node newNode = new Node(data);
        size++;
        if(isEmpty()){
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public int remove(){
        if(isEmpty()){
            return -1;
        }
        size--;
        int data = front.data;
        front = front.next;
        return data;
    }

    public void print(){
        if(isEmpty()){
            System.out.println("Empty!");
            return;
        }

        Node tempNode = front;
        while(tempNode != null){
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.next;
        }
    }
}

public class QueuesUsingLinkedLists {
    public static void main(String[] args) {
        QueuesLL que = new QueuesLL();
        que.add(1);
        que.add(2);
        que.add(3);
        que.remove();
        que.print();
    }
}
