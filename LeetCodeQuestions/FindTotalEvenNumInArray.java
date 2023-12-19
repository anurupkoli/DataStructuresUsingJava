//How many of numbers contain even digits?
//int[] arr = [12, 345, 2, 6, 7896]

package LeetCodeQuestions;

public class FindTotalEvenNumInArray {
    static int findEvenDigits(int[] arr){
        if(arr.length==0){
            return -1;
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int count = 0;
            while(arr[i]!=0){
                count++;
                arr[i] = arr[i]/10;
            }
            if(count%2==0){
                ans++;
            }
            count=0;
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {12, 345, 2, 6, 7896, 1};
        System.out.println(findEvenDigits(arr));
    }
}
