// 63. Unique Paths II
// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
// An obstacle and space is marked as 1 and 0 respectively in the grid.
//
//
//
// Example 1:
//
//
// Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
// Output: 2
// Explanation: There is one obstacle in the middle of the 3x3 grid above.
// There are two ways to reach the bottom-right corner:
// 1. Right -> Right -> Down -> Down
// 2. Down -> Down -> Right -> Right
// Example 2:
//
//
// Input: obstacleGrid = [[0,1],[0,0]]
// Output: 1
//
//
// Constraints:
//
// m == obstacleGrid.length
// n == obstacleGrid[i].length
// 1 <= m, n <= 100
// obstacleGrid[i][j] is 0 or 1.
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths II.
// Memory Usage: 38.2 MB, less than 50.02% of Java online submissions for Unique Paths II.
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] vertice = new int[m][n];
        boolean hasObstacle = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                hasObstacle = true;
            }
            vertice[i][0] = hasObstacle == true ? 0 : 1;
        }
        hasObstacle = false;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                hasObstacle = true;
            }
            vertice[0][i] = hasObstacle == true ? 0 : 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    vertice[i][j] = 0;
                } else {
                    vertice[i][j] = vertice[i - 1][j] + vertice[i][j - 1];
                }
            }
        }
        return vertice[m - 1][n - 1];
    }
}