package BinarySearch;

import java.util.Arrays;

public class FirstLastPositionOfElement {
    static int[] firstLastPosition(int[] arr, int target){
        int[] ans = {-1, -1};
        ans[0] = findPosition(arr, target, true);
        if(ans[0]!=-1){
            ans[1]= findPosition(arr, target, false);
        }
        return ans;
    }
    static int findPosition(int[] arr, int target, boolean firstIndex){
        int start = 0;
        int end = arr.length-1;
        int index = -1;

        while (start<=end) {
            int mid = start + (end-start)/2;
            if(arr[mid] < target){
                start = mid+1;
            }
            if(arr[mid] > target){
                end = mid-1;
            }
            if(arr[mid] == target){
                index = mid;
                if(firstIndex){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }

        return index;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 5, 6, 7, 7, 8, 8, 9, 10};
        System.out.println(Arrays.toString(firstLastPosition(arr, 2)));
    }
}
