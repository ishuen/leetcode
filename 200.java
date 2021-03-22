// 200. Number of Islands
// Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
//
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//
//
// Example 1:
//
// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1
// Example 2:
//
// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3
//
//
// Constraints:
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'.
//
// Runtime: 1 ms, faster than 99.99% of Java online submissions for Number of Islands.
// Memory Usage: 41.9 MB, less than 22.67% of Java online submissions for Number of Islands.

class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    checkConnection(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void checkConnection(char[][] grid, int i, int j) {
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            if (i < grid.length - 1) {
                checkConnection(grid, i + 1, j);
            }
            if (i > 0) {
                checkConnection(grid, i - 1, j);
            }
            if (j < grid[i].length - 1) {
                checkConnection(grid, i, j + 1);
            }
            if (j > 0) {
                checkConnection(grid, i, j - 1);
            }
        }
    }
}