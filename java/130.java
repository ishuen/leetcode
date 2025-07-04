// 130. Surrounded Regions
// Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
// Example 1:
//
//
// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
// Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
// Example 2:
//
// Input: board = [["X"]]
// Output: [["X"]]
//
// Constraints:
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] is 'X' or 'O'.
//
// Runtime: 1 ms, faster than 99.66% of Java online submissions for Surrounded Regions.
// Memory Usage: 41 MB, less than 63.13% of Java online submissions for Surrounded Regions.
class Solution {
    public void solve(char[][] board) {
        char[][] output = new char[board.length][board[0].length];
        for(char[] row: output) {
            Arrays.fill(row, 'X');
        }
        for (int i = 0; i < board[0].length; i++) {
            traverse(board, 0, i, output);
            traverse(board, board.length - 1, i, output);
        }
        for (int i = 1; i < board.length - 1; i++) {
            traverse(board, i, 0, output);
            traverse(board, i, board[0].length - 1, output);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = output[i][j];
            }
        }
    }
    
    public void traverse(char[][] board, int row, int col, char[][] output) {
        if (board[row][col] == 'X') return;
        if (output[row][col] == 'O') return;
        output[row][col] = 'O';
        if (row > 0) traverse(board, row - 1, col, output);
        if (row < board.length - 1) traverse(board, row + 1, col, output);
        if (col > 0) traverse(board, row, col - 1, output);
        if (col < board[0].length - 1) traverse(board, row, col + 1, output);
    }
}

// start from the border, and find o, and keep the adecent onces

// Runtime: 1 ms, faster than 99.66% of Java online submissions for Surrounded Regions.
// Memory Usage: 41.2 MB, less than 53.05% of Java online submissions for Surrounded Regions.
class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            traverse(board, 0, i);
            traverse(board, board.length - 1, i);
        }
        for (int i = 1; i < board.length - 1; i++) {
            traverse(board, i, 0);
            traverse(board, i, board[0].length - 1);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '*') board[i][j] = 'O';
            }
        }
    }
    
    public void traverse(char[][] board, int row, int col) {
        if (board[row][col] == 'X' || board[row][col] == '*') return;
        board[row][col] = '*';
        if (row > 0) traverse(board, row - 1, col);
        if (row < board.length - 1) traverse(board, row + 1, col);
        if (col > 0) traverse(board, row, col - 1);
        if (col < board[0].length - 1) traverse(board, row, col + 1);
    }
}