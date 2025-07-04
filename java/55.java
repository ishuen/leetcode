// 55. Jump Game
// Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
//
// Each element in the array represents your maximum jump length at that position.
//
// Determine if you are able to reach the last index.
//
//
//
// Example 1:
//
// Input: nums = [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// Example 2:
//
// Input: nums = [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
//
//
// Constraints:
//
// 1 <= nums.length <= 3 * 10^4
// 0 <= nums[i] <= 10^5

// Runtime: 322 ms, faster than 23.25% of Java online submissions for Jump Game.
// Memory Usage: 40.9 MB, less than 48.36% of Java online submissions for Jump Game.
class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        int cur = 0;
        while (cur <= max && cur < nums.length - 1) {
            for (int i = cur; i <= cur + nums[cur]; i++) {
                if (i < nums.length && max < i + nums[i]) {
                    max = i + nums[i];
                }
            }
            cur++;
        }
        return max >= nums.length - 1;
    }
}



// Runtime: 224 ms, faster than 33.80% of Java online submissions for Jump Game.
// Memory Usage: 40.9 MB, less than 48.36% of Java online submissions for Jump Game.
class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        int cur = 0;
        int lastIndex = nums.length - 1;
        while (cur <= max && cur < lastIndex) {
            int lastCheck = cur + nums[cur];
            for (int i = cur; i <= lastCheck; i++) {
                if (i < nums.length) {
                    max = Math.max(max, (i + nums[i]));
                }
            }
            cur++;
        }
        return max >= nums.length - 1;
    }
}

// Runtime: 1 ms, faster than 84.00% of Java online submissions for Jump Game.
// Memory Usage: 40.9 MB, less than 48.36% of Java online submissions for Jump Game.
class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) return false;
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}