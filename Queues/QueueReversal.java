package Queues;
import java.util.*;

public class QueueReversal {
    public static void reverseQueue(Queue<Integer> que){
        Stack<Integer> st = new Stack<>();
        while (!que.isEmpty()) {
            st.push(que.remove());
        }
        while (!st.isEmpty()) {
            que.add(st.pop());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        que.add(2);
        que.add(3);
        que.add(4);
        que.add(5);
        reverseQueue(que);
        System.out.println(que.toString());
    }
}
