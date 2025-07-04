// 64. Minimum Path Sum
// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
//
// Note: You can only move either down or right at any point in time.
//
// Example 1:
//
//
// Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
// Output: 7
// Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
// Example 2:
//
// Input: grid = [[1,2,3],[4,5,6]]
// Output: 12
//
//
// Constraints:
//
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 200
// 0 <= grid[i][j] <= 100
//
// Runtime: 2 ms, faster than 80.58% of Java online submissions for Minimum Path Sum.
// Memory Usage: 41.5 MB, less than 68.81% of Java online submissions for Minimum Path Sum.
class Solution {
    public int minPathSum(int[][] grid) {
        int[][] pathSum = new int[grid.length][grid[0].length];
        pathSum[0][0] = grid[0][0];
        for (int i = 1; i < grid.length; i++) {
            pathSum[i][0] = pathSum[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid[0].length; i++) {
            pathSum[0][i] = pathSum[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                pathSum[i][j] = Math.min(pathSum[i-1][j], pathSum[i][j-1]) + grid[i][j];
            }
        }
        return pathSum[grid.length - 1][grid[0].length - 1];
    }
}