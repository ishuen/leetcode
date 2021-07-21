// 329. Longest Increasing Path in a Matrix
// Given an m x n integers matrix, return the length of the longest increasing path in matrix.
//
// From each cell, you can either move in four directions: left, right, up, or down. You may not move diagonally or move outside the boundary (i.e., wrap-around is not allowed).
//
//
//
// Example 1:
//
//
// Input: matrix = [[9,9,4],[6,6,8],[2,1,1]]
// Output: 4
// Explanation: The longest increasing path is [1, 2, 6, 9].
// Example 2:
//
//
// Input: matrix = [[3,4,5],[3,2,6],[2,2,1]]
// Output: 4
// Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
// Example 3:
//
// Input: matrix = [[1]]
// Output: 1
//
//
// Constraints:
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 200
// 0 <= matrix[i][j] <= 231 - 1
//
// Runtime: 8 ms, faster than 75.44% of Java online submissions for Longest Increasing Path in a Matrix.
// Memory Usage: 39.5 MB, less than 41.45% of Java online submissions for Longest Increasing Path in a Matrix.
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] path = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int count = checkNext(i, j, matrix, path);
                if (max < count) max = count;
            }
        }
        return max;
    }
    private int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int checkNext(int row, int col, int[][] matrix, int[][] path) {
        if (path[row][col] > 0) return path[row][col];
        for (int i = 0; i < 4; i++) {
            if (row + directions[i][0] >= 0 && row + directions[i][0] < matrix.length
               && col + directions[i][1] >= 0 && col + directions[i][1] < matrix[0].length) {
                if (matrix[row][col] < matrix[row + directions[i][0]][col + directions[i][1]]) {
                    path[row][col] = Math.max(path[row][col], 1 + checkNext(row + directions[i][0], col + directions[i][1], matrix, path));
                } else path[row][col] = Math.max(path[row][col], 1);
            }
        }
        return path[row][col] == 0 ? 1 : path[row][col];
    }
}