// 36. Valid Sudoku
// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
//
// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// Note:
//
// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.
//
//
// Example 1:
//
//
// Input: board =
// [["5","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: true
// Example 2:
//
// Input: board =
// [["8","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: false
// Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
//
//
// Constraints:
//
// board.length == 9
// board[i].length == 9
// board[i][j] is a digit or '.'.
//
// Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid Sudoku.
// Memory Usage: 39 MB, less than 69.80% of Java online submissions for Valid Sudoku.
class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean isValid = true;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    isValid = isValid && checkRow(board[i], j, board[i][j])
                        && checkCol(board, i, j , board[i][j])
                        && checkArea(board, i, j, board[i][j]);
                }
            }
        }
        return isValid;
    }
    
    private boolean checkRow(char[] row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (row[i] == c && i != col) return false;
        }
        return true;
    }
    
    private boolean checkCol(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c && i != row) return false;
        }
        return true;
    }
    
    private boolean checkArea(char[][] board, int row, int col, char c) {
        int firstRow = row / 3 * 3;
        int firstCol = col / 3 * 3;
        for (int i = firstRow; i < firstRow + 3; i++) {
            for (int j = firstCol; j < firstCol + 3; j++) {
                if (board[i][j] == c && (i!= row || j != col)) return false;
            }
        } 
        return true;
    }
}