// 1020. Number of Enclaves
//
// You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.
//
// A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.
//
// Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.
//
//
//
// Example 1:
//
//
// Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
// Output: 3
// Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.
// Example 2:
//
//
// Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
// Output: 0
// Explanation: All 1s are either on the boundary or can reach the boundary.
//
//
// Constraints:
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 500
// grid[i][j] is either 0 or 1.
//
// Runtime 15 ms Beats 17.41%
// Memory 55.7 MB Beats 37.83%
class Solution {
    private int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int[][] grid;
    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                dfs(0, i, true);
            }
            if (grid[grid.length - 1][i] == 1) {
                dfs(grid.length - 1, i, true);
            }
        }
        for (int i = 1; i < grid.length - 1; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0, true);
            }
            if (grid[i][grid[0].length - 1] == 1) {
                dfs(i, grid[0].length - 1, true);
            }       
        }
        int count = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 1) {
                    count = count + dfs(i, j, false);
                }
            }
        }
        return count;
    }

    private int dfs(int row, int col, boolean isBoundry) {
        if (grid[row][col] == 0) return 0;
        int count = 1;
        grid[row][col] = 0;    
        for (int i = 0; i < 4; i++) {
            int nextRow = row + directions[i][0];
            int nextCol = col + directions[i][1];
            if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) continue;
            count = count + dfs(nextRow, nextCol, isBoundry);
        }
        return isBoundry ? 0 : count;
    }
}

// Runtime 9 ms Beats 81.81%
// Memory 53.9 MB Beats 84.70%
class Solution {
    private int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int[][] grid;
    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        for (int i = 0; i < grid[0].length; i++) {
            if (grid[0][i] == 1) {
                dfs(0, i);
            }
            if (grid[grid.length - 1][i] == 1) {
                dfs(grid.length - 1, i);
            }
        }
        for (int i = 1; i < grid.length - 1; i++) {
            if (grid[i][0] == 1) {
                dfs(i, 0);
            }
            if (grid[i][grid[0].length - 1] == 1) {
                dfs(i, grid[0].length - 1);
            }       
        }
        int count = 0;
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int row, int col) {
        if (grid[row][col] == 0) return;
        grid[row][col] = 0;    
        for (int i = 0; i < 4; i++) {
            int nextRow = row + directions[i][0];
            int nextCol = col + directions[i][1];
            if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) continue;
            dfs(nextRow, nextCol);
        }
    }
}