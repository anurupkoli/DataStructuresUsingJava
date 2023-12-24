package BinarySearch;

public class MountainArray {
    static int binarySearchMountain(int arr[]){
        int start = 0;
        int end = arr.length-1;
        while (start<end) {
            int mid = start + (end - start)/2;
            // if(arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
            //     return arr[mid];
            // }
            if(arr[mid] > arr[mid+1]){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return arr[start];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,3,1};
        System.out.println(binarySearchMountain(arr));
    }
}
