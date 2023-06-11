// 962. Maximum Width Ramp
//
// A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.
//
// Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.
//
//
//
// Example 1:
//
// Input: nums = [6,0,8,2,1,5]
// Output: 4
// Explanation: The maximum width ramp is achieved at (i, j) = (1, 5): nums[1] = 0 and nums[5] = 5.
// Example 2:
//
// Input: nums = [9,8,1,0,1,9,4,0,4,1]
// Output: 7
// Explanation: The maximum width ramp is achieved at (i, j) = (2, 9): nums[2] = 1 and nums[9] = 1.
//
//
// Constraints:
//
// 2 <= nums.length <= 5 * 104
// 0 <= nums[i] <= 5 * 104
//
// Runtime 1211 ms Beats 9.9%
// Memory 52.9 MB Beats 5.55%
class Solution {
    public int maxWidthRamp(int[] nums) {
        int min = nums[0];
        int maxRamp = 0;
        int lastRight = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min) continue;
            int curRamp = 0;
            for (int j = Math.max(i + 1, lastRight); j < nums.length; j++) {
                if (nums[i] <= nums[j]) {
                    curRamp = j - i;
                    lastRight = j;
                    maxRamp = Math.max(maxRamp, curRamp);
                    if (j == nums.length - 1) return maxRamp;
                }
            }
        }
        return maxRamp;
    }
}

// Runtime 17 ms Beats 70.71%
// Memory 52 MB Beats 10.61%
class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int last = nums[0];
        stack.push(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < last) {
                stack.push(i);
                last = nums[i];
            }
        }
        int maxRamp = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]) {
                maxRamp = Math.max(maxRamp, i - stack.pop());
                
            }
        }
        return maxRamp;
    }
}
