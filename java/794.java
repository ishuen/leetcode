// 794. Valid Tic-Tac-Toe State
// Given a Tic-Tac-Toe board as a string array board, return true if and only if it is possible to reach this board position during the course of a valid tic-tac-toe game.
//
// The board is a 3 x 3 array that consists of characters ' ', 'X', and 'O'. The ' ' character represents an empty square.
//
// Here are the rules of Tic-Tac-Toe:
//
// Players take turns placing characters into empty squares ' '.
// The first player always places 'X' characters, while the second player always places 'O' characters.
// 'X' and 'O' characters are always placed into empty squares, never filled ones.
// The game ends when there are three of the same (non-empty) character filling any row, column, or diagonal.
// The game also ends if all squares are non-empty.
// No more moves can be played if the game is over.
//
//
// Example 1:
//
//
// Input: board = ["O  ","   ","   "]
// Output: false
// Explanation: The first player always plays "X".
// Example 2:
//
//
// Input: board = ["XOX"," X ","   "]
// Output: false
// Explanation: Players take turns making moves.
// Example 3:
//
//
// Input: board = ["XOX","O O","XOX"]
// Output: true
//
//
// Constraints:
//
// board.length == 3
// board[i].length == 3
// board[i][j] is either 'X', 'O', or ' '.
//
// Runtime 0 ms Beats 100%
// Memory 40.2 MB Beats 52.60%
class Solution {
    public boolean validTicTacToe(String[] board) {
        int countO = 0;
        int countX = 0;
        int lineO = 0;
        int lineX = 0;
        int leftRO = 0;
        int leftRX = 0;
        int rightLO = 0;
        int rightLX = 0;
        for (int i = 0; i < board.length; i++) {
            int rowO = 0;
            int rowX = 0;
            int colO = 0;
            int colX = 0;
            char lr = board[i].charAt(i);
            char rl = board[i].charAt(3 - i - 1);
            if (lr == 'O') {
                leftRO++;
            } else if (lr == 'X') {
                leftRX++;
            }
            if (rl == 'O') {
                rightLO++;
            } else if (rl == 'X') {
                rightLX++;
            }
            for (int j = 0; j < board[i].length(); j++) {
                char rc = board[i].charAt(j);
                char cc = board[j].charAt(i);
                if (rc == 'O') {
                    countO++;
                    rowO++;
                } else if (rc == 'X') {
                    countX++;
                    rowX++;
                }
                if (cc == 'O') {
                    colO++;
                } else if (cc == 'X') {
                    colX++;
                }
            }
            if (rowX == 3) lineX++;
            if (rowO == 3) lineO++;
            if (colX == 3) lineX++;
            if (colO == 3) lineO++;
        }
        if (leftRO == 3) lineO++;
        if (leftRX == 3) lineX++;
        if (rightLO == 3) lineO++;
        if (rightLX == 3) lineX++;
        if (countX != countO && countX != countO + 1) {
            return false;
        }
        if (lineX != 0 && lineO != 0) return false;
        if (lineX > 0 && countX != countO + 1) return false;
        if (lineO > 0 && countX != countO) return false;
        return true;
    }
}
