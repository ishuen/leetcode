// 363. Max Sum of Rectangle No Larger Than K
// Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.
//
// It is guaranteed that there will be a rectangle with a sum no larger than k.
//
//
//
// Example 1:
//
//
// Input: matrix = [[1,0,1],[0,-2,3]], k = 2
// Output: 2
// Explanation: Because the sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no larger than k (k = 2).
// Example 2:
//
// Input: matrix = [[2,2,-1]], k = 3
// Output: 3
//
//
// Constraints:
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -100 <= matrix[i][j] <= 100
// -105 <= k <= 105
//
// Runtime: 450 ms, faster than 12.67% of Java online submissions for Max Sum of Rectangle No Larger Than K.
// Memory Usage: 39.1 MB, less than 67.08% of Java online submissions for Max Sum of Rectangle No Larger Than K.
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int[][] prefixSum = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                prefixSum[i][j + 1] = prefixSum[i][j] + matrix[i][j];
            }
        }
        int max = Integer.MIN_VALUE;
        TreeSet<Integer> prefix = new TreeSet<>();
        for (int i = 0; i <= matrix[0].length; i++) {
            for (int j = i + 1; j <= matrix[0].length; j++) {
                prefix.add(0);
                int sum = 0;
                for (int m = 0; m < matrix.length; m++) {
                    sum = sum + prefixSum[m][j] - prefixSum[m][i];
                    if (prefix.ceiling(sum - k) != null) {
                        int key = prefix.ceiling(sum - k);
                        max = Math.max(max, sum - key);
                    }
                    prefix.add(sum);
                }
                prefix.clear();
            }
        }
        return max;
    }
}

