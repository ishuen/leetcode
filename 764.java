// 764. Largest Plus Sign
// You are given an integer n. You have an n x n binary grid grid with all values initially 1's except for some indices given in the array mines. The ith element of the array mines is defined as mines[i] = [xi, yi] where grid[xi][yi] == 0.
//
// Return the order of the largest axis-aligned plus sign of 1's contained in grid. If there is none, return 0.
//
// An axis-aligned plus sign of 1's of order k has some center grid[r][c] == 1 along with four arms of length k - 1 going up, down, left, and right, and made of 1's. Note that there could be 0's or 1's beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1's.
//
//
//
// Example 1:
//
//
// Input: n = 5, mines = [[4,2]]
// Output: 2
// Explanation: In the above grid, the largest plus sign can only be of order 2. One of them is shown.
// Example 2:
//
//
// Input: n = 1, mines = [[0,0]]
// Output: 0
// Explanation: There is no plus sign, so return 0.
//
//
// Constraints:
//
// 1 <= n <= 500
// 1 <= mines.length <= 5000
// 0 <= xi, yi < n
// All the pairs (xi, yi) are unique.
//
// Runtime: 31 ms, faster than 79.04% of Java online submissions for Largest Plus Sign.
// Memory Usage: 41.1 MB, less than 92.76% of Java online submissions for Largest Plus Sign.
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(matrix[i], n);
        }
        for (int[] mine: mines) {
            matrix[mine[0]][mine[1]] = 0;
        }
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = 0;
            int up = 0;
            int down = 0;
            int j = 0;
            int k = n - 1;
            while (j < n) {
                // ith row
                left = matrix[i][j] == 0 ? 0 : left + 1;
                matrix[i][j] = Math.min(matrix[i][j], left);
                right = matrix[i][k] == 0 ? 0 : right + 1;
                matrix[i][k] = Math.min(matrix[i][k], right);
                // ith col
                up = matrix[j][i] == 0 ? 0 : up + 1;
                matrix[j][i] = Math.min(matrix[j][i], up);
                down = matrix[k][i] == 0 ? 0 : down + 1;
                matrix[k][i] = Math.min(matrix[k][i], down);
                j++;
                k--;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > max) max = matrix[i][j];
            }
        }
        return max;
    }
}

// if n < 3 -> max level 1
// if n is an even number, max level = n - 1

// create a matrix with all n
// set 0 at mine position

