// 152. Maximum Product Subarray
// Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
//
// It is guaranteed that the answer will fit in a 32-bit integer.
//
// A subarray is a contiguous subsequence of the array.
//
//
//
// Example 1:
//
// Input: nums = [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.
// Example 2:
//
// Input: nums = [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
//
//
// Constraints:
//
// 1 <= nums.length <= 2 * 104
// -10 <= nums[i] <= 10
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
//
// Runtime: 131 ms, faster than 5.42% of Java online submissions for Maximum Product Subarray.
// Memory Usage: 40 MB, less than 6.92% of Java online submissions for Maximum Product Subarray.
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int rowMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            rowMax = nums[i];
            int cur = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                cur = cur * nums[j];
                if (cur > rowMax) rowMax = cur;
            }
            if (rowMax > max) max = rowMax;
        } 
        return max;
    }
}

// Runtime: 3 ms, faster than 19.67% of Java online submissions for Maximum Product Subarray.
// Memory Usage: 39.8 MB, less than 9.58% of Java online submissions for Maximum Product Subarray.
class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int localMin = 1;
        int localMax = 1;
        for (int i = 0; i < nums.length; i++) {
            int prod1 = localMin * nums[i];
            int prod2 = localMax * nums[i];
            localMin = Math.min(Math.min(prod1, prod2), nums[i]);
            localMax = Math.max(Math.max(prod1, prod2), nums[i]);
            if (localMax > max) max = localMax;
        } 
        return max;
    }
}

