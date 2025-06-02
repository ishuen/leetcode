// 289. Game of Life
//
// According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
//
// The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
//
// Any live cell with fewer than two live neighbors dies as if caused by under-population.
// Any live cell with two or three live neighbors lives on to the next generation.
// Any live cell with more than three live neighbors dies, as if by over-population.
// Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
// The next state of the board is determined by applying the above rules simultaneously to every cell in the current state of the m x n grid board. In this process, births and deaths occur simultaneously.
//
// Given the current state of the board, update the board to reflect its next state.
//
// Note that you do not need to return anything.
//
//
//
// Example 1:
//
//
// Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
// Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
// Example 2:
//
//
// Input: board = [[1,1],[1,0]]
// Output: [[1,1],[1,1]]
//
//
// Constraints:
//
// m == board.length
// n == board[i].length
// 1 <= m, n <= 25
// board[i][j] is 0 or 1.
//
//
// Follow up:
//
// Could you solve it in-place? Remember that the board needs to be updated simultaneously: You cannot update some cells first and then use their updated values to update other cells.
// In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches upon the border of the array (i.e., live cells reach the border). How would you address these problems?
//
// Runtime 2 ms Beats 48.37%
// Memory 55.50 MB Beats 72.83%
/**
 Do not return anything, modify board in-place instead.
 */
function gameOfLife(board: number[][]): void {
    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            board[i][j] = check(i, j, board)
        }
    }
    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[0].length; j++) {
            if (board[i][j] == -1) {
                board[i][j] = 1
            } else if (board[i][j] == -2) {
                board[i][j] = 0
            }
        }
    }
};

function check(row: number, col: number, board: number[][]): number {
    let count = 0
    for (let i = -1; i < 2; i++) {
        let r = row + i
        for (let j = -1; j < 2; j++) {
            let c = col + j
            if (r == row && c == col) continue
            if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) continue
            if (board[r][c] == 1 || board[r][c] == -2) count++
        }
    }
    if (board[row][col] == 1) {
        if (count == 2 || count == 3) return 1
        else return -2
    }
    return count == 3 ? -1 : 0
}

/*
neighbor:
    1 + 1 * 1 -> 0
    1 + 1 * 2 or 3 -> 1
    1 + 1 * 3+ -> 0
    0 + 1 * 3 -> 1

1 -> 0 => -2
0 -> 1 => -1
*/