// 289. Game of Life
// According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
//
// Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
//
// Any live cell with fewer than two live neighbors dies, as if caused by under-population.
// Any live cell with two or three live neighbors lives on to the next generation.
// Any live cell with more than three live neighbors dies, as if by over-population..
// Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
// Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
//
// Example:
//
// Input:
// [
//   [0,1,0],
//   [0,0,1],
//   [1,1,1],
//   [0,0,0]
// ]
// Output:
// [
//   [0,0,0],
//   [1,0,1],
//   [0,1,1],
//   [0,1,0]
// ]
// Follow up:
//
// Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
// In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Game of Life.
// Memory Usage: 37.6 MB, less than 10.75% of Java online submissions for Game of Life.
class Solution {
    public void gameOfLife(int[][] board) {
        if (board.length > 0) {
           int row = board.length;
            int col = board[0].length;
            int[][] output = new int[row][col];
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    int sum = 0;
                    if (j != 0) {
                        sum = sum + board[i][j - 1];
                        if (i != 0) {
                            sum = sum + board[i - 1][j - 1];
                        }
                        if (i != row - 1) {
                            sum = sum + board[i + 1][j - 1];
                        }
                    }
                    if (j != col - 1) {
                        sum = sum + board[i][j + 1];
                        if (i != 0) {
                            sum = sum + board[i - 1][j + 1];
                        }
                        if (i != row - 1) {
                            sum = sum + board[i + 1][j + 1];
                        }
                    }
                    if (i != 0) {
                        sum = sum + board[i - 1][j];
                    }
                    if (i != row - 1) {
                        sum = sum + board[i + 1][j];
                    }
                    if (board[i][j] == 1 && (sum == 2 || sum == 3)) {
                        output[i][j] = 1;
                    } else if (board[i][j] == 0 && sum == 3) {
                        output[i][j] = 1;
                    } else {
                        output[i][j] = 0;
                    }
                }
            } 
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    board[i][j] = output[i][j];
                }  
            }
        }
    }
}