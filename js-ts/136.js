// 136. Single Number
//
// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//
// You must implement a solution with a linear runtime complexity and use only constant extra space.
//
//
//
// Example 1:
//
// Input: nums = [2,2,1]
// Output: 1
// Example 2:
//
// Input: nums = [4,1,2,1,2]
// Output: 4
// Example 3:
//
// Input: nums = [1]
// Output: 1
//
//
// Constraints:
//
// 1 <= nums.length <= 3 * 104
// -3 * 104 <= nums[i] <= 3 * 104
// Each element in the array appears twice except for one element which appears only once.
//
// Runtime 121 ms Beats 16.61% of users with JavaScript
// Memory 44.48 MB Beats 65.22% of users with JavaScript
/**
 * @param {number[]} nums
 * @return {number}
 */
var singleNumber = function(nums) {
    let ans = 0;
    for (let num of nums) {
        ans = ans ^ num;
    }    
    return ans;
};