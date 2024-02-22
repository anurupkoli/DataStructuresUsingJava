package Heaps;

import java.util.ArrayList;

class HeapClassNew{
    ArrayList<Integer> arr;
    HeapClassNew(){
        this.arr = new ArrayList<>();
    }

    public void insert(int data){
        arr.add(data);
        int parentIndex = (arr.size()-2)/2;
        int childIndex = arr.size()-1;
        while (arr.get(childIndex) < arr.get(parentIndex)) {
            int temp = arr.get(childIndex);
            arr.set(childIndex, arr.get(parentIndex));
            arr.set(parentIndex, temp);
        }
    }
}

public class HeapClass {
    public static void main(String[] args) {
        HeapClassNew heap = new HeapClassNew();
        heap.insert(1);
        heap.insert(8);
        heap.insert(5);
        heap.insert(6);
        heap.insert(3);
        System.out.println(heap.arr.toString());
    }
}
