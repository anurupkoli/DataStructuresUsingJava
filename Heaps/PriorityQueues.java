package Heaps;
import java.util.*;

public class PriorityQueues{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(4);
        pq.add(1);
        pq.add(5);
        pq.add(3);
        System.out.println(pq.toString());
    }
}