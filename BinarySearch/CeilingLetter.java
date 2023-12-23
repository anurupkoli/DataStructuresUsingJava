package BinarySearch;

public class CeilingLetter {

    static char ceilingLetter(char[] arr, char target){
        int start = 0;
        int end = arr.length-1;
        while(start<end){
            int mid = start + (end-start)/2;
            
            if(arr[mid]>target){
                end = mid-1;
            }
            if(arr[mid]<target){
                start = mid+1;
            }
            if(arr[mid]==target){
                return arr[mid+1];
            }
        }

        return arr[start==arr.length-1?0:start+1];
    }
    public static void main(String[] args) {
        char[] arr = {'a', 'd', 'f', 'j', 'v', 'w', 'y'};
        System.out.println(ceilingLetter(arr, 'w'));
    }
}
