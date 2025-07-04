// 189. Rotate Array
// Given an array, rotate the array to the right by k steps, where k is non-negative.
//
// Example 1:
//
// Input: [1,2,3,4,5,6,7] and k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]
// Example 2:
//
// Input: [-1,-100,3,99] and k = 2
// Output: [3,99,-1,-100]
// Explanation:
// rotate 1 steps to the right: [99,-1,-100,3]
// rotate 2 steps to the right: [3,99,-1,-100]
// Note:
//
// Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
// Could you do it in-place with O(1) extra space?

// Runtime: 56 ms, faster than 98.22% of JavaScript online submissions for Rotate Array.
// Memory Usage: 35.6 MB, less than 26.32% of JavaScript online submissions for Rotate Array.

/**
 * @param {number[]} nums
 * @param {number} k
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var rotate = function(nums, k) {
    var len = nums.length;
    k = k % len;
    var arr1 = nums.slice(len-k, len);
    var arr2 = nums.slice(0, len-k);
    for (var i = 0; i < arr1.length; i++) {
        nums[i] = arr1[i];
    }
    for (var j = 0; j < arr2.length; j++) {
        nums[i + j] = arr2[j];
    }
};