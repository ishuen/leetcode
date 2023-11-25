// 1072. Flip Columns For Maximum Number of Equal Rows
//
// You are given an m x n binary matrix matrix.
//
// You can choose any number of columns in the matrix and flip every cell in that column (i.e., Change the value of the cell from 0 to 1 or vice versa).
//
// Return the maximum number of rows that have all values equal after some number of flips.
//
//
//
// Example 1:
//
// Input: matrix = [[0,1],[1,1]]
// Output: 1
// Explanation: After flipping no values, 1 row has all values equal.
// Example 2:
//
// Input: matrix = [[0,1],[1,0]]
// Output: 2
// Explanation: After flipping values in the first column, both rows have equal values.
// Example 3:
//
// Input: matrix = [[0,0,0],[0,0,1],[1,1,0]]
// Output: 2
// Explanation: After flipping values in the first two columns, the last two rows have equal values.
//
//
// Constraints:
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 300
// matrix[i][j] is either 0 or 1.
//
// Runtime 24 ms Beats 76.60% of users with Java
// Memory 58.50 MB Beats 23.40% of users with Java
class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int maxCount = 0;
        Map<String, Integer> patterns = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder sb = new StringBuilder();
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[0].length; j++) {
                    sb.append(matrix[i][j]);
                }
            } else {
                 for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) sb.append(1);
                    else sb.append(0);
                }
            }
            String key = sb.toString();
            int count = patterns.getOrDefault(key, 0) + 1;
            patterns.put(key, count);
            maxCount = Math.max(count, maxCount);
        }
        return maxCount;
    }

}
/*
target: count 00000 or 11111
choose 0000 as target
make the rows with prefix 1 to be prefix 0
-> count the number of same rows
*/