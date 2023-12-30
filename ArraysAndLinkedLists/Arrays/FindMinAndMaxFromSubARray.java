package ArraysAndLinkedLists.Arrays;

public class FindMinAndMaxFromSubARray {
    public static void findMinMaxFromSubArrays(int[] arr){
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int j2 = i; j2 <= j; j2++) {
                    sum+=arr[j2];
                }
                if(sum>maxSum){
                    maxSum = sum;
                }
                if(sum<minSum){
                    minSum = sum;
                }
            }
        }
        System.out.printf("Max Sum: %d\nMin Sum: %d", maxSum, minSum);
    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6,7};
        findMinMaxFromSubArrays(arr);
    }
}
