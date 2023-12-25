package BinarySearch;

public class CountOfRotatedArray {
    static int findRotations(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(start<end){
            int mid = start + (end-start)/2;
            if(arr[start]>arr[mid]){
                end = mid;
            }
            else if(arr[mid] > arr[mid+1]){
                end = mid;
            }
            else if(mid > 0 && arr[mid] < arr[mid-1]){
                end = mid-1;
            }
            else{
                start = start+1;
            }
        }
        return start==arr.length-1?0:start+1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(findRotations(arr));
    }
}
