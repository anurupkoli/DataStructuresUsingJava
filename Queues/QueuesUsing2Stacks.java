package Queues;

import java.util.Stack;

class QueuesUsingStacks{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void add(int data){
        if(!s1.isEmpty()){
            while (!s1.isEmpty()) {
                s2.add(s1.pop());
            }
        }

        s1.add(data);

        if(!s2.isEmpty()){
            while (!s2.isEmpty()) {
                s1.add(s2.pop());
            }
        }
    }

    public int pop(){
        if(s1.isEmpty()){
            return -1;
        }
        return s1.pop();
    }

    public int peek(){
        if(s1.isEmpty()){
            return -1;
        }
        return s1.peek();
    }

    public void print(){
        System.out.println(s1.toString());
    }
}

public class QueuesUsing2Stacks {
    public static void main(String[] args) {
        QueuesUsingStacks que = new QueuesUsingStacks();
        que.add(1);
        que.add(2);
        que.add(3);
        System.out.println(que.pop());
        que.print();
    }
}
