//works for all types of sorted array......rotated, normal, rotated with duplicates, ascending and descending..etc

package BinarySearch;

public class RotatedSortedArray {
    static int findPeakEle(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;

            if (arr[start] > arr[mid]) {
                end = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                end = mid;
            } else if (mid > 0 && arr[mid] < arr[mid - 1]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start == -1 ? 0 : start;
    }

    static int binarySearch(int[] arr, int target, int start, int end) {
        int ele = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (target == arr[0]) {
                return 0;
            } else if (arr[mid] > target) {
                end = mid-1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            }
        }
        return ele;
    }

    static int rotatedSortedArray(int[] arr, int target) {
        int peakEleInd = findPeakEle(arr);
        int reqEle = binarySearch(arr, target, 0, peakEleInd);
        if (reqEle == -1) {
            reqEle = binarySearch(arr, target, peakEleInd + 1, arr.length - 1);
        }
        return reqEle;
    }

    public static void main(String[] args) {
        int[] arr = { 3,4,5,6,1,2 };
        System.out.println(rotatedSortedArray(arr, 6));
    }
}
