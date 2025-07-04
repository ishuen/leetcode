// 1277. Count Square Submatrices with All Ones
//
// Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
//
//
//
// Example 1:
//
// Input: matrix =
// [
//   [0,1,1,1],
//   [1,1,1,1],
//   [0,1,1,1]
// ]
// Output: 15
// Explanation:
// There are 10 squares of side 1.
// There are 4 squares of side 2.
// There is  1 square of side 3.
// Total number of squares = 10 + 4 + 1 = 15.
// Example 2:
//
// Input: matrix =
// [
//   [1,0,1],
//   [1,1,0],
//   [1,1,0]
// ]
// Output: 7
// Explanation:
// There are 6 squares of side 1.
// There is 1 square of side 2.
// Total number of squares = 6 + 1 = 7.
//
//
// Constraints:
//
// 1 <= arr.length <= 300
// 1 <= arr[0].length <= 300
// 0 <= arr[i][j] <= 1
//
// Runtime 88ms Beats 5.07%of users with Java
// Memory 53.89MB Beats 79.19%of users with Java
class Solution {
    public int countSquares(int[][] matrix) {
        if (matrix.length == 1) {
            int count = 0;
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == 1) count++;
            }
            return count;
        }

        if (matrix[0].length == 1) {
            int count = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == 1) count++;
            }
            return count;
        }
        int[][] minorMatrix = new int[matrix.length - 1][matrix[0].length - 1];
        int count = 0;
        for (int i = 0 ; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
                if (i < matrix.length - 1 && j < matrix[0].length - 1) {
                    if (matrix[i][j] == 1 && matrix[i + 1][j] == 1 
                    && matrix[i][j + 1] == 1 && matrix[i + 1][j + 1] == 1) {
                        minorMatrix[i][j] = 1;
                    } else {
                        minorMatrix[i][j] = 0;
                    }
                }
                
            }
        }
        return count + countSquares(minorMatrix);
    }
}

// Runtime 7ms Beats 44.38%of users with Java
// Memory 53.89MB Beats 79.19%of users with Java
class Solution {
    public int countSquares(int[][] matrix) {
        int count = 0;
        for (int row = 0; row < matrix.length; row++){
            for (int col = 0; col < matrix[0].length; col++){
                if (matrix[row][col] == 1){
                    int min = Integer.MAX_VALUE;

                    if (col - 1 >= 0) {
                        min = Math.min(matrix[row][col - 1], min);
                    } else {
                        min = 0;
                    }
                    
                    if (row - 1 >= 0) {
                        min = Math.min(matrix[row - 1][col], min);
                    } else {
                        min = 0;
                    }

                    if(row - 1 >= 0 && col - 1 >= 0) {
                        min = Math.min(min, matrix[row - 1][col - 1]);
                    } else {
                        min = 0;
                    }
                    matrix[row][col] = matrix[row][col] + min;
                    count = count + matrix[row][col];
                }
            }
        }

        return count;
    }
}
