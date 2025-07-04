// 169. Majority Element
// Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
//
// You may assume that the array is non-empty and the majority element always exist in the array.
//
// Example 1:
//
// Input: [3,2,3]
// Output: 3
// Example 2:
//
// Input: [2,2,1,1,1,2,2]
// Output: 2

/**
 * @param {number[]} nums
 * @return {number}
 */
// 68 ms, faster than 47.82%
var majorityElement = function(nums) {
  var obj = {};
  var maxNum = nums[0];
  var count = 1;
  for (var n of nums) {
    if (obj[n] == undefined) {
      obj[n]++;
      if (obj[n] > count) {
        maxNum = n;
        count = obj[n];
      }
    } else {
      obj[n] = 1;
    }
  }
  return maxNum;
};