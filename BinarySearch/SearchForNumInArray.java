package BinarySearch;

public class SearchForNumInArray {
    static int searchForElement(int[] arr, int ele){
        int start = 0;
        int end = arr.length - 1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(ele>arr[mid]){
                start = mid+1;
            }
            if(ele<arr[mid]){
                end = mid-1;
            }
            if(ele==arr[mid]){
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {-10, -5, -1, 0, 20, 34, 45, 66, 77, 88, 100};
        System.out.println(searchForElement(arr, 88));
    }
}
