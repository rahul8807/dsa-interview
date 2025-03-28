package com.dsa.backtrack;

public class ValidSudoku {
    // Method to validate the Sudoku board
    public static int boardSize = 0;

    public static boolean isValidSudoku(char[][] board) {
        int row = 0;
        int col = 0;
        boardSize = board.length;

        return solve ( 0,0 , board); // Placeholder return value
    }

    public static boolean solve(int row, int col, char[][] board) {
        if (row >= boardSize) {
            return true;
        }

        if (col >= boardSize) {
            return solve(row + 1, 0, board);
        }

        if (board[row][col] != '.') {
            return solve(row, col + 1, board);
        } else {
            for (char c = '1'; c <= '9'; c++) {
                if (isValid(row, col, c, board)) {
                    board[row][col] = c;
                    if (solve(row, col + 1, board)) {
                        return true;
                    }
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    public static boolean isValid ( int row, int col, int value, char[][] board ) {
        for(int i = 0; i< boardSize; i++){
            if(board[row][i] == value){
                return false;
            }
        }

        for(int i = 0; i< boardSize; i++){
            if(board[i][col] == value){
                return false;
            }
        }

        int rowStart = row - (row % 3);
        int colStart = col - (col % 3);
        for(int i = 0; i< boardSize /3; i++){
            for(int j=0; j<colStart/3; j++){
                if(board[i+rowStart][j+colStart] == value){
                    return false;
                }
            }
        }

        return true;
    }



    // ANSI color codes for colored console output
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

    // Test cases
    public static void main(String[] args) {
        // Test Case 1: Valid Sudoku board
        char[][] board1 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean expected1 = true;
        runTest(board1, expected1, "Test Case 1");

        // Test Case 2: Invalid Sudoku board
        char[][] board2 = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean expected2 = false;
        runTest(board2, expected2, "Test Case 2");
    }

    // Helper method to run a single test case and print colored output
    private static void runTest(char[][] board, boolean expected, String testCaseName) {
        boolean result = isValidSudoku(board);

        if (result == expected) {
            System.out.println(ANSI_GREEN + testCaseName + " Passed" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + testCaseName + " Failed" + ANSI_RESET);
            System.out.println(" (Expected: " + expected + ", Got: " + result + ")");
        }
    }
}
