// 1314. Matrix Block Sum
//
// Given a m x n matrix mat and an integer k, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for:
//
// i - k <= r <= i + k,
// j - k <= c <= j + k, and
// (r, c) is a valid position in the matrix.
//
//
// Example 1:
//
// Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 1
// Output: [[12,21,16],[27,45,33],[24,39,28]]
// Example 2:
//
// Input: mat = [[1,2,3],[4,5,6],[7,8,9]], k = 2
// Output: [[45,45,45],[45,45,45],[45,45,45]]
//
//
// Constraints:
//
// m == mat.length
// n == mat[i].length
// 1 <= m, n, k <= 100
// 1 <= mat[i][j] <= 100
//
// Runtime 53 ms Beats 46.23% of users with Java
// Memory 44.20 MB Beats 90.65% of users with Java
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int[][] output = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                output[i][j] = getSum(i, j, k, mat);
            }
        }
        return output;
    }

    private int getSum(int i, int j, int k, int[][] mat) {
        int rowMin = Math.max(0, i - k);
        int rowMax = Math.min(i + k, mat.length - 1);
        int colMin = Math.max(0, j - k);
        int colMax = Math.min(j + k, mat[0].length - 1);
        int sum = 0;
        for (int s = rowMin; s <= rowMax; s++) {
            for (int t = colMin; t <= colMax; t++) {
                sum = sum + mat[s][t];
            }
        }
        return sum;
    }
}

// Runtime 3 ms Beats 99.22% of users with Java
// Memory 45.00 MB Beats 8.85% of users with Java
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[0].length; j++) {
                sum = sum + mat[i][j];
                mat[i][j] = sum;
            }
        }
        for (int i = 0; i < mat[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < mat.length; j++) {
                sum = sum + mat[j][i];
                mat[j][i] = sum;
            }
        }
        int[][] output = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                output[i][j] = getSum(i, j, k, mat);
            }
        }
        return output;
    }

    private int getSum(int i, int j, int k, int[][] mat) {
        int rowMin = Math.max(0, i - k);
        int rowMax = Math.min(i + k, mat.length - 1);
        int colMin = Math.max(0, j - k);
        int colMax = Math.min(j + k, mat[0].length - 1);
        int sum = mat[rowMax][colMax];
        if (rowMin > 0) {
            sum = sum - mat[rowMin - 1][colMax];
        }
        if (colMin > 0) {
            sum = sum - mat[rowMax][colMin - 1];
        }
        if (rowMin > 0 && colMin > 0) {
            sum = sum + mat[rowMin - 1][colMin - 1];
        }    
        return sum;
    }
}