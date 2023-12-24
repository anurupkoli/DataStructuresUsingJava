package BinarySearch;

public class MountaineArrayElement {
    static int searchForPeakElement(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while (start<end) {
            int mid = start + (end-start)/2;
            if(arr[mid]>arr[mid+1]){
                end = mid;
            }
            else{
                start = mid+1;
            }
        }
        return start;
    }
    static int searchForElement(int[] arr, int target){
        int peakEleInd = searchForPeakElement(arr);
        int reqEle = -1;
        reqEle = binarySearch(arr, 0, peakEleInd, target, true);
        if(reqEle == -1){
            reqEle = binarySearch(arr, peakEleInd, arr.length-1, target, false);
        }
        return reqEle;
    }
    static int binarySearch(int[] arr, int start, int end, int target, boolean asce){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target > arr[mid]){
                start = asce?mid+1:start;
                end = asce?end:mid-1;
            }
            if(target < arr[mid]){
                start = asce?start:mid+1;
                end = asce?mid-1:end;
            }
            if(target == arr[mid]){
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,3,2,1};
        System.out.println(searchForElement(arr, 1));
    }
}
