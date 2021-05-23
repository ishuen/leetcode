// 75. Sort Colors
// Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
//
// We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
//
// You must solve this problem without using the library's sort function.
//
//
//
// Example 1:
//
// Input: nums = [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]
// Example 2:
//
// Input: nums = [2,0,1]
// Output: [0,1,2]
// Example 3:
//
// Input: nums = [0]
// Output: [0]
// Example 4:
//
// Input: nums = [1]
// Output: [1]
//
//
// Constraints:
//
// n == nums.length
// 1 <= n <= 300
// nums[i] is 0, 1, or 2.
//
// Runtime: 0 ms, faster than 100.00% of Java online submissions for Sort Colors.
// Memory Usage: 37.5 MB, less than 60.25% of Java online submissions for Sort Colors.
class Solution {
    public void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i] == 1) {
                one++;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if (i < zero) {
                nums[i] = 0;
            } else if (i < zero + one) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}

// 0, 1, 2
// length >> 3, colors
// traverse and get count of each color
