// 130. Surrounded Regions

// You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

// Connect: A cell is connected to adjacent cells horizontally or vertically.
// Region: To form a region connect every 'O' cell.
// Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
// To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.

 

// Example 1:

// Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

// Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

// Explanation:


// In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

// Example 2:

// Input: board = [["X"]]

// Output: [["X"]]

 

// Constraints:

// m == board.length
// n == board[i].length
// 1 <= m, n <= 200
// board[i][j] is 'X' or 'O'.

// Runtime 0 ms Beats 100.00%
// Memory 8.32 MB Beats 66.38%
func solve(board [][]byte)  {
  
  for i := 0; i < len(board); i++ {
    if board[i][0] == byte('O') {
        traverse(i, 0, board)
    }
    if board[i][len(board[0]) - 1] == byte('O') {
        traverse(i, len(board[0]) - 1, board)
    }
  }
  for i := 0; i < len(board[0]); i++ {
    if board[0][i] == byte('O') {
        traverse(0, i, board)
    }
    if board[len(board) - 1][i] == byte('O') {
        traverse(len(board) - 1, i, board)
    }
  }
  for i := 0; i < len(board); i++ {
    for j := 0; j < len(board[0]); j++ {
        if board[i][j] == byte('O') {
            board[i][j] = byte('X')
        } else if board[i][j] == byte('-') {
            board[i][j] = byte('O')
        }
    }
  }
}

func traverse(row int, col int, board [][]byte) {
    directions := [][]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}
    board[row][col] = byte('-')
    for i := 0; i < 4; i++ {
        r := row + directions[i][0]
        c := col + directions[i][1]
        if r < 0 || c < 0 || r >= len(board) || c >= len(board[0]) {
            continue
        }
        if board[r][c] == byte('O') {
            traverse(r, c, board)
        }
    }
}