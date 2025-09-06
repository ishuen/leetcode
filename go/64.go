// 64. Minimum Path Sum

// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

 

// Example 1:


// Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
// Output: 7
// Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
// Example 2:

// Input: grid = [[1,2,3],[4,5,6]]
// Output: 12
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 200

// Runtime 0 ms Beats 100.00%
// Memory 6.69 MB Beats 92.97%
func minPathSum(grid [][]int) int {
    for i := 0; i < len(grid); i++ {
        for j := 0; j < len(grid[0]); j++ {
            if i == 0 && j > 0 {
                grid[i][j] = grid[i][j - 1] + grid[i][j]
            } else if j == 0 && i > 0 {
                grid[i][j] = grid[i - 1][j] + grid[i][j]
            } else if i > 0 && j > 0 {
                grid[i][j] = min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j]
            }
        }
    }
    return grid[len(grid) - 1][len(grid[0]) - 1]
}