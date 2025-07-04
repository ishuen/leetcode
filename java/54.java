// 54. Spiral Matrix
// Given an m x n matrix, return all elements of the matrix in spiral order.
//
//
//
// Example 1:
//
//
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]
// Example 2:
//
//
// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]
//
//
// Constraints:
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
// Runtime 0 ms Beats 100%
// Memory 40.9 MB Beats 31.34%
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        List<Integer> ans = new LinkedList<>();
        while (rowStart <= rowEnd && colStart <= colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                ans.add(matrix[rowStart][i]);
            }
            if (rowStart == rowEnd) break;
            for (int i = rowStart + 1; i <= rowEnd; i++) {
                ans.add(matrix[i][colEnd]);
            }
            if (colStart == colEnd) break;
            for (int i = colEnd - 1; i >= colStart; i--) {
                ans.add(matrix[rowEnd][i]);
            }
            rowStart++;
            for (int i = rowEnd - 1; i >= rowStart; i--) {
                ans.add(matrix[i][colStart]);
            }
            rowEnd--;
            colStart++;
            colEnd--;
        }
        return ans;
    }
}
