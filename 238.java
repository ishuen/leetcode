// 238. Product of Array Except Self
// Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
//
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
// You must write an algorithm that runs in O(n) time and without using the division operation.
//
// Example 1:
//
// Input: nums = [1,2,3,4]
// Output: [24,12,8,6]
// Example 2:
//
// Input: nums = [-1,1,0,-3,3]
// Output: [0,0,9,0,0]
//
// Constraints:
//
// 2 <= nums.length <= 105
// -30 <= nums[i] <= 30
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
//
// Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
//
// Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
// Memory Usage: 49.8 MB, less than 51.83% of Java online submissions for Product of Array Except Self.
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] products = new int[nums.length];
        products[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            products[i] = products[i - 1] * nums[i - 1];
        }
        int base = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            base = base * nums[i + 1];
            products[i] = products[i] * base;
        }
        return products;
    }
}

//   0, 1, 2, 3
//   1, 2, 3, 4
// [    1, 2, 6]
// [ 24, 12, 4, 1]

