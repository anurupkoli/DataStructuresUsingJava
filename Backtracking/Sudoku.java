package Backtracking;

import java.util.Arrays;

public class Sudoku {
    public static boolean solveSudoku(int[][] sudoku, int row, int col) {
        if (row == 9) {
            return true;
        }

        int nextRow = row, nextCol = col + 1;
        if (col+1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if (sudoku[row][col] != 0) {
            return solveSudoku(sudoku, nextRow, nextCol);
        }

        for (int i = 1; i <= 9; i++) {
            if (isSafe(sudoku, row, col, i)) {
                sudoku[row][col] = i;
                if (solveSudoku(sudoku, nextRow, nextCol)) {
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }

        return false;
    }

    public static boolean isSafe(int[][] sudoku, int row, int col, int no) {
        // row
        for (int i = 0; i < 8; i++) {
            if (sudoku[row][i] == no) {
                return false;
            }
        }

        // col
        for (int i = 0; i < 8; i++) {
            if (sudoku[i][col] == no) {
                return false;
            }
        }

        // grid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku[i][j] == no) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] sudoku = {
                { 5, 3, 0, 0, 7, 0, 0, 0, 0 },
                { 6, 0, 0, 1, 9, 5, 0, 0, 0 },
                { 0, 9, 8, 0, 0, 0, 0, 6, 0 },
                { 8, 0, 0, 0, 6, 0, 0, 0, 3 },
                { 4, 0, 0, 8, 0, 3, 0, 0, 1 },
                { 7, 0, 0, 0, 2, 0, 0, 0, 6 },
                { 0, 6, 0, 0, 0, 0, 2, 8, 0 },
                { 0, 0, 0, 4, 1, 9, 0, 0, 5 },
                { 0, 0, 0, 0, 8, 0, 0, 0, 0 }
        };
        boolean ans = solveSudoku(sudoku, 0, 0);
        if(ans == true){
            for (int i = 0; i < sudoku.length; i++) {
                System.out.println(Arrays.toString(sudoku[i]));
            }
        }
        else{
            System.out.println("No solutions found");
        }
    }
}
