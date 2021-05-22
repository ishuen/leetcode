// 74. Search a 2D Matrix
// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
//
// Integers in each row are sorted from left to right.
// The first integer of each row is greater than the last integer of the previous row.
//
//
// Example 1:
//
//
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true
// Example 2:
//
//
// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false
//
//
// Constraints:
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -10^4 <= matrix[i][j], target <= 10^4
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Search a 2D Matrix.
// Memory Usage: 38 MB, less than 97.58% of Java online submissions for Search a 2D Matrix.

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == target) return true;
            if (i == 0 && matrix[i][0] > target) return false;
            if (i > 0 && matrix[i][0] > target) {
                row = i - 1;
                break;
            }
            if (i == matrix.length - 1 && matrix[i][0] < target) {
                row = matrix.length - 1;
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[row][i] == target) return true;
            if (matrix[row][i] > target) return false;
        }
        return false;
    }
}

// bucket sort but the range is not defined
// 1. to check which row a target might belong to
// 2. to check which cell in that row has the target