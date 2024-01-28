package Backtracking;

public class NQueens {
    public static void nQueens(char[][] board, int i){
        if(i == board.length){
            printBoard(board);
            System.out.println();
            return;
        }
        for (int j = 0; j < board.length; j++) {
            board[i][j] = 'Q';
            nQueens(board, i+1);
            board[i][j] = '_';
        }
    }

    public static void printBoard(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = '_';
            }
        }
        nQueens(board, 0);
    }
}
