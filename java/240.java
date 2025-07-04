// 240. Search a 2D Matrix II
// Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:
//
// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
//
//
// Example 1:
//
//
// Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
// Output: true
// Example 2:
//
//
// Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
// Output: false
//
//
// Constraints:
//
// m == matrix.length
// n == matrix[i].length
// 1 <= n, m <= 300
// -109 <= matix[i][j] <= 109
// All the integers in each row are sorted in ascending order.
// All the integers in each column are sorted in ascending order.
// -109 <= target <= 109
//
// Runtime: 14 ms, faster than 10.58% of Java online submissions for Search a 2D Matrix II.
// Memory Usage: 44.1 MB, less than 93.99% of Java online submissions for Search a 2D Matrix II.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] > target) break;
                else if (matrix[i][j] == target) return true;
            }
            if (matrix[i][0] > target) return false;
        }
        return false;
    }
}

// Runtime: 9 ms, faster than 24.46% of Java online submissions for Search a 2D Matrix II.
// Memory Usage: 51.3 MB, less than 13.37% of Java online submissions for Search a 2D Matrix II.
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while(col >= 0 && row <= matrix.length-1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }
}