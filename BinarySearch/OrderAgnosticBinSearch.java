package BinarySearch;

public class OrderAgnosticBinSearch {
    static int orderAgnosticBinSearch(int[] arr, int ele){
        int start = 0;
        int end = arr.length - 1;
        boolean asc = arr[start] < arr[end]; 
        while(start<=end){
            int mid = start + (end-start)/2;
            if(ele>arr[mid]){
                start = asc?mid+1:start;
                end = asc?end:mid-1;
            }
            if(ele<arr[mid]){
                start = asc?start:mid+1;
                end = asc?mid-1:end;
            }
            if(ele==arr[mid]){
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {100,40,32,30,20,10,1,0,-1,-10,-12};
        System.out.println(orderAgnosticBinSearch(arr, 40));
    }
}
