package Heaps;

import java.util.PriorityQueue;

public class CostOfConnectingNRopes {
    public static void main(String[] args) {
        int[] ropes = {6, 4, 3, 3, 2};
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        for (int i = 0; i < ropes.length; i++) {
            System.out.print(" " + pq.remove());
        }
        System.out.println();
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost += min1 + min2;
            pq.add(min1 + min2);
        }

        System.out.println("Minimum Cost: " + cost);
    }
}
