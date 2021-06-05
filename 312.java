// 312. Burst Balloons
// You are given n balloons, indexed from 0 to n - 1. Each balloon is painted with a number on it represented by an array nums. You are asked to burst all the balloons.
//
// If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i + 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as if there is a balloon with a 1 painted on it.
//
// Return the maximum coins you can collect by bursting the balloons wisely.

// Example 1:
//
// Input: nums = [3,1,5,8]
// Output: 167
// Explanation:
// nums = [3,1,5,8] --> [3,5,8] --> [3,8] --> [8] --> []
// coins =  3*1*5    +   3*5*8   +  1*3*8  + 1*8*1 = 167
// Example 2:
//
// Input: nums = [1,5]
// Output: 10
//
//
// Constraints:
//
// n == nums.length
// 1 <= n <= 500
// 0 <= nums[i] <= 100
//
// Runtime: 167 ms, faster than 25.92% of Java online submissions for Burst Balloons.
// Memory Usage: 38.4 MB, less than 69.81% of Java online submissions for Burst Balloons.
class Solution {
    public int maxCoins(int[] nums) {
        int[] extendedNums = new int[nums.length + 2];
        for (int i = 0; i < nums.length; i++) {
            extendedNums[i + 1] = nums[i];
        }
        int n = nums.length + 1;
        extendedNums[0] = 1;
        extendedNums[n] = 1;
        n++;

        int[][] memo = new int[n][n];
        return burst(memo, extendedNums, 0, n - 1);
    }

    public int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; i++)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right] 
                + burst(memo, nums, left, i) + burst(memo, nums, i, right));
            memo[left][right] = ans;
        return ans;
    }
}
