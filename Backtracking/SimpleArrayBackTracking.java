package Backtracking;

public class SimpleArrayBackTracking {
    public static void arrayBacktracking(int[] arr, int n, int i){
        if(i == arr.length){
            printArr(arr);
            return;
        }
        arr[i] = n;
        arrayBacktracking(arr, n+1, i+1);
        arr[i] = arr[i] - 2;
    }

    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = new int[5];
        arrayBacktracking(arr, 1, 0);
        printArr(arr);
    }
}
