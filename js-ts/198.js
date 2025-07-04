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
// Runtime 40 ms Beats 97.13% of users with JavaScript
// Memory 42.06 MB Beats 30.50% of users with JavaScript
/**
 * @param {number[]} nums
 * @return {number}
 */
var rob = function(nums) {
    let memory = new Array(nums.length);
    memory.fill(-1);
    return robHouse(nums, 0, memory);
};

var robHouse = function(nums, index, memory) {
    if (index >= nums.length) return 0;
    if (memory[index] != -1) {
        return memory[index];
    }
    memory[index] = Math.max(nums[index] + robHouse(nums, index + 2, memory), robHouse(nums, index + 1, memory));
    return memory[index];
}