// 713. Subarray Product Less Than K
// Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.
//
//
//
// Example 1:
//
// Input: nums = [10,5,2,6], k = 100
// Output: 8
// Explanation: The 8 subarrays that have product less than 100 are:
// [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
// Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
// Example 2:
//
// Input: nums = [1,2,3], k = 0
// Output: 0
//
//
// Constraints:
//
// 1 <= nums.length <= 3 * 104
// 1 <= nums[i] <= 1000
// 0 <= k <= 106
//
// Runtime: 6 ms, faster than 34.67% of Java online submissions for Subarray Product Less Than K.
// Memory Usage: 46.1 MB, less than 56.74% of Java online submissions for Subarray Product Less Than K.
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int lastIndex = nums.length;
        int rightLen = 0;
        int rightProduct = 1;
        int count = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < k) {
                if (lastIndex == nums.length) lastIndex = i;
                count++;
                int product = nums[i] * rightProduct;
                while (product >= k) {
                    rightProduct = rightProduct / nums[lastIndex];
                    product = nums[i] * rightProduct;
                    lastIndex--;
                    rightLen--;
                }
                count = count + rightLen;
                rightLen++;
                rightProduct = product;
            } else {
                rightLen = 0;
                rightProduct = 1;
                lastIndex = nums.length;
            }
        }
        return count;
    }
}

