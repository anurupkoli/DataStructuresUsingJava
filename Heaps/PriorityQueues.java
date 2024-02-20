package Heaps;
import java.util.*;

class Student implements Comparable<Student>{
    int rank;
    String name;

    Student(String name, int rank){
        this.name = name;
        this.rank = rank;
    }

    @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub
        return this.rank - o.rank;
    }

}

public class PriorityQueues{
    public static void main(String[] args) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        pq.add(new Student("A", 12));
        pq.add(new Student("B", 1));
        pq.add(new Student("C", 2));
        pq.add(new Student("D", 13));
        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);
            pq.remove();
        }
    }
}