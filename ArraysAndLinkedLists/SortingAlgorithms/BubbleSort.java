package ArraysAndLinkedLists.SortingAlgorithms;

import java.util.Arrays;

public class BubbleSort {
    public static int[] bubbleSortInc(int[] arr) {
        int swap = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swap++;
                }
            }
            if(swap == 0){
                return arr;
            }
        }
        return arr;
    }

    public static int[] bubbleSortDec(int[] arr){
        int swap = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j+1] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap++;
                }
            }
            if(swap == 0){
                return arr;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 1,2,3,4,5 };
        System.out.println(Arrays.toString(bubbleSortInc(arr)));
    }
}
