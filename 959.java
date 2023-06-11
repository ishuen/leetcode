// 959. Regions Cut By Slashes
//
// An n x n grid is composed of 1 x 1 squares where each 1 x 1 square consists of a '/', '\', or blank space ' '. These characters divide the square into contiguous regions.
//
// Given the grid grid represented as a string array, return the number of regions.
//
// Note that backslash characters are escaped, so a '\' is represented as '\\'.
//
//
//
// Example 1:
//
//
// Input: grid = [" /","/ "]
// Output: 2
// Example 2:
//
//
// Input: grid = [" /","  "]
// Output: 1
// Example 3:
//
//
// Input: grid = ["/\\","\\/"]
// Output: 5
// Explanation: Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to /\.
//
//
// Constraints:
//
// n == grid.length == grid[i].length
// 1 <= n <= 30
// grid[i][j] is either '/', '\', or ' '.
//
// Runtime 11 ms Beats 19.15%
// Memory 41.6 MB Beats 57.2%
class Solution {
    public int regionsBySlashes(String[] grid) {
        int width = grid.length;
        int[][] expanded = new int[3 * width][3 * width];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                char c = grid[i].charAt(j);
                if (c == '/') {
                    expanded[3 * i][3 * j + 2] = -1;
                    expanded[3 * i + 1][3 * j + 1] = -1;
                    expanded[3 * i + 2][3 * j] = -1;
                } else if (c == '\\') {
                    expanded[3 * i][3 * j] = -1;
                    expanded[3 * i + 1][3 * j + 1] = -1;
                    expanded[3 * i + 2][3 * j + 2] = -1;
                }
            }
        }
        int region = 0;
        for (int i = 0; i < expanded.length; i++) {
            for (int j = 0; j < expanded[i].length; j++) {
                if (expanded[i][j] == 0) {
                    region++;
                    mark(i, j, expanded, region);
                }
            }
        }
        return region;
    }

    private int[][] direction = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    private void mark(int row, int col, int[][] expanded, int region) {
        if (expanded[row][col] == 0) {
            expanded[row][col] = region;
        } else {
            return;
        }
        for (int i = 0; i < direction.length; i++) {
            int nextRow = row + direction[i][0];
            int nextCol = col + direction[i][1];
            if (nextRow >= 0 && nextRow < expanded.length && nextCol >= 0 && nextCol < expanded[0].length) {
                mark(nextRow, nextCol, expanded, region);
            }
        }
    }
}