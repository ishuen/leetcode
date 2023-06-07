// 931. Minimum Falling Path Sum
//
// Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
//
// A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
//
//
//
// Example 1:
//
//
// Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
// Output: 13
// Explanation: There are two falling paths with a minimum sum as shown.
// Example 2:
//
//
// Input: matrix = [[-19,57],[-40,-5]]
// Output: -59
// Explanation: The falling path with a minimum sum is shown.
//
//
// Constraints:
//
// n == matrix.length == matrix[i].length
// 1 <= n <= 100
// -100 <= matrix[i][j] <= 100
//
// Runtime 5 ms Beats 57.60%
// Memory 44.7 MB Beats 5.77%
    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 1) {
            int min = matrix[0][0];
            for (int i = 1; i < matrix[0].length; i++) {
                min = Math.min(min, matrix[0][i]);
            }
            return min;
        }
        int[][] sum = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            sum[0][i] = matrix[0][i];
        }
        int minSum = Integer.MAX_VALUE;
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int minIndex = j;
                int min = sum[i - 1][j];
                if (j - 1 >= 0 && sum[i - 1][j - 1] < min) {
                    min = sum[i - 1][j - 1];
                    minIndex = j - 1;
                }
                if (j + 1 < matrix[0].length && sum[i - 1][j + 1] < min) {
                    min = sum[i - 1][j + 1];
                    minIndex = j + 1;
                }
                sum[i][j] = matrix[i][j] + sum[i - 1][minIndex];
                if (i == matrix.length - 1) {
                    minSum = Math.min(sum[i][j], minSum);
                }
            }
        }
        return minSum;
    }
}

// Runtime 5 ms Beats 57.60%
// Memory 44.1 MB Beats 13.11%
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int[][] backwardMatrix = new int[matrix.length + 1][matrix.length + 2];
        for (int i = 0; i < matrix.length; i++) {
            backwardMatrix[i][0] = Integer.MAX_VALUE;
            backwardMatrix[i][matrix.length + 1] = Integer.MAX_VALUE;
        }
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = 1; j <= matrix.length; j++) {
                backwardMatrix[i][j] = matrix[i][j - 1] + Math.min(
                    backwardMatrix[i + 1][j], Math.min(backwardMatrix[i + 1][j-1], backwardMatrix[i + 1][j + 1]));
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= matrix.length; i++) {
            min = Math.min(min, backwardMatrix[0][i]);
        }
        return min;
    }
}