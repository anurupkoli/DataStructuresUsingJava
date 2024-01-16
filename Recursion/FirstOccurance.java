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

    static int lastOccurance(int[] arr, int ele, int index){
        if(index < 0){
            return -1;
        }
        if(arr[index] == ele){
            return index;
        }
        return lastOccurance(arr, ele, index-1);
    }
    public static void main(String[] args) {
        int[] arr = {1,3,51,1,3,7,89,4};
        System.out.println(firstOccurance(arr, 1, 0));
        System.out.println(lastOccurance(arr, 1, arr.length-1));
    }
}
