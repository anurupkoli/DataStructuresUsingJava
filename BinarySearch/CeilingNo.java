package BinarySearch;

public class CeilingNo {
    static int ceilingNo(int[] arr, int no) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (no > arr[mid]) {
                start = mid + 1;
            }
            if (no < arr[mid]) {
                end = mid - 1;
            }
            if (arr[mid] == no) {
                return arr[mid];
            }
            if(mid<=0){
                mid=mid+1;
            }
            if (arr[mid-1] < no && arr[mid] > no) {
                return arr[mid];
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = { -10, -5, -1, 0, 20, 34, 45, 66, 77, 88 };
        System.out.println(ceilingNo(arr, -7));
    }
}
