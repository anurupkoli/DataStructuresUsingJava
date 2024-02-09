package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class Interleave2HalvesOfArray {
    public static void interleave(Queue<Integer> que){
        Queue<Integer> leftHalfQue = new LinkedList<>();
        Queue<Integer> rightHalfQue = new LinkedList<>();
        int n = que.size()/2;
        for (int i = 0; i < n; i++) {
            leftHalfQue.add(que.remove());
        }

        for (int i = 0; i < n; i++) {
            rightHalfQue.add(que.remove());
        }
        
        for (int i = 0; i < n; i++) {
            que.add(leftHalfQue.remove());
            que.add(rightHalfQue.remove());            
        }
    }
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);
        interleave(queue);
        System.out.println(queue.toString());
    }
}
