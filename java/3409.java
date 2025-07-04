// 3409. Longest Subsequence With Decreasing Adjacent Difference
//
// You are given an array of integers nums.
//
// Your task is to find the length of the longest subsequence seq of nums, such that the absolute differences between consecutive elements form a non-increasing sequence of integers. In other words, for a subsequence seq0, seq1, seq2, ..., seqm of nums, |seq1 - seq0| >= |seq2 - seq1| >= ... >= |seqm - seqm - 1|.
//
// Return the length of such a subsequence.
//
//
//
// Example 1:
//
// Input: nums = [16,6,3]
//
// Output: 3
//
// Explanation:
//
// The longest subsequence is [16, 6, 3] with the absolute adjacent differences [10, 3].
//
// Example 2:
//
// Input: nums = [6,5,3,4,2,1]
//
// Output: 4
//
// Explanation:
//
// The longest subsequence is [6, 4, 2, 1] with the absolute adjacent differences [2, 2, 1].
//
// Example 3:
//
// Input: nums = [10,20,10,19,10,20]
//
// Output: 5
//
// Explanation:
//
// The longest subsequence is [10, 20, 10, 19, 10] with the absolute adjacent differences [10, 10, 9, 9].
//
//
//
// Constraints:
//
// 2 <= nums.length <= 104
// 1 <= nums[i] <= 300
//
// Runtime 1914 ms Beats 10.87%
// Memory 79.20 MB Beats 12.61%
class Solution {
    public int longestSubsequence(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int maxDiff = max - min;
        int maxCount = 1;
        int[][] indexWithDiff = new int[nums.length][maxDiff + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(indexWithDiff[i], 1);
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = maxDiff - 1; j >= 0; j--) {
                indexWithDiff[i - 1][j] = Math.max(indexWithDiff[i - 1][j], indexWithDiff[i - 1][j + 1]);
            }
            for (int j = 0; j < i; j++) {
                int diff = Math.abs(nums[i] - nums[j]);
                indexWithDiff[i][diff] = Math.max(indexWithDiff[i][diff], indexWithDiff[j][diff] + 1);
                maxCount = Math.max(indexWithDiff[i][diff], maxCount);
            }
        }
        return maxCount;
    }
}
