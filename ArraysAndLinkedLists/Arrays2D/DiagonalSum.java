package ArraysAndLinkedLists.Arrays2D;

public class DiagonalSum {
    static int diagonalSum(int[][] arr) {
        int sum = 0;
        // int revDiagonal = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
            // if (i == revDiagonal) {
            // revDiagonal--;
            // continue;
            // }
            // sum += arr[i][revDiagonal];
            // revDiagonal--;
            if (i != arr.length - 1 - i) {
                sum += arr[i][arr.length - 1 - i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        System.out.println(diagonalSum(arr));
    }
}
