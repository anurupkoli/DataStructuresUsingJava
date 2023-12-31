package ArraysAndLinkedLists.SortingAlgorithms;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSortInc(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int smallest = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[smallest]){
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }
    public static void selectionSortDec(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            int smallest = i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] > arr[smallest]){
                    smallest = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {5,4,1,3,2};
        selectionSortDec(arr);
        System.out.println(Arrays.toString(arr));
    }
}
