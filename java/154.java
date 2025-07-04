// 154. Find Minimum in Rotated Sorted Array II
// Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,4,4,5,6,7] might become:
//
// [4,5,6,7,0,1,4] if it was rotated 4 times.
// [0,1,4,4,5,6,7] if it was rotated 7 times.
// Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
//
// Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
//
// You must decrease the overall operation steps as much as possible.
//
//
//
// Example 1:
//
// Input: nums = [1,3,5]
// Output: 1
// Example 2:
//
// Input: nums = [2,2,2,0,1]
// Output: 0
//
//
// Constraints:
//
// n == nums.length
// 1 <= n <= 5000
// -5000 <= nums[i] <= 5000
// nums is sorted and rotated between 1 and n times.
//
//
// Follow up: This problem is similar to Find Minimum in Rotated Sorted Array, but nums may contain duplicates. Would this affect the runtime complexity? How and why?
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Minimum in Rotated Sorted Array II.
// Memory Usage: 38.7 MB, less than 70.86% of Java online submissions for Find Minimum in Rotated Sorted Array II.
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int midIndex = (left + right) / 2;
        int mid = nums[midIndex];
        if (left == right) return nums[0];
        if (left + 1 == right) return Math.min(nums[0], nums[1]);
        while (left < right) {
            midIndex = (left + right) / 2;
            mid = nums[midIndex];
            int l = nums[left];
            int r = nums[right];
            if (mid < r) right = midIndex;
            else if (mid > r) left = midIndex + 1;
            else right--;
        }
        return nums[left];
    }
}