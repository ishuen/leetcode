// 35. Search Insert Position
// Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//
// You may assume no duplicates in the array.
//
// Example 1:
// Input: [1,3,5,6], 5
// Output: 2
// Example 2:
// Input: [1,3,5,6], 2
// Output: 1
// Example 3:
// Input: [1,3,5,6], 7
// Output: 4
// Example 4:
// Input: [1,3,5,6], 0
// Output: 0

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
// Memory Usage: 39.6 MB, less than 6.74% of Java online submissions for Search Insert Position.
class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length; 
        for (int i = 0; i < len; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return len;
    }
}