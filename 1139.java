// 1139. Largest 1-Bordered Square
//
// Given a 2D grid of 0s and 1s, return the number of elements in the largest square subgrid that has all 1s on its border, or 0 if such a subgrid doesn't exist in the grid.
//
//
//
// Example 1:
//
// Input: grid = [[1,1,1],[1,0,1],[1,1,1]]
// Output: 9
// Example 2:
//
// Input: grid = [[1,1,0,0]]
// Output: 1
//
//
// Constraints:
//
// 1 <= grid.length <= 100
// 1 <= grid[0].length <= 100
// grid[i][j] is 0 or 1
//
// Runtime 3 ms Beats 100.00% of users with Java
// Memory 45.34 MB Beats 6.52% of users with Java
class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int maxWidth = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int width = 0;
                while (j + width < grid[0].length && grid[i][j + width] == 1) {
                    width++;
                    if (width > maxWidth && checkSquare(i, j, width, grid)) {
                        maxWidth = width;
                    }
                }
            }
        }
        return maxWidth * maxWidth;
    }
    private boolean checkSquare(int row, int col, int width, int[][] grid) {
        if (row + width > grid.length) return false;
        if (col + width > grid[0].length) return false;
        for (int i = 0; i < width; i++) {
            if (grid[row + i][col] != 1) return false;
            if (grid[row + i][col + width - 1] != 1) return false;
        }
        for (int j = 1; j < width - 1; j++) {
            if (grid[row][col + j] != 1) return false;
            if (grid[row + width - 1][col + j] != 1) return false;
        }
        return true;
    }
}