// 200. Number of Islands

// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

// Example 1:

// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1
// Example 2:

// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'.

// Runtime 2 ms Beats 87.37%
// Memory 5.77 MB Beats 63.40%
func numIslands(grid [][]byte) int {
    count := 0
    for i := 0; i < len(grid); i++ {
        for j := 0; j < len(grid[0]); j++ {
            if grid[i][j] == byte('1') {
                count++
                flipIslands(i, j, grid)
            }
        }
    }
    return count
}

func flipIslands(row int, col int, grid [][]byte) {
    grid[row][col] = byte('0')
    directions := [][]int{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}
    for i := 0; i < 4; i++ {
        r := row + directions[i][0]
        c := col + directions[i][1]
        if r >= len(grid) || r < 0 || c >= len(grid[0]) || c < 0 {
            continue
        }
        if grid[r][c] == byte('1') {
            flipIslands(r, c, grid)
        }
    }
}