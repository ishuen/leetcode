// 1727. Largest Submatrix With Rearrangements
//
// You are given a binary matrix matrix of size m x n, and you are allowed to rearrange the columns of the matrix in any order.
//
// Return the area of the largest submatrix within matrix where every element of the submatrix is 1 after reordering the columns optimally.
//
//
//
// Example 1:
//
//
// Input: matrix = [[0,0,1],[1,1,1],[1,0,1]]
// Output: 4
// Explanation: You can rearrange the columns as shown above.
// The largest submatrix of 1s, in bold, has an area of 4.
// Example 2:
//
//
// Input: matrix = [[1,0,1,0,1]]
// Output: 3
// Explanation: You can rearrange the columns as shown above.
// The largest submatrix of 1s, in bold, has an area of 3.
// Example 3:
//
// Input: matrix = [[1,1,0],[1,0,1]]
// Output: 2
// Explanation: Notice that you must rearrange entire columns, and there is no way to make a submatrix of 1s larger than an area of 2.
//
//
// Constraints:
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m * n <= 105
// matrix[i][j] is either 0 or 1.
//
// Runtime 9 ms Beats 93.95% of users with Java
// Memory 67.96 MB Beats 53.34% of users with Java
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            Arrays.sort(matrix[i]);
        }
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int width = col - j;
                int area = matrix[i][j] * width;
                max = Math.max(area, max);
            }
        }
        return max;
    }
}