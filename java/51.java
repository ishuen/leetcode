// 51. N-Queens
// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
//
// Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
//
// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
//
//
//
// Example 1:
//
//
// Input: n = 4
// Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
// Example 2:
//
// Input: n = 1
// Output: [["Q"]]
//
//
// Constraints:
//
// 1 <= n <= 9
//
// Runtime: 3 ms, faster than 77.87% of Java online submissions for N-Queens.
// Memory Usage: 39 MB, less than 86.42% of Java online submissions for N-Queens.
class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> answerList = new ArrayList<>();
        nQueens(board, 0, answerList);
        return answerList;
    }
    
    public void nQueens(char[][] board, int row, List<List<String>> answerList) {
        if (row > board.length) return;
        if (row == board.length) {
            convertToString(board, answerList);
        } else {
            Arrays.fill(board[row], '.');
            for (int i = 0; i < board[0].length; i++) {
                board[row][i] = 'Q';
                if (validateQueen(row, board)) {
                    nQueens(board, row + 1, answerList);
                }
                board[row][i] = '.';
            }
        }
    }
    
    public boolean validateQueen(int row, char[][] board) {
        int col = 0;
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == 'Q') {
                col = i;
                break;
            }
        }
        if (row == 0) return true;
        int diff = 1;
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
            if (col + diff < board[0].length && board[i][col + diff] == 'Q') return false;
            if (col - diff >= 0 && board[i][col - diff] == 'Q') return false;
            diff++;
        }
        return true;
    }
    
    public void convertToString(char[][] board, List<List<String>> answerList) {
        List<String> boardStr = new ArrayList<>();
        for (char[] row : board) {
            String str = new String(row);
            boardStr.add(str);
        }
        answerList.add(boardStr);
    }
}