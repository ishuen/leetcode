// 37. Sudoku Solver
// Write a program to solve a Sudoku puzzle by filling the empty cells.
//
// A sudoku solution must satisfy all of the following rules:
//
// Each of the digits 1-9 must occur exactly once in each row.
// Each of the digits 1-9 must occur exactly once in each column.
// Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
// The '.' character indicates empty cells.
//
// Example 1:
//
//
// Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
// Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
// Explanation: The input board is shown above and the only valid solution is shown below:
//
// Constraints:
//
// board.length == 9
// board[i].length == 9
// board[i][j] is a digit or '.'.
// It is guaranteed that the input board has only one solution.
//
// Runtime: 14 ms, faster than 43.51% of Java online submissions for Sudoku Solver.
// Memory Usage: 36.3 MB, less than 77.21% of Java online submissions for Sudoku Solver.
class Solution {
    public void solveSudoku(char[][] board) {
        tryCandidates(board);
    }
    
    private boolean tryCandidates(char[][]board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char k = '1'; k <= '9'; k++) {
                        if (validate(k, i, j, board)) {
                            board[i][j] = k;
                            if (tryCandidates(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean validate(char c, int row, int col, char[][] board) {
        int baseRow = 3 * (row / 3) ;
        int baseCol = 3 * (col / 3);
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c && i != col) return false;
            if (board[i][col] == c && i != row) return false;
            if (board[baseRow + i / 3][baseCol + i % 3] == c && baseRow + i / 3 != row && baseCol + i % 3 != col) return false;
        }
        return true;
    }
    
}