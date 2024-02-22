package Heaps;

import java.util.*;

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
            childIndex = parentIndex;
            parentIndex = (childIndex-1)/2;
        }
    }

    public int peek(){
        return arr.get(0);
    }

    public void remove(){
        int temp = arr.get(arr.size()-1);
        arr.set(arr.size()-1, arr.get(0));
        arr.set(0, temp);

        arr.remove(arr.size()-1);

        heapify(0);
    }
    private void heapify(int i){
        int left = 2*i + 1;
        int right = 2*i + 2;
        int minIndx = i;

        if(left < arr.size() && arr.get(minIndx) > arr.get(left)){
            minIndx = left;
        }
        if(right < arr.size() && arr.get(minIndx) > arr.get(right)){
            minIndx = right;
        }

        if(minIndx != i){
            int temp = arr.get(i);
            arr.set(i, arr.get(minIndx));
            arr.set(minIndx, temp);
            heapify(minIndx);
        }
    }

    public boolean isEmpty(){
        return arr.isEmpty();
    }
}

public class HeapClass {
    public static void main(String[] args) {
        HeapClassNew heap = new HeapClassNew();
        heap.insert(3);
        heap.insert(4);
        heap.insert(1);
        heap.insert(5);
        System.out.println(heap.arr.toString());
    }
}
