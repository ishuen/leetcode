// 324. Wiggle Sort II
// Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
//
// You may assume the input array always has a valid answer.
//
//
//
// Example 1:
//
// Input: nums = [1,5,1,1,6,4]
// Output: [1,6,1,5,1,4]
// Explanation: [1,4,1,5,1,6] is also accepted.
// Example 2:
//
// Input: nums = [1,3,2,2,3,1]
// Output: [2,3,1,3,1,2]
//
//
// Constraints:
//
// 1 <= nums.length <= 5 * 104
// 0 <= nums[i] <= 5000
// It is guaranteed that there will be an answer for the given input nums.
//
// Runtime: 3 ms, faster than 71.61% of Java online submissions for Wiggle Sort II.
// Memory Usage: 41.2 MB, less than 97.18% of Java online submissions for Wiggle Sort II.
class Solution {
    public void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int right = copy.length - 1;
        int left = copy.length % 2 == 1 ? copy.length / 2 : copy.length / 2 - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = copy[left];
                left--;
            } else {
                nums[i] = copy[right];
                right--;
            }
        }
    }
}