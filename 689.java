// 689. Maximum Sum of 3 Non-Overlapping Subarrays
// Given an integer array nums and an integer k, find three non-overlapping subarrays of length k with maximum sum and return them.
//
// Return the result as a list of indices representing the starting position of each interval (0-indexed). If there are multiple answers, return the lexicographically smallest one.
//
//
//
// Example 1:
//
// Input: nums = [1,2,1,2,6,7,5,1], k = 2
// Output: [0,3,5]
// Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting indices [0, 3, 5].
// We could have also taken [2, 1], but an answer of [1, 3, 5] would be lexicographically larger.
// Example 2:
//
// Input: nums = [1,2,1,2,1,2,1,2,1], k = 2
// Output: [0,2,4]
//
//
// Constraints:
//
// 1 <= nums.length <= 2 * 104
// 1 <= nums[i] < 216
// 1 <= k <= floor(nums.length / 3)
//
// Runtime: 2 ms, faster than 100.00% of Java online submissions for Maximum Sum of 3 Non-Overlapping Subarrays.
// Memory Usage: 42.1 MB, less than 49.32% of Java online submissions for Maximum Sum of 3 Non-Overlapping Subarrays.
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] sum = new int[len + 1];
        for (int i = 1; i <= len; i++) sum[i] = sum[i - 1] + nums[i - 1];
        int max = 0;
        for (int i = 0; i <= len - k; i++) {
            if (sum[i + k] - sum[i] > max) {
                max = sum[i + k] - sum[i];
                left[i] = i;
            } else {
                left[i] = left[i - 1];
            }
        }
        max = 0;
        for (int i = len - k; i >= 0; i--) {
            if (sum[i + k] - sum[i] >= max) {
                max = sum[i + k] - sum[i];
                right[i] = i;
            } else {
                right[i] = right[i + 1];
            }
        }
        max = 0;
        int[] ans = new int[3];
        for (int i = k; i <= len - 2 * k; i++) {
            int total = sum[left[i - k] + k] - sum[left[i - k]] + sum[i + k] - sum[i] + sum[right[i + k] + k] - sum[right[i + k]];
            if (total > max) {
                max = total;
                ans[0] = left[i - k];
                ans[1] = i;
                ans[2] = right[i + k];
            }
        }
        return ans;
    }
}


// left: max interval from index 0 to i - 1  ** i - 1 >= k
// mid: from i to i + k
// right: from i + k + 1 .. length - 1