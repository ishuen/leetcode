// 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold
//
// Given a m x n matrix mat and an integer threshold, return the maximum side-length of a square with a sum less than or equal to threshold or return 0 if there is no such square.
//
//
//
// Example 1:
//
//
// Input: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
// Output: 2
// Explanation: The maximum side length of square with sum less than 4 is 2 as shown.
// Example 2:
//
// Input: mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
// Output: 0
//
//
// Constraints:
//
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 300
// 0 <= mat[i][j] <= 104
// 0 <= threshold <= 105
//
// Runtime 97ms Beats 14.65%of users with Java
// Memory 56.57MB Beats 10.34%of users with Java
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int[][] dp = new int[mat.length + 1][mat[0].length + 1];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                dp[i + 1][j + 1] = mat[i][j] + dp[i + 1][j];
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                dp[i + 1][j + 1] += dp[i][j + 1];
            }
        }
        

        int maxSide = Math.min(mat.length, mat[0].length);
        for (int k = maxSide; k > 0; k--) {
            for (int i = 1; i <= dp.length - k; i++) {
                for (int j = 1; j <= dp[0].length - k; j++) {
                    if (findSum(dp, i, j, k) <= threshold) {
                        return k;
                    }
                }
            }
        }
        return 0;
    }

    private int findSum(int[][] dp, int i, int j, int maxSide) {
        return dp[i + maxSide - 1][j + maxSide - 1] + dp[i - 1][j - 1]
         - dp[i - 1][j + maxSide - 1] - dp[i + maxSide - 1][j - 1]; 
    }

}
// return max length of the square where the sum of each element inside is less than or equal to threshold


// Runtime 18ms Beats 26.72%of users with Java
// Memory 55.89MB Beats 61.21%of users with Java
class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int[][] dp = new int[mat.length + 1][mat[0].length + 1];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                dp[i + 1][j + 1] = mat[i][j] + dp[i + 1][j];
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                dp[i + 1][j + 1] += dp[i][j + 1];
            }
        }
        
        int max = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int low = max;
                int high = Math.min(mat.length, mat[0].length);
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (findSum(dp, i, j, mid) <= threshold) {
                        low = mid + 1;
                        max = Math.max(max, mid);
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return max;
    }


    private int findSum(int[][] dp, int i, int j, int maxSide) {
        int r = i + maxSide - 1;
        int c = j + maxSide - 1;
        if (r >= dp.length || c >= dp[0].length) return Integer.MAX_VALUE;
        return dp[r][c] + dp[i - 1][j - 1]
         - dp[i - 1][c] - dp[r][j - 1]; 
    }

}