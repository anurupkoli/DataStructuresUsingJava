package ArraysAndLinkedLists;

import java.util.Scanner;

public class LearningArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.println(arr[i]);
        // }

        for (int i : arr) {
            System.out.print(i+" ");
        }
        sc.close();
    }
}
