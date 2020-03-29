// 496. Next Greater Element I
// You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
//
// The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
//
// Example 1:
//
// Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
// Output: [-1,3,-1]
// Explanation:
//     For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
//     For number 1 in the first array, the next greater number for it in the second array is 3.
//     For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
// Example 2:
//
// Input: nums1 = [2,4], nums2 = [1,2,3,4].
// Output: [3,-1]
// Explanation:
//     For number 2 in the first array, the next greater number for it in the second array is 3.
//     For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
// Note:
//
// All elements in nums1 and nums2 are unique.
// The length of both nums1 and nums2 would not exceed 1000.


/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */

// Runtime: 76 ms, faster than 10.95% of JavaScript online submissions for Next Greater Element I.
// Memory Usage: 34.8 MB, less than 100.00% of JavaScript online submissions for Next Greater Element I.

var nextGreaterElement = function(nums1, nums2) {
    var ans = [];
    var len = nums1.length;
    var len2 = nums2.length;
    for (var i = 0; i < len; i++) {
        var index = nums2.findIndex(num => num == nums1[i]);
        var found = false;
        for (var j = index + 1; j < len2; j++) {
            if (nums2[j] > nums1[i]) {
                ans.push(nums2[j]);
                found = true;
                break;
            }
        }
        if (found == false) {
            ans.push(-1);
        }
    }
    return ans;
};


// Runtime: 80 ms, faster than 8.57% of JavaScript online submissions for Next Greater Element I.
// Memory Usage: 35.1 MB, less than 100.00% of JavaScript online submissions for Next Greater Element I.
var nextGreaterElement = function(nums1, nums2) {
    var len = nums1.length;
    var ans = new Array(len);
    var len2 = nums2.length;
    for (var i = 0; i < len; i++) {
        var index = nums2.findIndex(num => num == nums1[i]);
        var found = false;
        for (var j = index + 1; j < len2; j++) {
            if (nums2[j] > nums1[i]) {
                ans[i] = nums2[j];
                found = true;
                break;
            }
        }
        if (found == false) {
            ans[i] = -1;
        }
    }
    return ans;
};


// Runtime: 56 ms, faster than 90.24% of JavaScript online submissions for Next Greater Element I.
// Memory Usage: 35.1 MB, less than 100.00% of JavaScript online submissions for Next Greater Element I.
var nextGreaterElement = function(nums1, nums2) {
    var len = nums1.length;
    var ans = [];
    var len2 = nums2.length;
    var found = false;
    for (var i = 0; i < len; i++) {
        var index = nums2.indexOf(nums1[i]);
        found = false;
        for (var j = index + 1; j < len2; j++) {
            if (nums2[j] > nums1[i]) {
                ans.push(nums2[j]);
                found = true;
                break;
            }
        }
        if (found == false) {
            ans.push(-1);
        }
    }
    return ans;
};