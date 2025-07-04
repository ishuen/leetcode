// 1685. Sum of Absolute Differences in a Sorted Array
//
// You are given an integer array nums sorted in non-decreasing order.
//
// Build and return an integer array result with the same length as nums such that result[i] is equal to the summation of absolute differences between nums[i] and all the other elements in the array.
//
// In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j < nums.length and j != i (0-indexed).
//
//
//
// Example 1:
//
// Input: nums = [2,3,5]
// Output: [4,3,5]
// Explanation: Assuming the arrays are 0-indexed, then
// result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4,
// result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3,
// result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5.
// Example 2:
//
// Input: nums = [1,4,6,8,10]
// Output: [24,15,13,15,21]
//
//
// Constraints:
//
// 2 <= nums.length <= 105
// 1 <= nums[i] <= nums[i + 1] <= 104
//
// Runtime 3 ms Beats 99.36% of users with Java
// Memory 60.12 MB Beats 5.77% of users with Java
class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int len = nums.length;
        int[] results = new int[len];
        int[] prefixSum = new int[len];
        int[] sufixSum = new int[len];
        for (int i = 1; i < len; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        for (int i = len - 1; i > 0; i--) {
            sufixSum[i - 1] = sufixSum[i] + nums[i];
        }
        for (int i = 0; i < len; i++) {
            results[i] = nums[i] * (2 * i + 1 - len) - prefixSum[i] + sufixSum[i];
        }
        return results;
    }
}

/*

left: cur - left
right: right - cur

prefix Sum
sufix Sum

left: i
right: len - i - 1
cur * (-(len - i - 1) + i) - prefixSum + sufixSum
*/