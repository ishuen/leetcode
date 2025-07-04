// 283. Move Zeroes
//
// Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
// Note that you must do this in-place without making a copy of the array.
//
//
//
// Example 1:
//
// Input: nums = [0,1,0,3,12]
// Output: [1,3,12,0,0]
// Example 2:
//
// Input: nums = [0]
// Output: [0]
//
//
// Constraints:
//
// 1 <= nums.length <= 104
// -231 <= nums[i] <= 231 - 1
//
//
// Follow up: Could you minimize the total number of operations done?
//
// Runtime 64 ms Beats 96.02% of users with JavaScript
// Memory 46.58 MB Beats 57.51% of users with JavaScript
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var moveZeroes = function(nums) {
    let pointer2 = 0;
    for (let pointer1 = 0; pointer1 < nums.length; pointer1++) {
        if (nums[pointer1] != 0) {
            nums[pointer2] = nums[pointer1];
            pointer2++;
        }
    }
    while (pointer2 < nums.length) {
        nums[pointer2] = 0;
        pointer2++;
    }
};