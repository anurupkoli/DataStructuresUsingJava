package Stacks;

import java.util.Stack;

public class PushToBottomOfStack {
    public static void pushToBottom(Stack<Integer> st, int data){
        if(st.isEmpty()){
            st.push(data);
            return;
        }
        int curr = st.pop();
        pushToBottom(st, data);
        st.push(curr);
    }
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        pushToBottom(st, 4);
        
        while (!st.isEmpty()) {
            System.out.println(st.pop());
        }
    }
}
