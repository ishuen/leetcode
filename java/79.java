// 79. Word Search
// Given an m x n grid of characters board and a string word, return true if word exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//
//
// Example 1:
//
//
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true
// Example 2:
//
//
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true
// Example 3:
//
//
// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false
//
//
// Constraints:
//
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board and word consists of only lowercase and uppercase English letters.
//
//
// Follow up: Could you use search pruning to make your solution faster with a larger board?
//
// Runtime: 140 ms, faster than 23.72% of Java online submissions for Word Search.
// Memory Usage: 37 MB, less than 59.33% of Java online submissions for Word Search.
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean hasWord = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                hasWord = hasWord || exist(board, i, j, 0, word);
            }
        }
        return hasWord;
    }
    
    private int[][] direction = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    private boolean exist(char[][] board, int row, int col, int index, String word) {
        if (index == word.length()) return true;
        if (row >= board.length || row < 0
            || col >= board[0].length || col < 0) return false;
        boolean hasWord = false;
        if (word.charAt(index) == board[row][col]) {
            board[row][col] ^= '.';
            for (int i = 0; i < direction.length; i++) {
                hasWord = hasWord || exist(board, row + direction[i][0], col + direction[i][1], index + 1, word);
            }
            board[row][col] ^= '.';
        }
        return hasWord;
    }
}
