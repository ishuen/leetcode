// 198. House Robber
//
// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
//
// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
//
//
//
// Example 1:
//
// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.
// Example 2:
//
// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.
//
//
// Constraints:
//
// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400
//
//
// Runtime 0 ms Beats 100.00% of users with Java
// Memory 39.52 MB Beats 84.67% of users with Java
class Solution {
    private int[] memory;
    public int rob(int[] nums) {
        memory = new int[nums.length];
        Arrays.fill(memory, -1);
        return rob(0, nums);
    }

    private int rob(int index, int[] nums) {
        if (index >= nums.length) return 0;
        if (index == nums.length - 1) return nums[index];
        if (memory[index] != -1) {
            return memory[index];
        }
        memory[index] = Math.max(nums[index] + rob(index + 2, nums), rob(index + 1, nums));
        return memory[index];
    }
}