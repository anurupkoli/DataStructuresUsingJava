package Stacks;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {6,8,0,1,2,3};
        int[] greaterElements = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]){
                stack.pop();
            }

            if(stack.isEmpty()){
                greaterElements[i] = -1;
            }
            else{
                greaterElements[i] = arr[stack.peek()];
            }
            stack.push(i);
        }
        for (int i = 0; i < greaterElements.length; i++) {
            System.out.print(greaterElements[i] + " ");
        }
    }
}
