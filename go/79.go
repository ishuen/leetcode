// 79. Word Search

// Given an m x n grid of characters board and a string word, return true if word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

// Example 1:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
// Output: true
// Example 2:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
// Output: true
// Example 3:


// Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
// Output: false
 

// Constraints:

// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board and word consists of only lowercase and uppercase English letters.

// Runtime 120 ms Beats 59.13%
// Memory 4.21 MB Beats 34.56%
func exist(board [][]byte, word string) bool {
    directions := [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
    var findWord func (row, col, index int, visited [][]bool) bool
    findWord = func(row, col, index int, visited [][]bool) bool {
        if index == len(word) {
            return true
        }
        for i := 0; i < 4; i++ {
            r := row + directions[i][0]
            c := col + directions[i][1]
            if r < 0 || c < 0 || r >= len(board) || c >= len(board[0]) {
                continue
            }
            if board[r][c] == word[index] && visited[r][c] == false {
                visited[r][c] = true
                if findWord(r, c, index + 1, visited) == true {
                    return true
                }
                visited[r][c] = false
            }
        }
        return false
    }
    
    for i := 0; i < len(board); i++ {
        for j := 0; j < len(board[0]); j++ {
            visited := make([][]bool, len(board))
            for k := 0; k < len(visited); k++ {
                visited[k] = make([]bool, len(board[0]))
            }
            if board[i][j] != word[0] {
                continue
            }
            visited[i][j] = true
            if findWord(i, j, 1, visited) == true {
                return true
            }
            visited[i][j] = false
        }
    }
    return false
}


// Runtime 98 ms Beats 82.39%
// Memory 4.14 MB Beats 60.71%
func exist(board [][]byte, word string) bool {
    directions := [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
    var findWord func (row, col, index int) bool
    findWord = func(row, col, index int) bool {
        if index == len(word) {
            return true
        }
        for i := 0; i < 4; i++ {
            r := row + directions[i][0]
            c := col + directions[i][1]
            if r < 0 || c < 0 || r >= len(board) || c >= len(board[0]) {
                continue
            }
            if board[r][c] == word[index] {
                board[r][c] = '-'
                if findWord(r, c, index + 1) == true {
                    return true
                }
                board[r][c] = word[index]
            }
        }
        return false
    }
    
    for i := 0; i < len(board); i++ {
        for j := 0; j < len(board[0]); j++ {
            if board[i][j] != word[0] {
                continue
            }
            board[i][j] = '-'
            if findWord(i, j, 1) == true {
                return true
            }
            board[i][j] = word[0]
        }
    }
    return false
}