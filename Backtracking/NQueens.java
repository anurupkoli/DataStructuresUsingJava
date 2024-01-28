package Backtracking;

public class NQueens {
    public static void nQueens(char[][] board, int i){
        if(i == board.length){
            printBoard(board);
            System.out.println();
            return;
        }
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, i, j)) {
                board[i][j] = 'Q';
                nQueens(board, i + 1);
                board[i][j] = '_';
            }
        }
    }

    public static boolean isSafe(char[][] board, int row, int col) {
        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // diagonal left up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // diagonal right up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[6][6];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '_';
            }
        }
        nQueens(board, 0);
    }
}
