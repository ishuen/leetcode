// 566. Reshape the Matrix
// In MATLAB, there is a handy function called reshape which can reshape an m x n matrix into a new one with a different size r x c keeping its original data.
//
// You are given an m x n matrix mat and two integers r and c representing the row number and column number of the wanted reshaped matrix.
//
// The reshaped matrix should be filled with all the elements of the original matrix in the same row-traversing order as they were.
//
// If the reshape operation with given parameters is possible and legal, output the new reshaped matrix; Otherwise, output the original matrix.
//
//
//
// Example 1:
//
//
// Input: mat = [[1,2],[3,4]], r = 1, c = 4
// Output: [[1,2,3,4]]
// Example 2:
//
//
// Input: mat = [[1,2],[3,4]], r = 2, c = 4
// Output: [[1,2],[3,4]]
//
//
// Constraints:
//
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 100
// -1000 <= mat[i][j] <= 1000
// 1 <= r, c <= 300
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Reshape the Matrix.
// Memory Usage: 39.7 MB, less than 89.83% of Java online submissions for Reshape the Matrix.
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] matrix = new int[r][c];
        if (r * c != mat.length * mat[0].length) return mat;
        int row = 0;
        int col = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (col == c) {
                    col = 0;
                    row++;
                }
                matrix[row][col] = mat[i][j];
                col++;
            }
        }
        return matrix;
    }
}
