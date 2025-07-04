// 287. Find the Duplicate Number
// Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
//
// There is only one repeated number in nums, return this repeated number.
//
// You must solve the problem without modifying the array nums and uses only constant extra space.
//
//
//
// Example 1:
//
// Input: nums = [1,3,4,2,2]
// Output: 2
// Example 2:
//
// Input: nums = [3,1,3,4,2]
// Output: 3
// Example 3:
//
// Input: nums = [1,1]
// Output: 1
// Example 4:
//
// Input: nums = [1,1,2]
// Output: 1
//
//
// Constraints:
//
// 1 <= n <= 105
// nums.length == n + 1
// 1 <= nums[i] <= n
// All the integers in nums appear only once except for precisely one integer which appears two or more times.
//
//
// Follow up:
//
// How can we prove that at least one duplicate number must exist in nums?
// Can you solve the problem in linear runtime complexity?
//
// Runtime: 6 ms, faster than 43.57% of Java online submissions for Find the Duplicate Number.
// Memory Usage: 56.5 MB, less than 50.04% of Java online submissions for Find the Duplicate Number.
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[nums.length - 1];
        int fast = nums[nums[nums.length - 1] - 1];
        
        while (slow != fast) {
            slow = nums[slow - 1];
            fast = nums[nums[fast - 1] - 1];
        }
        slow = nums.length;
        while (slow != fast) {
            slow = nums[slow - 1];
            fast = nums[fast - 1];
        }
        return slow;
    }
}

// linked list cycle