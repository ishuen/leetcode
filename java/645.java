// 645. Set Mismatch
// You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
//
// You are given an integer array nums representing the data status of this set after the error.
//
// Find the number that occurs twice and the number that is missing and return them in the form of an array.
//
//
//
// Example 1:
//
// Input: nums = [1,2,2,4]
// Output: [2,3]
// Example 2:
//
// Input: nums = [1,1]
// Output: [1,2]
//
//
// Constraints:
//
// 2 <= nums.length <= 104
// 1 <= nums[i] <= 104
//
// Runtime 3 ms Beats 43.54%
// Memory 44.2 MB Beats 53.92%
class Solution {
    public int[] findErrorNums(int[] nums) {
        int duplicated = -1;
        int missing = -1;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                duplicated = nums[i];
            } else {
                nums[index] = -1 * nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                missing = i + 1;
                break;
            }
        }
        return new int[]{Math.abs(duplicated), missing};
    }
}


// [1 2 3 4 5 6]
// [3,-2,-3,-4,-6,-5] 