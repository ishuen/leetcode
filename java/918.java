// 918. Maximum Sum Circular Subarray
//
// Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
//
// A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
//
// A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.
//
//
//
// Example 1:
//
// Input: nums = [1,-2,3,-2]
// Output: 3
// Explanation: Subarray [3] has maximum sum 3.
// Example 2:
//
// Input: nums = [5,-3,5]
// Output: 10
// Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.
// Example 3:
//
// Input: nums = [-3,-2,-3]
// Output: -2
// Explanation: Subarray [-2] has maximum sum -2.
//
//
// Constraints:
//
// n == nums.length
// 1 <= n <= 3 * 104
// -3 * 104 <= nums[i] <= 3 * 104
//
// Runtime 2 ms Beats 100%
// Memory 49.6 MB Beats 24.51%
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxNonCircular = maxSubArray(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            nums[i] = -1 * nums[i];
        }
        int maxCircular = sum + maxSubArray(nums);
        return maxCircular == 0 ? maxNonCircular : Math.max(maxCircular, maxNonCircular);
    }

    // Kadane's algorithm
    private int maxSubArray(int[] nums) {
        int localMax = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(localMax + nums[i], nums[i]);
            max = Math.max(max, localMax);
        }
        return max;
    }
}