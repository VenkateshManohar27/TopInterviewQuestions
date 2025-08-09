package com.ven.array;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * <p>
 *
 * Example 1:
 * <p>
 *
 * Input: board =
 * [["5","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: true
 * Example 2:
 * <p>
 * Input: board =
 * [["8","3",".",".","7",".",".",".","."]
 * ,["6",".",".","1","9","5",".",".","."]
 * ,[".","9","8",".",".",".",".","6","."]
 * ,["8",".",".",".","6",".",".",".","3"]
 * ,["4",".",".","8",".","3",".",".","1"]
 * ,["7",".",".",".","2",".",".",".","6"]
 * ,[".","6",".",".",".",".","2","8","."]
 * ,[".",".",".","4","1","9",".",".","5"]
 * ,[".",".",".",".","8",".",".","7","9"]]
 * Output: false
 * Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 * <p>
 *
 * Constraints:
 * <p>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] != '.' &&
                        !validate(board[i][j], i, j, board)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean validate(char ch, int row, int col, char[][] board) {

        return validateRow(ch, row, col, board) &&
                validateCol(ch, row, col, board) &&
                validateBlock(ch, row, col, board);
    }


    private boolean validateRow(char ch, int row, int col, char[][] board) {
        for(int i = 0; i < board[0].length; i++){
            if(i != col && ch == board[row][i]){
                System.out.println("Row : row :"+row+", col: "+i+", ch: "+ ch);
                return false;
            }
        }
        return true;
    }

    private boolean validateCol(char ch, int row, int col, char[][] board) {
        for(int i = 0; i < board.length; i++){
            if(row != i && ch == board[i][col]){
                System.out.println("Col : row : "+i+", col : "+col+" , ch: "+ ch);
                return false;
            }
        }
        return true;
    }


    private boolean validateBlock(char ch, int row, int col, char[][] board) {
        int rowstart = (row >= 0 && row <=2) ? 0: (row >= 3 && row <=5)? 3: 6;
        int colstart = (col >= 0 && col <=2) ? 0: (col >= 3 && col <=5)? 3: 6;


        for(int i = rowstart; i < rowstart + 3; i++){
            for(int j = colstart; j < colstart + 3; j++) {
                if(i != row && j != col && ch == board[i][j]){
                    System.out.println("row : "+i+", col : "+col+" , ch: "+ ch);
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku validSudoku = new ValidSudoku();
        char[][] board =
                {
                        {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}
                };
        boolean result = validSudoku.isValidSudoku(board);
        System.out.println("Is the Sudoku board valid? " + result); // Output: true
    }
}
