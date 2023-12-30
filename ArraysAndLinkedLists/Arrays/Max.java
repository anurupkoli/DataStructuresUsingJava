package ArraysAndLinkedLists.Arrays;

public class Max {
    static int max(int[] arr){
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 15, 6, 7, 9};
        System.out.println(max(arr));
    }
}
