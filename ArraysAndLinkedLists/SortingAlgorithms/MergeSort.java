package ArraysAndLinkedLists.SortingAlgorithms;

import java.util.Arrays;

public class MergeSort {
    static void mergeSort(int[] arr, int start, int end){
        if(start >= end){
            return;
        }
        int mid = start + (end - start)/2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);
        merge(arr, start, end, mid);
    }

    static void merge(int[] arr, int start, int end, int mid){
        int[] temp = new int[end - start + 1];
        int i = start; //iterator for left part
        int j = mid+1; //iterator for right part
        int k = 0; //iterator for temporary variable
        
        //checking for both left and right
        while (i <= mid && j <= end) {
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            }
            else{
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        //if anything remains
        //for left
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        //for right
        while(j <= end){
            temp[k++] = arr[j++];
        }

        //copying  temporary to original array

        for (int k2 = 0, i2 = start; k2 < temp.length; i2++, k2++) {
            arr[i2] = temp[k2];
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,2,5,6,1,4};
        mergeSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
