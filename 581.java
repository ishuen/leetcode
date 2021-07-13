// 581. Shortest Unsorted Continuous Subarray
// Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.
//
// Return the shortest such subarray and output its length.
//
//
//
// Example 1:
//
// Input: nums = [2,6,4,8,10,9,15]
// Output: 5
// Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
// Example 2:
//
// Input: nums = [1,2,3,4]
// Output: 0
// Example 3:
//
// Input: nums = [1]
// Output: 0
//
//
// Constraints:
//
// 1 <= nums.length <= 104
// -105 <= nums[i] <= 105
//
// Runtime: 2 ms, faster than 67.42% of Java online submissions for Shortest Unsorted Continuous Subarray.
// Memory Usage: 51.8 MB, less than 8.19% of Java online submissions for Shortest Unsorted Continuous Subarray.
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 1) return 0;
        int max = nums[0];
        int end = 0;
        for (int i = 0; i < nums.length; i ++){
            max = Math.max(max, nums[i]);
            if (nums[i] < max)
                end = i;
        }
        if (end == 0) return 0;
        int min = nums[nums.length - 1];
        int begin = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i --){
            min = Math.min(min, nums[i]);
            if (nums[i] > min)
                begin = i;
        }
    
        return end - begin + 1;
    }
}