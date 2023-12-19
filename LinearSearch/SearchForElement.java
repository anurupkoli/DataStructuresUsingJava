package LinearSearch;

public class SearchForElement {
    static int linearSearch(int[] arr, int ele){
        if(arr.length==0){
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==ele){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 54, 67, 7, 8, 9, 10};
        System.out.println(linearSearch(arr, 2));
    }
}
