package Heaps;

import java.util.PriorityQueue;

class Sliding implements Comparable<Sliding>{
    int val;
    int indx;
    Sliding(int val, int indx){
        this.val = val;
        this.indx = indx;
    }

    @Override
    public int compareTo(Sliding sl2){
        return sl2.val - this.val;
    }
}

public class SlidingWindow {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        PriorityQueue<Sliding> pq = new PriorityQueue<>();
        int[] res = new int[arr.length - k + 1];
        
        for (int i = 0; i < k; i++) {
            pq.add(new Sliding(arr[i], i));
        }

        res[0] = pq.peek().val;

        for (int i = k; i < arr.length; i++) {
            while (pq.size() > 0 && pq.peek().indx <= (i-k)) {
                pq.remove();
            }
            pq.add(new Sliding(arr[i], i));
            res[i - k + 1] = pq.peek().val;
        }

        for (int i = 0; i < res.length; i++) {
            System.out.print(pq.remove().val + " ");
        }

        System.out.println();
    }
}
