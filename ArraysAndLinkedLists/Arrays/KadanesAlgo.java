package ArraysAndLinkedLists.Arrays;

public class KadanesAlgo {
    public static void kadansAlgo(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int cuSum = 0;
        for (int i = 0; i < arr.length; i++) {
            cuSum += arr[i];
            if(cuSum < 0){
                cuSum = 0;
            }
            if(cuSum > maxSum){
                maxSum = cuSum;
            }
        }
        System.out.println("Max Sum: " + maxSum);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6,7};
        kadansAlgo(arr);
    }
}
