// 498. Diagonal Traverse
// Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
//
// Example 1:
//
//
// Input: mat = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,4,7,5,3,6,8,9]
// Example 2:
//
// Input: mat = [[1,2],[3,4]]
// Output: [1,2,3,4]
//
//
// Constraints:
//
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 104
// 1 <= m * n <= 104
// -105 <= mat[i][j] <= 105
//
// Runtime: 2 ms, faster than 93.70% of Java online submissions for Diagonal Traverse.
// Memory Usage: 41.3 MB, less than 49.17% of Java online submissions for Diagonal Traverse.
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int index = 0;
        int length = mat.length * mat[0].length;
        int height = mat.length;
        int width = mat[0].length;
        int[] ans = new int[length];
        int row = 0;
        int col = 0;
        int direction = 1;
        while (index < length) {
            ans[index] = mat[row][col];
            if (row == 0 && direction == 1) {
                if (col == width - 1) {
                    row++;
                } else col++;
                direction = 0;
            } else if (direction == 1) {
                if (col == width - 1) {
                    row++;
                    direction = 0;
                } else {
                    row--;
                    col++;
                }
            } else if (row == height - 1 && direction == 0) {
                col++;
                direction = 1;
            } else {
                if (col == 0) {
                    row++;
                    direction = 1;
                } else {
                    row++;
                    col--;
                }
            }
            index++;
        }
        return ans;
    }
}