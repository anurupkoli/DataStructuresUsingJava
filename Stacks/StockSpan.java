package Stacks;

import java.util.Stack;

public class StockSpan {
    public static void stockSpan(int[] stock, int[] span){
        Stack<Integer> stack = new Stack<>();
        span[0] = 1;
        stack.push(0);
        for (int i = 1; i < span.length; i++) {
            int currPrice = stock[i];
            while(!stack.isEmpty() && currPrice > stock[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                span[i] = i+1;
            }
            else{
                int prevHigh = stack.peek();
                span[i] = i - prevHigh;
            }
            stack.push(i);
        }
    }
    public static void main(String[] args) {
        
    }
}
