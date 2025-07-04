// 1219. Path with Maximum Gold
//
// In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.
//
// Return the maximum amount of gold you can collect under the conditions:
//
// Every time you are located in a cell you will collect all the gold in that cell.
// From your position, you can walk one step to the left, right, up, or down.
// You can't visit the same cell more than once.
// Never visit a cell with 0 gold.
// You can start and stop collecting gold from any position in the grid that has some gold.
//
//
// Example 1:
//
// Input: grid = [[0,6,0],[5,8,7],[0,9,0]]
// Output: 24
// Explanation:
// [[0,6,0],
//  [5,8,7],
//  [0,9,0]]
// Path to get the maximum gold, 9 -> 8 -> 7.
// Example 2:
//
// Input: grid = [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
// Output: 28
// Explanation:
// [[1,0,7],
//  [2,0,6],
//  [3,4,5],
//  [0,3,0],
//  [9,0,20]]
// Path to get the maximum gold, 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7.
//
//
// Constraints:
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 15
// 0 <= grid[i][j] <= 100
// There are at most 25 cells containing gold.
//
// Runtime 16 ms Beats 98.68%
// Memory 41.54 MB Beats 37.76%
class Solution {
    public int getMaximumGold(int[][] grid) {
        int total = getAll(grid);
        if (total > 0) return total;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                backtrack(i, j, grid, 0);
            }
        }
        return maxGold;
    }

    private int getAll(int[][] grid) {
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) return 0;
                total += grid[i][j];
            }
        }
        return total;
    }

    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int maxGold = 0;
    private void backtrack(int row, int col, int[][] grid, int current) {
        if (grid[row][col] <= 0) return;
        current = current + grid[row][col];
        maxGold = Math.max(maxGold, current);
        grid[row][col] = -grid[row][col];
        for (int i = 0; i < 4; i++) {
            int r = row + directions[i][0];
            int c = col + directions[i][1];
            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] <= 0) continue;
            backtrack(r, c, grid, current);
        }
        grid[row][col] = -grid[row][col];
    }
}
