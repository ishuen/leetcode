// 53. Maximum Subarray
//
//   Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//
//
//   Example 1:
//
//   Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//   Output: 6
//   Explanation: [4,-1,2,1] has the largest sum = 6.
//   Example 2:
//
//   Input: nums = [1]
//   Output: 1
//   Example 3:
//
//   Input: nums = [5,4,-1,7,8]
//   Output: 23
//
//
//   Constraints:
//
//   1 <= nums.length <= 3 * 104
//   -105 <= nums[i] <= 105
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Subarray.
// Memory Usage: 39.1 MB, less than 18.47% of Java online submissions for Maximum Subarray.
class Solution {
    public int maxSubArray(int[] nums) {
      int max = nums[0];
      for (int i = 1; i < nums.length; i++) {
        nums[i] = Math.max(nums[i - 1] + nums[i], nums[i]);
        if (nums[i] > max) {
          max = nums[i];
        }
      }
      return max;
    }
}