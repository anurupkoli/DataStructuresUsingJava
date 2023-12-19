package LinearSearch;

public class FindMinNum {
    static int minNum(int[] arr){
        int num = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]<num){
                num=arr[i];
            }
        }
        return num;
    }
    public static void main(String[] args) {
        int[] arr = {100, 200, 54, 67, 7, 8, 9, 10};
        System.out.println(minNum(arr));
    }
}
