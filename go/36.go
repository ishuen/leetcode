// 36. Valid Sudoku

// Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
// Note:

// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.
 

// Example 1:


// Input: board = 
// [["5","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: true
// Example 2:

// Input: board = 
// [["8","3",".",".","7",".",".",".","."]
// ,["6",".",".","1","9","5",".",".","."]
// ,[".","9","8",".",".",".",".","6","."]
// ,["8",".",".",".","6",".",".",".","3"]
// ,["4",".",".","8",".","3",".",".","1"]
// ,["7",".",".",".","2",".",".",".","6"]
// ,[".","6",".",".",".",".","2","8","."]
// ,[".",".",".","4","1","9",".",".","5"]
// ,[".",".",".",".","8",".",".","7","9"]]
// Output: false
// Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 

// Constraints:

// board.length == 9
// board[i].length == 9
// board[i][j] is a digit 1-9 or '.'.

// Runtime 0 ms Beats 100.00%
// Memory 4.56 MB Beats 98.42%
func isValidSudoku(board [][]byte) bool {
    for i := 0; i < 9; i++ {
        if !checkRow(i, board) {
            return false
        }
        if !checkCol(i, board) {
            return false
        }
    }
    for i := 0; i < 3; i++ {
        for j := 0; j < 3; j++ {
            if !checkBox(i * 3, j * 3, board) {
                return false
            }
        }
    }
    return true
}

func checkRow(row int, board [][]byte) bool {
    occurrence := make(map[byte]int)
    for i := 0; i < len(board[0]); i++ {
        if board[row][i] == '.' {
            continue
        }
        _, ok := occurrence[board[row][i]]
        if ok {
            return false
        }
        occurrence[board[row][i]]++
    }
    return true
}

func checkCol(col int, board [][]byte) bool {
    occurrence := make(map[byte]int)
    for i := 0; i < len(board); i++ {
        if board[i][col] == '.' {
            continue
        }
        _, ok := occurrence[board[i][col]]
        if ok {
            return false
        }
        occurrence[board[i][col]]++
    }
    return true
}

func checkBox(row, col int, board [][]byte) bool {
    occurrence := make(map[byte]int)
    for i := 0; i < 3; i++ {
        for j := 0; j < 3; j++ {
            if board[row + i][col + j] == '.' {
                continue
            }
            _, ok := occurrence[board[row + i][col + j]]
            if ok {
                return false
            }
            occurrence[board[row + i][col + j]]++
        }
    }
    return true
}