// 1034. Coloring A Border
//
// You are given an m x n integer matrix grid, and three integers row, col, and color. Each value in the grid represents the color of the grid square at that location.
//
// Two squares are called adjacent if they are next to each other in any of the 4 directions.
//
// Two squares belong to the same connected component if they have the same color and they are adjacent.
//
// The border of a connected component is all the squares in the connected component that are either adjacent to (at least) a square not in the component, or on the boundary of the grid (the first or last row or column).
//
// You should color the border of the connected component that contains the square grid[row][col] with color.
//
// Return the final grid.
//
//
//
// Example 1:
//
// Input: grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
// Output: [[3,3],[3,2]]
// Example 2:
//
// Input: grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
// Output: [[1,3,3],[2,3,3]]
// Example 3:
//
// Input: grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
// Output: [[2,2,2],[2,1,2],[2,2,2]]
//
//
// Constraints:
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 50
// 1 <= grid[i][j], color <= 1000
// 0 <= row < m
// 0 <= col < n
//
// Runtime 1 ms Beats 71.43%
// Memory 44.2 MB Beats 45.41%
class Solution {
    private int base;
    private int color;
    private int[][] directions = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] isVisited = new boolean[grid.length][grid[0].length];
        this.base = grid[row][col];
        this.color = color;
        changeColor(grid, isVisited, row, col);
        return grid;
    }

    private void changeColor(int[][] grid, boolean[][] isVisited, int row, int col) {
        if (isVisited[row][col] == true) return;
        if (grid[row][col] != base) return;
        isVisited[row][col] = true;
        if (row == 0 || row == grid.length - 1 || col == 0 || col == grid[0].length - 1) {
            grid[row][col] = color;
        }
        for (int i = 0; i < 4; i++) {
            int nextRow = row + directions[i][0];
            int nextCol = col + directions[i][1];
            if (nextRow < 0 || nextRow >= grid.length || nextCol < 0 || nextCol >= grid[0].length) continue;
            if (isVisited[nextRow][nextCol] == false && grid[nextRow][nextCol] != base) {
                grid[row][col] = color;
            } else {
                changeColor(grid, isVisited, nextRow, nextCol);
            }
        }
    }
}

