package ArraysAndLinkedLists.Arrays;

import java.util.Arrays;

public class Reverse {
    static void reverse(int[] arr){
        int start = 0;
        int end = arr.length-1;
        for (int i = 0; i < arr.length/2; i++) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 7, 9};
        reverse(arr);
        System.out.println(Arrays.toString(arr));
    }
}
