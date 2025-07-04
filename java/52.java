// 52. N-Queens II
// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
//
// Given an integer n, return the number of distinct solutions to the n-queens puzzle.
//
// Example 1:
//
//
// Input: n = 4
// Output: 2
// Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
// Example 2:
//
// Input: n = 1
// Output: 1
//
// Constraints:
//
// 1 <= n <= 9
//
// Runtime: 1 ms, faster than 84.97% of Java online submissions for N-Queens II.
// Memory Usage: 35.8 MB, less than 71.03% of Java online submissions for N-Queens II.
class Solution {
    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return totalNQueens(board, 0, n);
    }
    
    private int totalNQueens(boolean[][] board, int cur, int target) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            board[cur][i] = true;
            if (isValid(board, cur, i)) {
                if (cur == target - 1) count++;
                else count = count + totalNQueens(board, cur + 1, target);
            }
            board[cur][i] = false;
        }
        return count;
    }
    private boolean isValid(boolean[][] board, int cur, int col) {
        for (int i = 1; i <= cur; i++) {
            if (board[cur - i][col] == true) return false;
            if (col + i < board.length && board[cur - i][col + i] == true) return false;
            if (col - i >= 0 && board[cur - i][col - i] == true) return false;
        }
        return true;
    }
}