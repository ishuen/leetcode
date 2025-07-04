// 34. Find First and Last Position of Element in Sorted Array
// Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
//
// If target is not found in the array, return [-1, -1].
//
// You must write an algorithm with O(log n) runtime complexity.
//
//
//
// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]
// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]
// Example 3:
// Input: nums = [], target = 0
// Output: [-1,-1]
//
//
// Constraints:
//
// 0 <= nums.length <= 10^5
// -109 <= nums[i] <= 10^9
// nums is a non-decreasing array.
// -109 <= target <= 10^9
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
// Memory Usage: 42.1 MB, less than 58.98% of Java online submissions for Find First and Last Position of Element in Sorted Array.
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int startIndex = 0;
        int endIndex = nums.length - 1;
        while (startIndex <= endIndex) {
            int middle = (startIndex + endIndex) / 2;
            if (nums[middle] < target) {
                startIndex = middle + 1;
            } else if (nums[middle] > target) {
                endIndex = middle - 1;
            } else {
                return findRange(middle, nums, target);
            }
        }
        return new int[] {-1, -1};
    }
    private int[] findRange(int middle, int[] nums, int target) {
        int startIndex = middle;
        int endIndex = middle;
        int last = nums.length - 1;
        boolean startFixed = startIndex == 0 ? true : false;
        boolean endFixed = endIndex == last ? true : false;
        while ((!startFixed || !endFixed) && startIndex >= 0 && endIndex <= last) {
            if (startIndex > 0 && nums[startIndex - 1] == target) {
                startIndex--;
            } else if (startIndex > 0 && nums[startIndex - 1] < target) {
                startFixed = true;
            } else if (startIndex == 0 && nums[startIndex] == target){
                startFixed = true;
            }
            if (endIndex < last && nums[endIndex + 1] == target) {
                endIndex++;
            } else if (endIndex < last && nums[endIndex + 1] > target) {
                endFixed = true;
            } else if (endIndex == last && nums[endIndex] == target) {
                endFixed = true;
            }
        }
        return new int[] {startIndex, endIndex};
    }
}

