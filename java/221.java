// 221. Maximal Square
// Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
//
// Example 1:
// Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
// Output: 4
// Example 2:
// Input: matrix = [["0","1"],["1","0"]]
// Output: 1
// Example 3:
// Input: matrix = [["0"]]
// Output: 0
//
// Constraints:
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 300
// matrix[i][j] is '0' or '1'.
//
// Runtime: 4 ms, faster than 90.64% of Java online submissions for Maximal Square.
// Memory Usage: 42.2 MB, less than 43.09% of Java online submissions for Maximal Square.
class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] countMatrix = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            countMatrix[i][0] = Character.getNumericValue(matrix[i][0]);
            if (countMatrix[i][0] == 1) max = 1;
        }
        for (int i = 1; i < matrix[0].length; i++) {
            countMatrix[0][i] = Character.getNumericValue(matrix[0][i]);
            if (countMatrix[0][i] == 1) max = 1;
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') countMatrix[i][j] = 0;
                else {
                    countMatrix[i][j] = Math.min(Math.min(countMatrix[i-1][j], countMatrix[i-1][j-1]), countMatrix[i][j-1]) + 1;
                    if (countMatrix[i][j] > max) max = countMatrix[i][j];
                }
            }
        }
        return max * max;
    }
}