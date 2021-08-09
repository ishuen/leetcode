// 45. Jump Game II
// Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
//
// Each element in the array represents your maximum jump length at that position.
//
// Your goal is to reach the last index in the minimum number of jumps.
//
// You can assume that you can always reach the last index.
//
//
//
// Example 1:
//
// Input: nums = [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
// Example 2:
//
// Input: nums = [2,3,0,1,4]
// Output: 2
//
//
// Constraints:
//
// 1 <= nums.length <= 104
// 0 <= nums[i] <= 1000
//
// Runtime: 57 ms, faster than 23.60% of Java online submissions for Jump Game II.
// Memory Usage: 39.7 MB, less than 51.41% of Java online submissions for Jump Game II.
class Solution {
    public int jump(int[] nums) {
        int[] jumps = new int[nums.length];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < nums.length && jumps[i + j] != Integer.MAX_VALUE)
                jumps[i] = Math.min(jumps[i], 1 + jumps[i + j]);
            }
        }
        return jumps[0];
    }
}

// Runtime: 1 ms, faster than 99.34% of Java online submissions for Jump Game II.
// Memory Usage: 40 MB, less than 34.54% of Java online submissions for Jump Game II.
class Solution {
    public int jump(int[] nums) {
        int i = 0;
        int lastJump = 0;
        int maxReachable = 0;
        int jump = 0;
        while (lastJump < nums.length - 1) {
            maxReachable = Math.max(maxReachable, i + nums[i]);
            if (i == lastJump) {
                lastJump = maxReachable;
                jump++;
            }
            i++;
        }
        return jump;
    }
}