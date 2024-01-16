package Recursion;

public class FirstOccurance {
    static int firstOccurance(int[] arr, int ele, int index){
        if(index == arr.length){
            return -1;
        }
        if(arr[index] == ele){
            return index;
        }
        return firstOccurance(arr, ele, index+1);
    }
    public static void main(String[] args) {
        int[] arr = {1,3,51,1,3,7,89,4};
        System.out.println(firstOccurance(arr, 51, 0));
    }
}
