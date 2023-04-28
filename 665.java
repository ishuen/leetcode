// 665. Non-decreasing Array
//
// Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
//
// We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
//
//
//
// Example 1:
//
// Input: nums = [4,2,3]
// Output: true
// Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
// Example 2:
//
// Input: nums = [4,2,1]
// Output: false
// Explanation: You cannot get a non-decreasing array by modifying at most one element.
//
//
// Constraints:
//
// n == nums.length
// 1 <= n <= 104
// -105 <= nums[i] <= 105
//
//
// Runtime 1 ms Beats 93.77%
// Memory 44.3 MB Beats 13.6%
class Solution {
    public boolean checkPossibility(int[] nums) {
        int err = 0;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] < nums[i-1]) {
                err++;
                if (err > 1 || (i > 1 && i < nums.length - 1 && nums[i - 2] > nums[i] && nums[i + 1] < nums[i - 1]))
                    return false;
            }
        return true;
    }
}

// 2 5 3 1 x
//     ^
// 5 4 3 2 x
//     ^
// 2 2 4 2 2 2 v
// 2 2 4 2 3 2 x