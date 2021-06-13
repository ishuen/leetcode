// 695. Max Area of Island
// You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
//
// The area of an island is the number of cells with a value 1 in the island.
//
// Return the maximum area of an island in grid. If there is no island, return 0.
//
//
//
// Example 1:
//
//
// Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
// Output: 6
// Explanation: The answer is not 11, because the island must be connected 4-directionally.
// Example 2:
//
// Input: grid = [[0,0,0,0,0,0,0,0]]
// Output: 0
//
//
// Constraints:
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 50
// grid[i][j] is either 0 or 1.
//
// Runtime: 2 ms, faster than 99.61% of Java online submissions for Max Area of Island.
// Memory Usage: 44.7 MB, less than 16.54% of Java online submissions for Max Area of Island.
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int area = 0;
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    area = calculateArea(i, j, grid);
                    if (area > max) max = area;
                }
            }
        }
        return max;
    }
    
    private int calculateArea(int row, int col, int[][] grid) {
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length) return 0;
        if (grid[row][col] == 0) return 0;
        grid[row][col] = 0;
        return 1 + calculateArea(row + 1, col, grid) + calculateArea(row - 1, col, grid) + calculateArea(row, col + 1, grid) + calculateArea(row, col - 1, grid);
    }
}

// 1. traverse each cell from top left to bottom right
// 2. if 1 => function calculate the island size, flip the counted 1
// 3. compare it with the current max area