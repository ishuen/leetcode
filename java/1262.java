// 1262. Greatest Sum Divisible by Three
//
// Given an integer array nums, return the maximum possible sum of elements of the array such that it is divisible by three.
//
//
//
// Example 1:
//
// Input: nums = [3,6,5,1,8]
// Output: 18
// Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).
// Example 2:
//
// Input: nums = [4]
// Output: 0
// Explanation: Since 4 is not divisible by 3, do not pick any number.
// Example 3:
//
// Input: nums = [1,2,3,4,4]
// Output: 12
// Explanation: Pick numbers 1, 3, 4 and 4 their sum is 12 (maximum sum divisible by 3).
//
//
// Constraints:
//
// 1 <= nums.length <= 4 * 104
// 1 <= nums[i] <= 104
//
// Runtime 5ms Beats 92.02%of users with Java
// Memory 48.86MB Beats 21.85%of users with Java
class Solution {
    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[3][nums.length + 1];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 3; j++) {
                int newRemainder = (j + nums[i]) % 3;
                dp[newRemainder][i + 1] = Math.max(dp[newRemainder][i], dp[j][i] + nums[i]);
            }
        }
        return dp[0][nums.length];
    }

}