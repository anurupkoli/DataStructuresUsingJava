package ArraysAndLinkedLists.Arrays2D;

public class SpiralMatrix {
    static void printSpiralMatrix(int[][] arr) {
        int startRow = 0;
        int startCol = 0;
        int endRow = arr.length - 1;
        int endCol = arr[0].length - 1;
        while (startRow <= endRow && startCol <= endCol) {
            // top
            for (int i = startRow; i <= endCol; i++) {
                System.out.print(arr[startRow][i] + " ");
            }

            // right
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(arr[i][endCol] + " ");
            }

            // bottom
            for (int i = endCol - 1; i >= startCol; i--) {
                if (startRow >= endRow) {
                    break;
                }
                System.out.print(arr[endRow][i] + " ");
            }

            // left
            for (int i = endRow - 1; i > startRow; i--) {
                if (startCol >= endCol) {
                    break;
                }
                System.out.print(arr[i][startCol] + " ");
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
    }

    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3 },
                { 5, 6, 7 },
                { 9, 10, 11 },
        };
        printSpiralMatrix(arr);
    }
}
