package Stacks;

import java.util.ArrayList;

class StackArrL{
    ArrayList<Integer> list = new ArrayList<>();

    public boolean isEmpty(){
        return list.size() == 0;
    }

    public void push(int data){
        list.add(data);
    }

    public int pop(){
        if(isEmpty()){
            return -1;
        }
        int data = list.get(list.size() - 1);
        list.remove(list.size() - 1 );
        return data;
    }

    public int peek(){
        if(isEmpty()){
            return -1;
        }
        return list.get(list.size() - 1);
    }
}

public class StackUsingArrayList {
    public static void main(String[] args) {
        
    }
}
