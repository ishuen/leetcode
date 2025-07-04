// 1254. Number of Closed Islands
//
// Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.
//
// Return the number of closed islands.
//
//
//
// Example 1:
//
//
//
// Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
// Output: 2
// Explanation:
// Islands in gray are closed because they are completely surrounded by water (group of 1s).
// Example 2:
//
//
//
// Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
// Output: 1
// Example 3:
//
// Input: grid = [[1,1,1,1,1,1,1],
//                [1,0,0,0,0,0,1],
//                [1,0,1,1,1,0,1],
//                [1,0,1,0,1,0,1],
//                [1,0,1,1,1,0,1],
//                [1,0,0,0,0,0,1],
//                [1,1,1,1,1,1,1]]
// Output: 2
//
//
// Constraints:
//
// 1 <= grid.length, grid[0].length <= 100
// 0 <= grid[i][j] <=1
//
// Runtime 2ms Beats 96.89%of users with Java
// Memory 43.37MB Beats 48.68%of users with Java
class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        for (int j = 0; j < grid[0].length; j++) {
            mark(0, j, grid);
            mark(grid.length - 1, j, grid);
        }
        for (int i = 0; i < grid.length; i++) {
            mark(i, 0, grid);
            mark(i, grid[0].length - 1, grid);
        }
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    mark(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private void mark(int row, int col, int[][] grid) {
        if (grid[row][col] == 0) {
            grid[row][col] = -1;
            for (int[] direction: directions) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) continue;
                mark(r, c, grid);
            }
        }
    }
}
