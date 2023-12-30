package ArraysAndLinkedLists.Arrays;
import java.util.*;

public class FindingSubArrays {
    public static void findSubArrays(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.printf("[");
                for (int j2 = i; j2 <= j; j2++) {
                    System.out.printf("%d ", arr[j2]);
                }
                System.out.printf("]");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        findSubArrays(arr);
    }
}
