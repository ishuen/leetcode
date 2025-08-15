// 52. N-Queens II

// The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

// Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

// Example 1:


// Input: n = 4
// Output: 2
// Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
// Example 2:

// Input: n = 1
// Output: 1
 

// Constraints:

// 1 <= n <= 9

// Runtime 1 ms Beats 42.93%
// Memory 3.95 MB Beats 39.79%
func totalNQueens(n int) int {
    board := make([][]bool, n)
    for row := range board {
        board[row] = make([]bool, n)
    }
    return fitQueens(0, n, board)
}

func fitQueens(cur int, target int, board [][]bool) int {
    count := 0
    for i := 0; i < target; i++ {
        board[cur][i] = true
        if (isValid(cur, i, board)) {
            if (cur == target - 1) {
                count++
            } else {
                count = count + fitQueens(cur + 1, target, board)
            }
        }
        board[cur][i] = false
    }
    return count
}

func isValid(row int, col int, board [][]bool) bool {
    for i := 1; i <= row; i++ {
        if board[row - i][col] == true {
            return false
        }
        if col - i >= 0 && board[row - i][col - i] == true {
            return false
        }
        if col + i < len(board) && board[row - i][col + i] == true {
            return false
        }
    }
    return true
}