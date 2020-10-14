// 598. Range Addition II
//   You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.
//
//   Count and return the number of maximum integers in the matrix after performing all the operations.
//   Example 1:
//   Input: m = 3, n = 3, ops = [[2,2],[3,3]]
//   Output: 4
//   Explanation: The maximum integer in M is 2, and there are four of it in M. So return 4.
//   Example 2:
//   Input: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
//   Output: 4
//   Example 3:
//   Input: m = 3, n = 3, ops = []
//   Output: 9
//   Constraints:
//   1 <= m, n <= 4 * 104
//   1 <= ops.length <= 104
//   ops[i].length == 2
//   1 <= ai <= m
//   1 <= bi <= n

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Range Addition II.
// Memory Usage: 39.2 MB, less than 13.35% of Java online submissions for Range Addition II.

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) return m * n;
        int minX = ops[0][0];
        int minY = ops[0][1];
        for (int i = 1; i < ops.length; i++) {
           if (ops[i][0] < minX) {
               minX = ops[i][0];
            }
            if (ops[i][1] < minY) {
                minY = ops[i][1];
            }
        }
        return minX * minY;
    }
}