// 813. Largest Sum of Averages
// You are given an integer array nums and an integer k. You can partition the array into at most k non-empty adjacent subarrays. The score of a partition is the sum of the averages of each subarray.
//
// Note that the partition must use every integer in nums, and that the score is not necessarily an integer.
//
// Return the maximum score you can achieve of all the possible partitions. Answers within 10-6 of the actual answer will be accepted.
//
//
//
// Example 1:
//
// Input: nums = [9,1,2,3,9], k = 3
// Output: 20.00000
// Explanation:
// The best choice is to partition nums into [9], [1, 2, 3], [9]. The answer is 9 + (1 + 2 + 3) / 3 + 9 = 20.
// We could have also partitioned nums into [9, 1], [2], [3, 9], for example.
// That partition would lead to a score of 5 + 2 + 6 = 13, which is worse.
// Example 2:
//
// Input: nums = [1,2,3,4,5,6,7], k = 4
// Output: 20.50000
//
//
// Constraints:
//
// 1 <= nums.length <= 100
// 1 <= nums[i] <= 104
// 1 <= k <= nums.length
//
// Runtime: 2 ms, faster than 100.00% of Java online submissions for Largest Sum of Averages.
// Memory Usage: 36.8 MB, less than 87.57% of Java online submissions for Largest Sum of Averages.
class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        double[][] memo = new double[nums.length][k];
        return trial(1, 0, prefixSum, nums.length, k, memo);
    }
    private double trial(int curSub, int startIndex, int[] prefixSum, int len, int k, double[][] memo) {
        if (memo[startIndex][curSub - 1] != 0) return memo[startIndex][curSub - 1];
        if (curSub == k) {
            return memo[startIndex][k - 1] = (double) (prefixSum[len] - prefixSum[startIndex]) / (len - startIndex);
        }
        double max = 0;
        for (int i = startIndex + 1; i <= len - (k - curSub); i++) {
            double average = (double)(prefixSum[i] - prefixSum[startIndex]) / (i - startIndex);
            max = Math.max(max, average + trial(curSub + 1, i, prefixSum, len, k, memo));
        }
        return memo[startIndex][curSub - 1] = max;
    }
}