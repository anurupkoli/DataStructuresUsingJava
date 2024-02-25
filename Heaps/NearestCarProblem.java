package Heaps;

import java.util.PriorityQueue;

class Cars implements Comparable<Cars>{
    int x;
    int y;
    int distance;
    int indx;

    Cars(int x, int y, int distance, int indx){
        this.x = x;
        this.y = y;
        this.distance = distance;
        this.indx = indx;
    }
    @Override
    public int compareTo(Cars o) {
        // TODO Auto-generated method stub
        return this.distance - o.distance;
    }
}

public class NearestCarProblem {
    public static void main(String[] args) {
        int[][] cars = {{3,3}, {5,-1}, {-2,4}};
        int k = 2;
        PriorityQueue<Cars> pq = new PriorityQueue<>();
        for (int i = 0; i < cars.length; i++) {
            int distance = (int)Math.pow(2, cars[i][0]) + (int)Math.pow(2, cars[i][1]);
            pq.add(new Cars(cars[i][0], cars[i][1], distance, i));
        }

        for (int i = 0; i < 2; i++) {
            System.out.println("C : " +  pq.remove().indx);
        }
    }
}
