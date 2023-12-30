package ArraysAndLinkedLists.Arrays;

import java.util.Arrays;

public class Swap {
    static void  swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 6, 7, 9};
        swap(arr, 0, 5);
        System.out.println(Arrays.toString(arr));
    }
}
