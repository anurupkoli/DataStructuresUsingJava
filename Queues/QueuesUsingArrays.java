package Queues;

class QueueArr{
    int[] arr;
    int size;
    int rear;
    QueueArr(int n){
        arr = new int[n];
        size = n;
        rear = -1;
    }

    public boolean isEmpty(){
        return rear == -1;
    }

    public void add(int data){
        if(rear == size - 1){
            System.out.println("Full!");
            return;
        }
        rear++;
        arr[rear] = data;
    }

    public int remove(){
        if(isEmpty()){
            return -1;
        }
        int data = arr[0];
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i+1];
        }
        rear--;
        return data;
    }
    
    public void print(){
        if(isEmpty()){
            System.out.println("Empty!");
            return;
        }
        for (int i = 0; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

public class QueuesUsingArrays{
    public static void main(String[] args) {
        QueueArr arr = new QueueArr(5);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.remove();
        arr.print();
    }
}