// 930. Binary Subarrays With Sum
//
// Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
//
// A subarray is a contiguous part of the array.
//
//
//
// Example 1:
//
// Input: nums = [1,0,1,0,1], goal = 2
// Output: 4
// Explanation: The 4 subarrays are bolded and underlined below:
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]
// [1,0,1,0,1]
// Example 2:
//
// Input: nums = [0,0,0,0,0], goal = 0
// Output: 15
//
//
// Constraints:
//
// 1 <= nums.length <= 3 * 104
// nums[i] is either 0 or 1.
// 0 <= goal <= nums.length
//
// Runtime 2 ms Beats 89.69%
// Memory 47.8 MB Beats 27.12%
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int[] counts = new int[nums.length + 1];
        int ans = 0;
        int sum = 0;
        counts[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum >= goal) {
                ans = ans + counts[sum - goal];
            }
            counts[sum]++;
        }
        return ans;
    }
}