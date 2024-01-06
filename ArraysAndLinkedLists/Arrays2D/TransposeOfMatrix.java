package ArraysAndLinkedLists.Arrays2D;

public class TransposeOfMatrix {
    static int[][] transposeOfMatrix(int[][] arr) {
        int[][] newArr = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                newArr[j][i] = arr[i][j];
            }
        }
        return newArr;
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3 },
                { 5, 6, 7 },
                { 8, 9, 10 }
        };
        int[][] newArr = transposeOfMatrix(arr);
        System.out.println(newArr[0].length);
        for (int i = 0; i < newArr.length; i++) {
            System.out.print("[");
            for (int j = 0; j < newArr[i].length; j++) {
                System.out.print(" " + newArr[i][j] + ",");
            }
            System.out.println(" ]");
        }
    }
}
