package Stacks;
import java.util.Stack;

public class MaxAreaInHistogram {
    public static int findMaxArea(int[] arr){
        Stack<Integer> leftSmall = new Stack<>();
        Stack<Integer> rightSmall = new Stack<>();
        int[] leftArr = new int[arr.length];
        int[] rightArr = new int[arr.length];
        int maxArea = 0;
        for (int i = arr.length-1; i >= 0; i--) {
            while (!rightSmall.isEmpty() && arr[rightSmall.peek()] >= arr[i]) {
                rightSmall.pop();
            }
            if(rightSmall.isEmpty()){
                rightArr[i] = arr.length;
            }
            else{
                rightArr[i] = rightSmall.peek();
            }
            rightSmall.push(i);
        }
        for (int i = 0; i < arr.length; i++) {
            while (!leftSmall.isEmpty() && arr[leftSmall.peek()] >= arr[i]) {
                leftSmall.pop();
            }
            if(leftSmall.isEmpty()){
                leftArr[i] = -1;
            }
            else{
                leftArr[i] = leftSmall.peek();
            }
            leftSmall.push(i);
        }
        
        for (int i = 0; i < arr.length; i++) {
            int newArea = arr[i] * (rightArr[i] - leftArr[i] - 1);
            if(newArea > maxArea){
                maxArea = newArea;
            }
        }

        return maxArea;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        System.out.println(findMaxArea(arr));
    }
}
