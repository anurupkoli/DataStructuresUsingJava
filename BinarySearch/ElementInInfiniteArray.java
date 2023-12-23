package BinarySearch;

public class ElementInInfiniteArray {

    static int findElement(int[] arr, int target){
        int start = 0;
        int end = 1;
        while (target > arr[end]) {
            int newStart = end+1;
            end = end + (end - start + 1)*2;
            start = newStart;
        }
        return binarySearch(arr, target, start, end);
    }

    static int binarySearch(int[] arr, int target, int start, int end){
        while (start<=end) {
            int mid = start + (end - start)/2;
            if(arr[mid] < target){
                start = mid+1;
            }
            else if(arr[mid] > target){
                end = mid-1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 6, 7, 8, 8, 9, 10, 11, 23, 56, 60};
        System.out.println(findElement(arr, 56));
    }
}
