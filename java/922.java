// 922. Sort Array By Parity II
// Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
//
// Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
//
// Return any answer array that satisfies this condition.
//
//
//
// Example 1:
//
// Input: nums = [4,2,5,7]
// Output: [4,5,2,7]
// Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
// Example 2:
//
// Input: nums = [2,3]
// Output: [2,3]
//
//
// Constraints:
//
// 2 <= nums.length <= 2 * 104
// nums.length is even.
// Half of the integers in nums are even.
// 0 <= nums[i] <= 1000

// Runtime: 3 ms, faster than 59.68% of Java online submissions for Sort Array By Parity II.
// Memory Usage: 40.2 MB, less than 73.82% of Java online submissions for Sort Array By Parity II.
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int odd = 1;
        int even = 0;
        while (odd < nums.length && even < nums.length) {
            if (nums[odd] % 2 == 1) odd = odd + 2;
            else if (nums[even] % 2 == 0) even = even + 2;
            else if (nums[odd] % 2 == 0 && nums[even] % 2 == 1) {
                int temp = nums[odd];
                nums[odd] = nums[even];
                nums[even] = temp;
                odd = odd + 2;
                even = even + 2;
            }
        }
        return nums;
    }
}

