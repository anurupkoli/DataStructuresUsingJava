package LinearSearch;

public class SearchInRange {
    static int serachInRange(int[] arr,int ele, int start, int end){
        if(arr.length==0){
            return -1;
        }
        for (int i = start; i < end; i++) {
            if(arr[i]==ele){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 54, 67, 7, 8, 9, 10};
        System.out.println(serachInRange(arr,67, 2,5));
    }
}
