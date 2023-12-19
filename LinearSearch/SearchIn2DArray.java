package LinearSearch;

import java.util.Arrays;

public class SearchIn2DArray {
    static int[] search(int[][] arr, int ele){
        int[] ans = {-1,-1};
        if(arr.length==0){
            return ans;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]==ele){
                    ans[0]=i;
                    ans[1]=j;
                    return ans;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[][] arr = {
            {1,3,4},
            {25, 62, 64, 76},
            {97, 80}
        };
        System.out.println(Arrays.toString(search(arr,97)));
    }
}
