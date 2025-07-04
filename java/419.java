// 419. Battleships in a Board
// Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.
//
// Battleships can only be placed horizontally or vertically on board. In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).
//
//
//
// Example 1:
//
//
// Input: board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
// Output: 2
// Example 2:
//
// Input: board = [["."]]
// Output: 0
//
//
// Constraints:
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] is either '.' or 'X'.
//
//
// Follow up: Could you do it in one-pass, using only O(1) extra memory and without modifying the values board?
//
// Runtime 0 ms Beats 100%
// Memory 42.3 MB Beats 48.52%
class Solution {
    public int countBattleships(char[][] board) {
        int counter = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    counter++;
                    board[i][j] = '.';
                    for (int s = i + 1; s < board.length; s++) {
                        if (board[s][j] == 'X') {
                            board[s][j] = '.';
                        } else {
                            break;
                        }
                    }
                    for (int t = j + 1; t < board[0].length; t++) {
                        if (board[i][t] == 'X') {
                            board[i][t] = ',';
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return counter;
    }
}