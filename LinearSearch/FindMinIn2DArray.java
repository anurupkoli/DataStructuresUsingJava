package LinearSearch;

public class FindMinIn2DArray {
    static int minNum(int[][] arr){
        if(arr.length==0){
            return -1;
        }
        int min = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]<min){
                    min = arr[i][j];
                }
            }
        }
        return min;
    }
    static int maxNum(int[][] arr){
        if(arr.length==0){
            return -1;
        }
        int min = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(arr[i][j]>min){
                    min = arr[i][j];
                }
            }
        }
        return min;
    }


    public static void main(String[] args) {
        int[][] arr = {
            {9,3,4},
            {25, 62, 64, 76},
            {97, 1}
        };
        System.out.println(minNum(arr));
        System.out.println(maxNum(arr));
    }
}
