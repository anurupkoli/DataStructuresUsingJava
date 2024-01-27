package ArraysAndLinkedLists.SortingAlgorithms;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }

        int pivIndex = patrtition(arr, start, end);
        quickSort(arr, start, pivIndex - 1);
        quickSort(arr, pivIndex + 1, end);
    }

    public static int patrtition(int[] arr, int start, int end){
        int piv = arr[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if(arr[j] < piv){
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        arr[end] = arr[i];
        arr[i] = piv;
        return i;
    }
    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 4, 6, 7};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
