// 1074. Number of Submatrices That Sum to Target
// Given a matrix and a target, return the number of non-empty submatrices that sum to target.
//
// A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.
//
// Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.
//
//
//
// Example 1:
//
//
// Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
// Output: 4
// Explanation: The four 1x1 submatrices that only contain 0.
// Example 2:
//
// Input: matrix = [[1,-1],[-1,1]], target = 0
// Output: 5
// Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
// Example 3:
//
// Input: matrix = [[904]], target = 0
// Output: 0
//
//
// Constraints:
//
// 1 <= matrix.length <= 100
// 1 <= matrix[0].length <= 100
// -1000 <= matrix[i] <= 1000
// -10^8 <= target <= 10^8
//
// Runtime: 88 ms, faster than 95.94% of Java online submissions for Number of Submatrices That Sum to Target.
// Memory Usage: 40.2 MB, less than 31.03% of Java online submissions for Number of Submatrices That Sum to Target.
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int[][] prefixSum = new int[matrix.length][matrix[0].length + 1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++)
                prefixSum[i][j] = prefixSum[i][j - 1] + matrix[i][j - 1];
        }
        int count = 0;
        Map<Integer, Integer> prefix = new HashMap<>();
        for (int k = 0; k < prefixSum[0].length; k++)
        for (int i = k + 1; i < prefixSum[0].length; i++) { // col
            prefix.put(0, 1);
            int sum = 0;
            for (int j = 0; j < prefixSum.length; j++) { // row
                sum = sum + prefixSum[j][i] - prefixSum[j][k];
                if (prefix.containsKey(sum - target)) {
                    count = count + prefix.get(sum - target);
                }
                prefix.put(sum, prefix.getOrDefault(sum, 0) + 1);
            }
            prefix.clear();
        }
        return count;
    }
}

// prefix sum (0 - last) - prefix sum (0 - i) = sum (i - last) = target
// prefix sum (0 - last) - target = prefix sum (0 - i)

// 1 row:
// prefix sum, if map(prefix sum - key) exist, count + value
// map(prefix sum, +1)

// if 1st element = target
//    1st + next row 1st element = target?

// 1st + 2nd = target
//    + next row = target?