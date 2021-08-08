// 1250. Check If It Is a Good Array
// Given an array nums of positive integers. Your task is to select some subset of nums, multiply each element by an integer and add all these numbers. The array is said to be good if you can obtain a sum of 1 from the array by any possible subset and multiplicand.
//
// Return True if the array is good otherwise return False.
//
//
//
// Example 1:
//
// Input: nums = [12,5,7,23]
// Output: true
// Explanation: Pick numbers 5 and 7.
// 5*3 + 7*(-2) = 1
// Example 2:
//
// Input: nums = [29,6,10]
// Output: true
// Explanation: Pick numbers 29, 6 and 10.
// 29*1 + 6*(-3) + 10*(-1) = 1
// Example 3:
//
// Input: nums = [3,6]
// Output: false
//
//
// Constraints:
//
// 1 <= nums.length <= 10^5
// 1 <= nums[i] <= 10^9
//
// Runtime: 2 ms, faster than 97.64% of Java online submissions for Check If It Is a Good Array.
// Memory Usage: 49 MB, less than 32.28% of Java online submissions for Check If It Is a Good Array.
class Solution {
    public boolean isGoodArray(int[] nums) {
        int base = nums[0];
        for (int i = 0; i < nums.length; i++) {
            base = gcd(nums[i], base);
            if (base == 1) return true; 
        }
        return false;
    }
    
    private int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        return a % b == 0 ? b : gcd(b, a % b);
    }
}