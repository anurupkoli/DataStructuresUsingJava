package Heaps;

import java.util.PriorityQueue;

class Soldiers implements Comparable<Soldiers>{
    int count;
    int indx;
    Soldiers(int count, int indx){
        this.count = count;
        this.indx = indx;
    }
    @Override
    public int compareTo(Soldiers o) {
        if(o.count == this.count){
            return this.indx - o.indx;
        }
        else{
            return this.count - o.count;
        }
    }
}

public class WeakestSoldier {
    public static void main(String[] args) {
        int[][] army = {
            {1,0,0,0},
            {1,1,1,1}, 
            {1,0,0,0},
            {1,0,0,0}
        };

        int k = 2;

        PriorityQueue<Soldiers> pq = new PriorityQueue<>();
        for (int i = 0; i < army.length; i++) {
            int count = 0;
            for (int j = 0; j < army.length; j++) {
                if(army[i][j] == 1){
                    count++;
                }
            }
            pq.add(new Soldiers(count, i));
        }

        System.out.print("Weakest Solidiers are: ");
        for (int i = 0; i < k; i++) {
            System.out.print(pq.remove().indx + " ");
        }
        System.out.println();
    }
}
