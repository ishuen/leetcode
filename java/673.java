// 673. Number of Longest Increasing Subsequence
// Given an integer array nums, return the number of longest increasing subsequences.
//
// Notice that the sequence has to be strictly increasing.
//
//
//
// Example 1:
//
// Input: nums = [1,3,5,4,7]
// Output: 2
// Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
// Example 2:
//
// Input: nums = [2,2,2,2,2]
// Output: 5
// Explanation: The length of longest continuous increasing subsequence is 1, and there are 5 subsequences' length is 1, so output 5.
//
//
//
// Constraints:
//
// 1 <= nums.length <= 2000
// -106 <= nums[i] <= 106
//
// Runtime: 18 ms, faster than 83.72% of Java online submissions for Number of Longest Increasing Subsequence.
// Memory Usage: 38.7 MB, less than 47.36% of Java online submissions for Number of Longest Increasing Subsequence.
class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] len = new int[nums.length];
        int[] count = new int[nums.length];
        int max = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            count[i] = 1;
            len[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) continue;
                if (len[j] + 1 == len[i]) count[i] += count[j];
                else if (len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    count[i] = count[j]; 
                }
            }
            if (len[i] > maxLen) {
                max = count[i];
                maxLen = len[i];
            } else if (len[i] == maxLen) {
                max += count[i];
            }
        }
        return max;
    }
}

